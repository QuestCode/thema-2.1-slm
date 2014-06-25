var WorldMap = {};

WorldMap.getStations = function() {
	return this._stations;
};

WorldMap.isShowingWorldMap = function() {
	return this._currentMap === 'world';
};

WorldMap.isShowingBalticSeaMap = function() {
	return this._currentMap === 'baltic-sea';
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

WorldMap._drawHexbin = function(svg, hexbin, stations, fillFunction) {
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
			.attr('d', function(d) { return hexbin.hexagon(self._radius(d.length)); })
			.attr('transform', function(d) { return 'translate(' + d.x + ',' + d.y + ')'; })
			.style('fill', fillFunction)
			.style('stroke', 'none')
			.on('mouseover', function( stations ) {
				self._stations = stations;
				// Hackish, I know
				var list = _.groupBy( stations, 'country' );
				var html = '';
				for( var stn in list ) {
					if( html ) {
						html += '<br/><br/>';
					}
					html += app.fixCasing( list[stn][0].country ) + '<br/>- ' +
						_.pluck( list[stn], 'name' ).map( app.fixCasing ).join( '<br/>- ' );
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

WorldMap._drawWorldMap = function( cb ) {
	var self = this;
	this._drawMap();

	this._radius = d3.scale.sqrt()
		.domain([1, 25])
		.range([1.5, 2.5]);

	this._stationsColor = d3.scale.linear()
		.domain([1, 3, 9, 27])
		.range(['#f16913','#d94801','#a63603','#7f2704']);

	d3.json('geo/world.json', function(err, world) {
		if( err ) {
			return cb( err );
		}
		var countries = topojson.feature(world, world.objects.world);
		var stations = self.getStations();

		self._center(countries, 1.05);

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
			.radius(3);

		var fillFunction = function(stations) {
			return self._stationsColor(stations.length);
		}

		self._drawHexbin(svg, hexbin, stations, fillFunction);

		cb();
	});
};

WorldMap._drawBalticMap = function( cb ) {
	var self = this;
	this._drawMap();

	this._radius = d3.scale.sqrt()
		.domain([1, 5])
		.range([3, 12]);

	this._prcpColor = d3.scale.linear()
		.domain([0.1, 0.15, 0.2, 0.25, 0.3, 0.5, 0.8, 1.2])
		.range(['#fee6ce','#fdd0a2','#fdae6b','#fd8d3c','#f16913','#d94801','#a63603','#7f2704']);

	var stationsKeys = _.pluck(this.getStations(), 'stn');


	d3.json('geo/baltic.json', function(err, baltic) {
		if( err ) {
			return cb( err );
		}
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
			.radius(12);

		var fillFunction = function(stations) {
			var totalPrcp = _.reduce(stations, function(prcp, station) {
				var m = app.collections.measurementAreaAverages.findOne({ 'value.stn': station.stn });

				if(m) {
					return prcp + m.value.avg_prcp;
				}

				return prcp;
			}, 0);

			var avgPrcp = totalPrcp / stations.length;

			if(avgPrcp < 0.1) {
				$(this).css('opacity', 0.3);
				return '#444';
			}
			else {
				return self._prcpColor(avgPrcp);
			}
		}
	
		Meteor.subscribe( 'measurementAreaAverages', stationsKeys, null, function() {
			self._drawHexbin(svg, hexbin, stations, fillFunction);

			cb();
		});
	});
};

WorldMap.showWorld = function() {
	var self = this;

	Session.set( 'map-isReady', false );

	this._currentMap = '';
	this._$map.empty();
	this._$worldToggle.addClass( 'active' );
	this._$balticToggle.removeClass( 'active' );
	app.Graph.setStations( [] );

	Meteor.call('stations', function(err, stations) {
		self._stations = stations;

		self._drawWorldMap( function( err ) {
			Session.set( 'map-isReady', true );
			self._currentMap = 'world';
		});
	});
};

WorldMap.showBalticSea = function() {
	var self = this;

	Session.set( 'map-isReady', false );
	Session.set( 'map-currentMap', null );

	this._currentMap = '';
	this._$map.empty();
	this._$worldToggle.removeClass( 'active' );
	this._$balticToggle.addClass( 'active' );
	app.Graph.setStations( [] );

	Meteor.call('stations', app.balticStations, function(err, stations) {
		self._stations = stations;

		self._drawBalticMap( function( err ) {
			Session.set( 'map-isReady', true );
			self._currentMap = 'baltic-sea';
		});
	});
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
			app.Graph.setStations( self._stations );
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