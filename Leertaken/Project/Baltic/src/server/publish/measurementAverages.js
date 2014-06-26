Meteor.publish( 'measurementAverages', function( stations, startDate, stopDate ) {
	var dateFilter = { $gte: new Date( startDate ) };

	if( stopDate ) {
		dateFilter.$lt = new Date( stopDate );
	}

	var query = {
		'value.stn': { $in: stations },
		'value.datetime': dateFilter
	};

	return app.collections.measurementAverages.find( query );
} );