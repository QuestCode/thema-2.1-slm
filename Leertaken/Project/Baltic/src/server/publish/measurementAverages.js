Meteor.publish( 'measurementAverages', function( stations, startDate, stopDate ) {
	var dateFilter = { $gte: new Date( startDate ) };

	if( stopDate ) {
		dateFilter.$lt = new Date( stopDate );
	}

	// var timestamps = [];

	// var oneHour = moment(0).add('hours', 1).valueOf();
	// var oneDay = moment(0).add('days', 1).valueOf();
	// var oneMonth = moment(0).add('months', 1).valueOf();

	// var range = moment(startDate).diff(stopDate);

	// if( range < oneHour ) {
	// 	var step = moment(0).add('minutes', 1).valueOf();
	// }

	// while( startDate < stopDate ) {
	// 	startDate += step;
	// 	timestamps += new Date( startDate );
	// }

	// console.log(stations, timestamps);

	var query = {
		'value.stn': { $in: stations },
		'value.datetime': dateFilter
	};

	return app.collections.measurementAverages.find( query );
} );