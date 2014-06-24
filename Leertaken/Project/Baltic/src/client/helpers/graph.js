var Graph = {};

Graph._stations = {};

Graph.getStartDate = function() {
	return new Date() - 24 * 60 * 60 * 1000;
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
	var measurements = app.collections.measurementAverages.find( {}, { sort: { datetime: 1 } } ).fetch();

	return _.groupBy( measurements, function( m ){ return m.stn; } );
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

Graph._drawTemperatureGraph = function( measurements ) {
	var $temp = this.getTemperatureGraph();
	var stations = this.getStations();

	$temp.empty();

	var margin = { top: 20, right: 20, bottom: 30, left: 50 },
		width  = 600 - margin.left - margin.right,
		height = 300 - margin.top - margin.bottom;

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
		.x( function( d ) { return x( d.datetime ); } )
		.y( function( d ) { return y( d.avg_temp || 0 ); } )
		;

	var svg = d3.select( $temp[0] ).append( 'svg' )
		.attr( 'width', width + margin.left + margin.right )
		.attr( 'height', height + margin.top + margin.bottom )
		.append( 'g' )
		.attr( 'transform', 'translate(' + margin.left + ',' + margin.top + ')' )
		;

	x.domain( [ this.getStartDate(), this.getStopDate() ] );
	y.domain( [ -40, 60 ] );

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
		.text( 'Temperature (C°)' )
		;

	for( var stn in measurements ) {
		svg.append( 'path' )
			.datum( measurements[ stn ] )
			.attr( 'd', line )
			.attr( 'class', 'line' )
			.style( 'stroke', stations[stn].color )
			;
	}
};

Graph._drawHumidityGraph = function( measurements ) {
	var $humi = this.getHumidityGraph();
	var stations = this.getStations();

	$humi.empty();

	var margin = { top: 20, right: 20, bottom: 30, left: 50 },
		width  = 600 - margin.left - margin.right,
		height = 300 - margin.top - margin.bottom;

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
		.x( function( d ) { return x( d.datetime ); } )
		.y( function( d ) { return y( d.avg_humi || 0 ); } )
		;

	var svg = d3.select( $humi[0] ).append( 'svg' )
		.attr( 'width', width + margin.left + margin.right )
		.attr( 'height', height + margin.top + margin.bottom )
		.append( 'g' )
		.attr( 'transform', 'translate(' + margin.left + ',' + margin.top + ')' )
		;

	x.domain( [ this.getStartDate(), this.getStopDate() ] );
	y.domain( [ 0, 100 ] );

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
		.text( 'Humidity (%)' )
		;

	for( var stn in measurements ) {
		svg.append( 'path' )
			.datum( measurements[ stn ] )
			.attr( 'd', line )
			.attr( 'class', 'line' )
			.style( 'stroke', stations[stn].color )
			;
	}
};

Graph.drawGraphs = function() {
	var measurements = this.getMeasurements();

	window._lastMeasurements = measurements;

	// console.log(measurements);

	this._drawTemperatureGraph( measurements );
	this._drawHumidityGraph( measurements );
};

Template.graph.getLegend = function() {
	Session.get( 'graph-stations' );
	return {
		stations: _.values( Graph.getStations() )
	};
};

Template.graph.events = {
	'click .station': function stationClick( e ) {
		e.preventDefault();

		Graph.setStations( [ this.stn ] );
	}
};

app.Graph = Graph;