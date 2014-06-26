Meteor.methods({
	'measurementAreaAverages': function(stn, datetime) {
		
		var query = {};

		if( datetime ) {
			var datetime = new Date(datetime);
			datetime.setMilliseconds(0);
			datetime.setSeconds(0);
		}
		else {
			var last = app.collections.measurementAverages.findOne({}, { sort: { 'value.datetime': -1 }, limit: 1 });
			var datetime = new Date(last.value.datetime);
			datetime.setMinutes(datetime.getMinutes() - 1);
		}

		if( stn ) {
			query['value.stn'] = { $in: stn };
		}

		query['value.datetime'] = datetime;

		var measurementAverages = app.collections.measurementAverages.find(query).fetch();

		return measurementAverages;
	}
})