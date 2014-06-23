Meteor.publish( 'measurementAverages', function( stations, startDate, stopDate ) {
	var dateFilter = { $gte: new Date( startDate ) };

	if( stopDate ) {
		dateFilter.$lt = new Date( stopDate );
	}

	return app.collections.measurementAverages.find( {
		stn: {
			$in: stations
		},
		datetime: dateFilter
	} );
} );