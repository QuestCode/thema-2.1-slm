var WorldMap = {};

WorldMap.getStations = function() {
	return app.collections.stations.find().fetch();
};

WorldMap._drawWorldMap = function() {
	// ..
};

WorldMap._drawBalticMap = function() {
	var self = this;

	d3.json('geo/baltic.json', function(err, baltic) {

		var countries = topojson.feature(baltic, baltic.objects.countries);
		var seas = topojson.feature(baltic, baltic.objects.seas);
		var stations = self.getStations();

		var width = 970;
		var height = 600;

		var svg = d3.select('#map').append('svg')
			.attr('width', width)
			.attr('height', height);

		var projection = d3.geo.mercator()
			.scale(1)
			.translate([0, 0]);

		var path = d3.geo.path()
			.projection(projection);

		var bounds = path.bounds(seas);

		var scale = 0.85 / Math.max(
			(bounds[1][0] - bounds[0][0]) / width,
			(bounds[1][1] - bounds[0][1]) / height);
		var translate = [
			(width - scale * (bounds[1][0] + bounds[0][0])) / 2,
			(height - scale * (bounds[1][1] + bounds[0][1])) / 2
		];

		projection
			.scale(scale)
			.translate(translate);

		svg.append('g')
			.attr('id', 'countries')
			.selectAll('path')
			.data(countries.features)
			.enter().append('path')
				.attr('class', 'country')
				.attr('name', function(d) { return d.properties.name; })
				.attr('d', path);

		svg.append('g')
			.attr('id', 'seas')
			.selectAll('path')
			.data(seas.features)
			.enter().append('path')
				.attr('class', 'sea')
				.attr('name', function(d) { return d.properties.name; })
				.attr('d', path);

		svg.append('g')
			.attr('id', 'borders')
			.append('path')
				.datum(topojson.mesh(baltic, baltic.objects.countries, function(a, b) { return a !== b; }))
				.attr('d', path)
				.attr('class', 'borders');

		var hexbin = d3.hexbin()
			.size([width, height])
			.radius(15);

		stations.forEach(function(d) {
			var p = projection(d.position.coordinates);
			d[0] = p[0];
			d[1] = p[1];
			});

		var color = d3.scale.linear()
			.domain([0, 40])
			.range(["#777", "#ddd"]);

		svg.append('g')
			.attr('class', 'hexagons')
		.selectAll('path')
			.data(hexbin(stations))
		.enter().append('path')
			.attr('class', 'hexagon')
			.attr('d', function(d) { return hexbin.hexagon(); })
			.attr('transform', function(d) { return 'translate(' + d.x + ',' + d.y + ')'; })
			.style('fill', function(stations) {
				var stns = _.pluck(stations, 'stn');

				var measurements = app.collections.measurements.find({
					stn: { $in: stns }
				}).fetch();

				var temp = _.reduce(measurements, function(memo, m) { return memo + m.wdsp; }, 0);
				temp = temp / measurements.length;

				if(isNaN(temp)) {
					temp = 0;
				}

				stations.temp = temp;

				return color(temp);
			})
		.style('stroke', function(stations) {
			return color(stations.temp);
		});
	});
};

WorldMap.showWorld = function() {
	this._$map.empty();
	this._$worldToggle.addClass( 'active' );
	this._$balticToggle.removeClass( 'active' );
	this._drawWorldMap();
	app.Graph.setStations( [] );
};

WorldMap.showBalticSea = function() {
	this._$map.empty();
	this._$worldToggle.removeClass( 'active' );
	this._$balticToggle.addClass( 'active' );
	this._drawBalticMap();
	app.Graph.setStations( [] );
};

WorldMap.init = function() {
	if( ! this._init ) {
		this._$map = $( '#map' );
		this._$worldToggle = $( '#toggle-world' );
		this._$balticToggle = $( '#toggle-baltic' );
		this.showBalticSea();
	}
	this._init = true;
};

Template.map.rendered = function() {
	WorldMap.init();
};

app.WorldMap = WorldMap;