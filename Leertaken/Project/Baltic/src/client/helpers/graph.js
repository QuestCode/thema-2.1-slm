var Graph = {};

Graph.setStations = function( stations ) {
	if( app.subscriptions.graphMeasurements ) {
		app.subscriptions.graphMeasurements.stop();
	}

	app.subscriptions.graphMeasurements = Meteor.subscribe( 'measurementAverages', [ this.stn ], new Date() - 10 * 60 * 1000 );
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

Graph.drawGraphs = function() {
	var $temp = this.getTemperatureGraph();
	var $humi = this.getHumidityGraph();

	$temp.empty();
	$humi.empty();

	var data = [4, 8, 15, 16, 23, 42];

	var x = d3.scale.linear()
		.domain([0, d3.max(data)])
		.range([0, 420]);

	d3.select($temp[0])
		.selectAll("div")
		.data(data)
		.enter().append("div")
		.style("width", function(d) { return x(d) + "px"; })
		.text(function(d) { return d; });
};

Template.graph.events = {
	'click .station': function stationClick( e ) {
		e.preventDefault();

		Graph.setStations( [ this.stn ] );
	}
};