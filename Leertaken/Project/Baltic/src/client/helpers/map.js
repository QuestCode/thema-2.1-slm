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

WorldMap._drawLegend = function(map) {
	var gradient = [];

	if(map === 'baltic-sea') {
		var domain = [0, 0.09999, 0.1, 0.15, 0.2, 0.25, 0.3, 0.5, 0.8, 1.2];
		var colors = this._prcpColor;
		var offset = 0;
	}
	else if(map === 'world') {
		var domain = [-20, -15, -10, -5, 0, 5, 10, 15, 20, 25, 30];
		var colors = this._tempColor;
		var offset = 40;
	}

	var range = domain[domain.length - 1] - domain[0];

	for(index in domain) {
		var value = domain[index];
		var percentage = Math.round(value / range * 100) + offset + '%';

		gradient.push(colors(value) + ' ' + percentage);
	}

	this._$legend
		.css({
			'background-image': 'linear-gradient(left, ' + gradient.join(',') + ')',
			'background-image': '-o-linear-gradient(left, ' + gradient.join(',') + ')',
			'background-image': '-ms-linear-gradient(left, ' + gradient.join(',') + ')',
			'background-image': '-moz-linear-gradient(left, ' + gradient.join(',') + ')',
			'background-image': '-webkit-linear-gradient(left, ' + gradient.join(',') + ')',
		});
}

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
		.domain([1, 18])
		.range([2, 3.5]);

	this._stationsColor = d3.scale.linear()
		.domain([1, 3, 9, 27])
		.range(['#f16913','#d94801','#a63603','#7f2704']);

	this._tempColor = d3.scale.linear()
		.domain([-20, -15, -10, -5, 0, 5, 10, 15, 20, 25, 30])
		.range(['#a50026','#d73027','#f46d43','#fdae61','#fee090','#e0f3f8','#abd9e9','#74add1','#4575b4','#313695'].reverse())

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
			.radius(4);

		// var fillFunction = function(stations) {
		// 	return self._stationsColor(stations.length);
		// }

		// self._drawHexbin(svg, hexbin, stations, fillFunction);

		// cb();

		var fillFunction = function(stations) {
			var totalTemp = _.reduce(stations, function(temp, station) {
				var m = self._averages[station.stn];

				if(m) {
					return temp + m.value.avg_temp;
				}

				return temp;
			}, 0);

			var avgTemp = totalTemp / stations.length;

			return self._tempColor(avgTemp);
		}
	
		Meteor.call( 'measurementAreaAverages', null, null, function(err, averages) {
			self._averages = {};
			averages.forEach( function( average ) {
				self._averages[average.value.stn] = average;
			});

			self._drawHexbin(svg, hexbin, stations, fillFunction);

			cb();
		});
	});
};

WorldMap._drawBalticMap = function( cb ) {
	var self = this;
	this._drawMap();

	this._radius = d3.scale.sqrt()
		.domain([1, 5])
		.range([3, 12]);

	this._prcpColor = d3.scale.linear()
		.domain([0, 0.09999, 0.1, 0.15, 0.2, 0.25, 0.3, 0.5, 0.8, 1.2])
		.range(['#444', '#444', '#fee6ce','#fdd0a2','#fdae6b','#fd8d3c','#f16913','#d94801','#a63603','#7f2704']);


	var stationsKeys = _.pluck(this.getStations(), 'stn');

	d3.json('geo/baltic.json', function(err, baltic) {
		if( err ) {
			return cb( err );
		}
		var countries = topojson.feature(baltic, baltic.objects.countries);
		var seas = topojson.feature(baltic, baltic.objects.seas);
		var stations = self.getStations();

		self._center(seas, 0.85);
		self._drawLegend('baltic-sea');

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
				var m = self._averages[station.stn];

				if(m) {
					return prcp + m.value.avg_prcp;
				}

				return prcp;
			}, 0);

			var avgPrcp = totalPrcp / stations.length;

			if(avgPrcp < 0.1) {
				$(this).css('opacity', 0.3);
			}
			
			return self._prcpColor(avgPrcp);
		}
	
		Meteor.call( 'measurementAreaAverages', stationsKeys, null, function(err, averages) {
			self._averages = {};
			averages.forEach( function( average ) {
				self._averages[average.value.stn] = average;
			});

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
	this._$legend.css('background-image', 'none');
	app.Graph.setStations( [] );

	Meteor.call('stations', function(err, stations) {
		self._stations = stations;

		self._drawWorldMap( function( err ) {
			Session.set( 'map-isReady', true );
			self._currentMap = 'world';
			self._drawLegend('world');
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
	this._$legend.css('background-image', 'none');
	app.Graph.setStations( [] );

	Meteor.call('stations', app.balticStations, function(err, stations) {
		self._stations = stations;

		self._drawBalticMap( function( err ) {
			Session.set( 'map-isReady', true );
			self._currentMap = 'baltic-sea';
			self._drawLegend('baltic-sea');
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
	this._$legend = $( '#map-legend' );
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

	this._$map.on( 'mouseover', '.hexagon', function( e ) {
		self._$tooltip.css( {
			top: e.offsetY,
			left: e.offsetX + 15
		} ).show();
	} );
	this._$map.on( 'mouseleave', '.hexagon', function() {
		self._$tooltip.hide();
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