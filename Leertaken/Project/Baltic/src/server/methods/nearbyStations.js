Meteor.methods({
	'nearbyStations': function(distance) {
		var stations = app.collections.stations.find({
			position: {
				$near: {
					$geometry: {
						type: "Point",
						coordinates: [54.41, 25.17]
					},
					$maxDistance: distance * 1000
				}
			}
		}).fetch();

		return stations;
	}
})