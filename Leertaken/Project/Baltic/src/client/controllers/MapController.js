app.controllers.MapController = RouteController.extend({
	waitOn: function() {
		var stations = Meteor.subscribe('balticStations');
		var measurements = Meteor.subscribe('measurements');

		return [
			stations,
			measurements
		];
	},

	onBeforeAction: function() {
	},

	onRun: function() {
	},

	actionMap: function() {
		// if(this.ready()) {
			this.template = 'map';
			this.render();
		// }
	}
});