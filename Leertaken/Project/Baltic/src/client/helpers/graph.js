var Graph = {};

Graph._stations = {};

Graph.getStartDate = function() {
	var start = new Date();

	if( $( '#toggle-graph-week input:radio:checked' ).length ) {
		start.setDate( start.getDate() - 7 ); // Week
	} else if( $( '#toggle-graph-month input:radio:checked' ).length ) {
		start.setMonth( start.getMonth() - 1 ); // Month
	} else {
		start.setDate( start.getDate() - 1 ); // Day
	}

	return start;
};

Graph.getStopDate = function() {
	return new Date();
};

Graph.setStations = function( stations ) {
	var self = this;

	if( app.subscriptions.graphMeasurements ) {
		app.subscriptions.graphMeasurements.stop();
	}

	this._stations = {};

	var color = d3.scale.category20();
	var station;

	stations.forEach( function( station ) {
		station.color = color( station.stn );

		self._stations[station.stn] = station;
	} );

	Session.set( 'graph-stations', new Date() );

	app.subscriptions.graphMeasurements = Meteor.subscribe( 'measurementAverages', _.pluck(stations, 'stn'), this.getStartDate(), this.getStopDate(), function() {
		self.drawGraphs();
	} );
};

Graph.getStations = function( asArray ) {
	if( asArray ) {
		return Object.keys( this._stations );
	}
	return this._stations;
};

Graph.getMeasurements = function() {
	var measurements = app.collections.measurementAverages.find( {}, { sort: { 'value.datetime': 1 } } ).fetch();

	return _.groupBy( measurements, function( m ){ return m.value.stn; } );
};

Graph.getTemperatureGraph = function() {
	if( ! this._$graphTemp ) {
		this._$graphTemp = $( '#graph-temperature' );
	}
	return this._$graphTemp;
};

Graph.getHumidityGraph = function() {
	if( ! this._$graphHumi ) {
		this._$graphHumi = $( '#graph-humidity' );
	}
	return this._$graphHumi;
};

Graph.getPrecipitationGraph = function() {
	if( ! this._$graphPrcp ) {
		this._$graphPrcp = $( '#graph-precipitation' );
	}
	return this._$graphPrcp;
};

Graph._drawGraph = function( measurements, $node, yDomain, baseline, yText, value, valueFunction ) {
	var stations = this.getStations();
	var _value = value;

	$node.empty();

	if( ! Object.keys( stations ).length ) {
		return;
	}

	var margin = { top: 20, right: 20, bottom: 30, left: 50 },
		width  = 750 - margin.left - margin.right,
		height = 400 - margin.top - margin.bottom;

	var x = d3.time.scale()
		.range( [ 0, width ] )
		;

	var y = d3.scale.linear()
		.range( [ height, 0 ] )
		;

	// // https://raygun.io/blog/2013/04/custom-multi-scale-d3-time-series/
	// var timeFormats = [
	// 	[ d3.time.format.utc( '%Y' ), function() { return true; } ],
	// 	[ d3.time.format.utc( '%B' ), function( d ) { return d.getUTCMonth(); } ],
	// 	[ d3.time.format.utc( '%b %d' ), function( d ) { return d.getUTCDate() !== 1; } ],
	// 	[ d3.time.format.utc( '%a %d' ), function( d ) { return d.getUTCDay() && d.getUTCDate() !== 1; } ],
	// 	[ d3.time.format.utc( '%H:00' ), function( d ) { return d.getUTCHours(); } ],
	// 	[ d3.time.format.utc( '%I %p' ), function( d ) { return false; } ]
	// ];

	// var timeFormatPicker = function( formats ) {
	// 	return function( date ) {
	// 		var i = formats.length - 1, f = formats[i];
	// 		while( ! f[1]( date ) ) {
	// 			f = formats[ --i ];
	// 		}
	// 		return f[0]( date );
	// 	};
	// };

	var xAxis = d3.svg.axis()
		.scale( x )
		.orient( 'bottom' )
		;

	// xAxis.tickFormat( timeFormatPicker( timeFormats ) );

	var yAxis = d3.svg.axis()
		.scale( y )
		.orient( 'left' )
		;

	var line = d3.svg.line()
		.interpolate('monotone')
		.x( function( d ) { return x( d.value.datetime ); } )
		.y( typeof valueFunction === 'function' ? valueFunction( y ) : function( d ) { return y( d.value[value] || 0 ); } )
		;

	var svg = d3.select( $node[0] ).append( 'svg' )
		.attr( 'width', width + margin.left + margin.right )
		.attr( 'height', height + margin.top + margin.bottom )
		.append( 'g' )
		.attr( 'transform', 'translate(' + margin.left + ',' + margin.top + ')' )
		;

	x.domain( [ this.getStartDate(), this.getStopDate() ] );
	y.domain( typeof yDomain === 'function' ? yDomain( d3 ) : yDomain );

	svg.append( 'g' )
		.attr( 'class', 'x axis')
		.attr( 'transform', 'translate(0,' + height + ')' )
		.call( xAxis )
		;

	svg.append( 'g' )
		.attr( 'class', 'y axis' )
		.call( yAxis )
		.append( 'text' )
		.attr( 'transform', 'rotate( -90 )' )
		.attr( 'y', 6 )
		.attr( 'dy', '.71em' )
		.style( 'text-anchor', 'end' )
		.text( yText )
		;

	for( var stn in measurements ) {
		if( stations[stn].hide ) {
			continue;
		}
		svg.append( 'path' )
			.datum( measurements[ stn ] )
			.attr( 'd', line )
			.attr( 'class', 'line' )
			.style( 'stroke', stations[stn].color )
			;
	}

	console.log(baseline);
	if( baseline !== false ) {
		var measurements = [
			{ value: { datetime: this.getStartDate() } },
			{ value: { datetime: this.getStopDate() } },
		];

		measurements[0].value[value] = baseline;
		measurements[1].value[value] = baseline;

		console.log(measurements);

		svg.append( 'path' )
			.datum(measurements)
			.attr( 'd', line )
			.attr( 'class', 'line baseline' )
	}
};

Graph._drawTemperatureGraph = function( measurements ) {
	this._drawGraph(
		measurements,
		this.getTemperatureGraph(),
		[ -40, 60 ],
		0,
		'Temperature (C°)',
		'avg_temp'
	);
};

Graph._drawHumidityGraph = function( measurements ) {
	this._drawGraph(
		measurements,
		this.getHumidityGraph(),
		[ 0, 100 ],
		50,
		'Humidity (%)',
		'avg_humi'
	);
};

Graph._drawPrecipitationGraph = function( measurements ) {
	this._drawGraph(
		measurements,
		this.getPrecipitationGraph(),
		// function( d3 ) { return d3.extent( measurements, function( d ) { console.log(d);return ( d.value.avg_prcp || 0 ) * 10; } ); },
		[ 0, 3 ],
		0.1,
		'Precipitation (cm)',
		'avg_prcp',
		function( y ) { return function( d ) { return y( ( d.value.avg_prcp || 0 ) * 10 ); }; } // Convert to millimeters
	);
};

Graph.clearGraphs = function() {
	this.getTemperatureGraph().empty();
	this.getHumidityGraph().empty();
	this.getPrecipitationGraph().empty();
};

Graph.drawGraphs = function() {
	var measurements = this.getMeasurements();

	window._lastMeasurements = measurements;

	// console.log(measurements);

	this.clearGraphs();

	if( app.WorldMap.isShowingWorldMap() ) {
		this._drawTemperatureGraph( measurements );
		this._drawHumidityGraph( measurements );
	}
	if( app.WorldMap.isShowingBalticSeaMap() ) {
		this._drawPrecipitationGraph( measurements );
	}
};

Graph.init = function() {
	var self = this;
	this._interval = setInterval( function() {
		console.log( 'Redrawing graphs..' );
		self.drawGraphs();
	}, 20 * 1000 );
};

Template.graph.getLegend = function() {
	Session.get( 'graph-stations' );
	var stations = _.values( Graph.getStations() );
	return {
		stations: stations,
		hasAtLeastTwoStations: stations.length > 1
	};
};

Template.graph.created = function() {
	Graph.init();
};

Template.graph.events = {
	'change #graph-legend .station .toggle': function stationClick( e ) {
		var $checkbox = $(e.target);
		var stations = Graph.getStations();

		// All
		if( $checkbox.hasClass( 'all' ) ) {
			$( '#graph-legend .station .toggle:not(.all)' ).prop( 'checked', $checkbox.prop( 'checked' ) ).trigger( 'change' );
			return;
		}

		// Check all if all are checked, else uncheck
		var $boxes = $( '#graph-legend .station .toggle:not(.all)' );

		$( '#graph-legend .station .toggle.all' ).prop( 'checked', $boxes.filter( ':checked' ).length === $boxes.length );

		// Set hiding
		for( var i in stations ) {
			if( stations[i].stn == this.stn ) {
				stations[i].hide = ! $checkbox.prop( 'checked' );
			}
		}

		Graph.drawGraphs();
	},
	'change #graph-controls input:radio': function( e ) {
		Graph.drawGraphs();
	}
};

app.Graph = Graph;