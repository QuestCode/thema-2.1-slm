Meteor.publish( 'measurementAverages', function( stations, startDate, stopDate ) {
	if(startDate instanceof Date) {
		startDate.setSeconds(0);
		startDate.setMilliseconds(0);
		startDate = moment(startDate);
	}
	if(stopDate instanceof Date) {
		stopDate.setSeconds(0);
		stopDate.setMilliseconds(0);
		stopDate = moment(stopDate);
	}

	var timestamps = [];

	var oneHour = new moment(0).add('hours', 1).valueOf();
	var oneDay = new moment(0).add('days', 1).valueOf();
	var oneWeek = new moment(0).add('weeks', 1).valueOf();
	var oneMonth = new moment(0).add('months', 1).valueOf();

	var range = stopDate.diff(startDate);

	if( range <= oneHour ) {
		var step = new moment(0).add('minutes', 1);
	}
	else if( range <= oneDay ) {
		var step = new moment(0).add('minutes', 5);
	}
	else if( range <= oneWeek ) {
		var step = new moment(0).add('minutes', 30);
	}
	else if( range <= oneMonth ) {
		var step = new moment(0).add('hours', 3);
	}
	else {
		var step = new moment(0).add('hours', 3);
	}

	while( startDate < stopDate ) {
		startDate.add(step);
		
		var timestamp = moment(startDate).toDate();
		timestamp.setSeconds(0);
		timestamp.setMilliseconds(0);

		timestamps.push(timestamp);
	}

	var query = {
		'value.stn': { $in: stations },
		'value.datetime': { $in: timestamps }
	};

	return app.collections.measurementAverages.find( query );
} );