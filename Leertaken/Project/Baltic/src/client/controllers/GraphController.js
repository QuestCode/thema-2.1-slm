app.controllers.GraphController = RouteController.extend({
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

	actionGraph: function() {
		if(this.ready()) {
			this.template = 'graph';
			this.render();
		}
	}
});