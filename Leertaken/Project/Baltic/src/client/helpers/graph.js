var Graph = {};

Graph._stations = {};

Graph.getStartDate = function() {
	return new Date() - 60 * 60 * 1000;
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

	stations.forEach( function( stn ) {
		station = app.collections.stations.findOne( { stn: stn } );
		station.color = color( stn );

		self._stations[stn] = station;
	} );

	Session.set( 'graph-stations', new Date() );

	app.subscriptions.graphMeasurements = Meteor.subscribe( 'measurementAverages', stations, this.getStartDate(), this.getStopDate(), function() {
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

Graph._drawGraph = function( measurements, $node, yDomain, yText, valueKey ) {
	var stations = this.getStations();

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

	var xAxis = d3.svg.axis()
		.scale( x )
		.orient( 'bottom' )
		;

	var yAxis = d3.svg.axis()
		.scale( y )
		.orient( 'left' )
		;

	var line = d3.svg.line()
		.x( function( d ) { return x( d.value.datetime ); } )
		.y( function( d ) { return y( d.value[valueKey] || 0 ); } )
		;

	var svg = d3.select( $node[0] ).append( 'svg' )
		.attr( 'width', width + margin.left + margin.right )
		.attr( 'height', height + margin.top + margin.bottom )
		.append( 'g' )
		.attr( 'transform', 'translate(' + margin.left + ',' + margin.top + ')' )
		;

	x.domain( [ this.getStartDate(), this.getStopDate() ] );
	y.domain( yDomain );

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
};

Graph._drawTemperatureGraph = function( measurements ) {
	this._drawGraph(
		measurements,
		this.getTemperatureGraph(),
		[ -40, 60 ],
		'Temperature (C°)',
		'avg_temp'
	);
};

Graph._drawHumidityGraph = function( measurements ) {
	this._drawGraph(
		measurements,
		this.getHumidityGraph(),
		[ 0, 100 ],
		'Humidity (%)',
		'avg_humi'
	);
};

Graph.drawGraphs = function() {
	var measurements = this.getMeasurements();

	window._lastMeasurements = measurements;

	// console.log(measurements);

	this._drawTemperatureGraph( measurements );
	this._drawHumidityGraph( measurements );
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
	return {
		stations: _.values( Graph.getStations() )
	};
};

Template.graph.created = function() {
	Graph.init();
};

Template.graph.events = {
	'click #graph-legend .station .toggle': function stationClick( e ) {
		var $checkbox = $(e.target);
		var stn = this.stn;
		var stations = Graph.getStations();

		for( var i in stations ) {
			if( stations[i].stn == stn ) {
				stations[i].hide = ! $checkbox.prop( 'checked' );
			}
		}

		Graph.drawGraphs();
	}
};

app.Graph = Graph;