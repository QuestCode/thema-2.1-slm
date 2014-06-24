app.controllers.HomeController = RouteController.extend({
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

	actionHome: function() {
		// if(this.ready()) {
			this.template = 'home';
			this.render();
		// }
	}
});