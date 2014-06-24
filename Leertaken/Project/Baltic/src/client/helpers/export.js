var Export = {};

Export.make = function( stations, startDate, stopDate ) {
	if( ! stations ) {
		console.error( 'Please select a station first.' );
		return;
	}
	if( ! Array.isArray( stations ) ) {
		stations = [ stations ];
	}
	if( ! ( startDate instanceof Date ) ) {
		startDate = new Date( startDate );
	}
	if( ! ( stopDate instanceof Date ) ) {
		stopDate = ( stopDate ? new Date( stopDate ) : new Date() );
	}

	window.location.href = '/export/' + stations.join( ',' ) + '/' + startDate.getTime() + '/' + stopDate.getTime();
};

Export.lastDay = function() {
	var prev = new Date();
	prev.setDate( prev.getDate() - 1 );
	this.make( app.Graph.getStations( true ), prev );
};

Export.lastWeek = function() {
	var prev = new Date();
	prev.setDate( prev.getDate() - 7 );
	this.make( app.Graph.getStations( true ), prev );
};

Export.lastMonth = function() {
	var prev = new Date();
	prev.setMonth( prev.getMonth() - 1 );
	this.make( app.Graph.getStations( true ), prev );
};

app.Export = Export;