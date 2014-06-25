Meteor.methods({
	'stations': function(stn) {
		if(stn) {
			var stations = app.collections.stations.find({
				stn: { $in: stn }
			}).fetch();
		}
		else {
			var stations = app.collections.stations.find().fetch();
		}

		return stations;
	}
})