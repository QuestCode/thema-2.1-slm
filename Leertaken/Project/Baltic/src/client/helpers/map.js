var WorldMap = {};

function fixCasing( str ) {
	str = ( '' + str ).toLowerCase();
	var f = str.charAt( 0 ).toUpperCase();
	return f + str.substr( 1 );
}

WorldMap.getStations = function() {
	return app.collections.stations.find().fetch();
};

WorldMap._drawMap = function() {
	this._width = 970;
	this._height = 600;

	this._projection = d3.geo.mercator()
		.scale(1)
		.translate([0, 0]);

	this._path = d3.geo.path()
		.projection(this._projection);
};

WorldMap._drawHexbin = function(svg, hexbin, stations) {
	var self = this;

	stations.forEach(function(d) {
		var p = self._projection(d.position.coordinates);
		d[0] = p[0];
		d[1] = p[1];
	});

	svg.append('g')
		.attr('class', 'hexbin')
		.selectAll('path')
		.data(hexbin(stations))
		.enter().append('path')
			.attr('class', 'hexagon')
			.attr('d', function(d) { return hexbin.hexagon(); })
			.attr('transform', function(d) { return 'translate(' + d.x + ',' + d.y + ')'; })
			.style('fill', 'red')
			.style('stroke', '')
			.on('mouseover', function( stations ) {
				self._stations = stations;
				// Hackish, I know
				var list = _.groupBy( stations, 'country' );
				var html = '';
				for( var stn in list ) {
					if( html ) {
						html += '<br/><br/>';
					}
					html += fixCasing( list[stn][0].country ) + '<br/>- ' +
						_.pluck( list[stn], 'name' ).map( fixCasing ).join( '<br/>- ' );
				}
				self._$tooltip.html( html );
			} );
};

WorldMap._center = function(object, zoom) {
	var bounds = this._path.bounds(object);

	var scale = zoom / Math.max(
		(bounds[1][0] - bounds[0][0]) / this._width,
		(bounds[1][1] - bounds[0][1]) / this._height);
	var translate = [
		(this._width - scale * (bounds[1][0] + bounds[0][0])) / 2,
		(this._height - scale * (bounds[1][1] + bounds[0][1])) / 2
	];

	this._projection
		.scale(scale)
		.translate(translate);
};

WorldMap._drawWorldMap = function() {
	var self = this;
	this._drawMap();

	d3.json('geo/world.json', function(err, world) {
		var countries = topojson.feature(world, world.objects.world);
		var stations = self.getStations();

		self._center(countries, 1);

		var svg = d3.select('#map').append('svg')
			.attr('width', self._width)
			.attr('height', self._height);

		svg.append('g')
			.attr('id', 'countries')
			.selectAll('path')
			.data(countries.features)
			.enter().append('path')
				.attr('class', 'country')
				.attr('name', function(d) { return d.properties.name; })
				.attr('d', self._path);

		var hexbin = d3.hexbin()
			.size([self._width, self._height])
			.radius(2);

		self._drawHexbin(svg, hexbin, stations);

		Session.set( 'map-isReady', true );
	});
};

WorldMap._drawBalticMap = function() {
	var self = this;
	this._drawMap();

	d3.json('geo/baltic.json', function(err, baltic) {
		var countries = topojson.feature(baltic, baltic.objects.countries);
		var seas = topojson.feature(baltic, baltic.objects.seas);
		var stations = self.getStations();

		self._center(seas, 0.85);

		var svg = d3.select('#map').append('svg')
			.attr('width', self._width)
			.attr('height', self._height);

		svg.append('g')
			.attr('id', 'countries')
			.selectAll('path')
			.data(countries.features)
			.enter().append('path')
				.attr('class', 'country')
				.attr('name', function(d) { return d.properties.name; })
				.attr('d', self._path);

		svg.append('g')
			.attr('id', 'borders')
			.append('path')
				.datum(topojson.mesh(baltic, baltic.objects.countries, function(a, b) { return a !== b; }))
				.attr('d', self._path)
				.attr('class', 'borders');

		var hexbin = d3.hexbin()
			.size([self._width, self._height])
			.radius(5);

		self._drawHexbin(svg, hexbin, stations);

		Session.set( 'map-isReady', true );
	});
};

WorldMap.showWorld = function() {
	var self = this;

	Session.set( 'map-isReady', false );

	this._$map.empty();
	this._$worldToggle.addClass( 'active' );
	this._$balticToggle.removeClass( 'active' );
	app.Graph.setStations( [] );

	if( app.subscriptions.map ) {
		app.subscriptions.map.stop();
	}
	app.subscriptions.map = Meteor.subscribe( 'stations', function() {
		self._drawWorldMap();
	} );
};

WorldMap.showBalticSea = function() {
	var self = this;

	Session.set( 'map-isReady', false );

	this._$map.empty();
	this._$worldToggle.removeClass( 'active' );
	this._$balticToggle.addClass( 'active' );
	app.Graph.setStations( [] );

	if( app.subscriptions.map ) {
		app.subscriptions.map.stop();
	}
	app.subscriptions.map = Meteor.subscribe( 'balticStations', function() {
		self._drawBalticMap();
	} );
};

WorldMap.init = function() {
	var self = this;
	if( this._init ) {
		return;
	}

	this._$worldToggle = $( '#toggle-world' );
	this._$balticToggle = $( '#toggle-baltic' );
	this._$map = $( '#map' );
	this._$tooltip = $( '#map-tooltip' );
	this.showBalticSea();

	this._$map.on( 'click', function( e ) {
		e.preventDefault();
		if( self._stations ) {
			app.Graph.setStations( _.pluck( self._stations, 'stn' ) );
		}
	} );
	this._$map.on( 'dblclick, selectstart', function( e ) {
		e.preventDefault();
		return false;
	} );

	this._init = true;
};

Template.map.isReady = function() {
	return Session.get( 'map-isReady' );
};

Template.map.rendered = function() {
	WorldMap.init();
};

app.WorldMap = WorldMap;