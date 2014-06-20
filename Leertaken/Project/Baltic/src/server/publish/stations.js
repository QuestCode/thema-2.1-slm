Meteor.publish('stations', function() {
	return app.collections.stations.find({
		country: { 
			$in: [
				'LITHUANIA',
				'DENMARK',
				'SWEDEN',
				'FINLAND',
				'POLAND',
				'GERMANY',
				'LATVIA',
				'RUSSIA',
				'NORWAY',
				'ESTONIA'
			]
		}
	});
});