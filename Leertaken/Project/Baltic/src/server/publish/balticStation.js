Meteor.publish('balticStations', function() {
	return app.collections.stations.find({
		stn: {
			$in: app.balticStations
		}
	});
});
