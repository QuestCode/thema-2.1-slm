app.controllers.HomeController = RouteController.extend({
	waitOn: function() {
		var stations = Meteor.subscribe('balticStations');

		return [
			stations
		];
	},

	data: function() {
		return {
			stations: app.collections.stations.find().fetch()
		};
	},

	actionHome: function() {
		this.template = 'home';
		this.render();
	}
});