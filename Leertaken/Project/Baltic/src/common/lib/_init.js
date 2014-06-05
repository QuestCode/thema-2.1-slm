app = {
	controllers: {},
	collections: {},
	schemas: {},
	models: {}
}

Meteor.startup(function() {
	var stations = app.collections.stations.find({
		position: {
			$near: {
				$geometry: {
					type: "Point",
					coordinates: [54.41, 25.17]
				},
				$maxDistance: 100 * 1000
			}
		}
	}).fetch();

	for(var i = 0; i < stations.length; i++) {
		console.log(stations[i].getDoc());
	}
});