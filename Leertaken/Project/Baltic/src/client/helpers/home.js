Template.home.events = {
	'click #search': function(event) {
		var distance = $(event.target).data('km') * 1000;
		console.log(distance);
		
		Session.set('distance', distance);
	}
}

Template.home.getNearbyStations = function() {
	return app.collections.stations.find().fetch();
}