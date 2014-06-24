Meteor.publish('stations', function() {
	return app.collections.stations.find(
		{}
	);
});