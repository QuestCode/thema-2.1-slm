app.controllers.HomeController = RouteController.extend({
	waitOn: function() {
		var stations = Meteor.subscribe('stations');

		return [
			stations
		];
	},

	onBeforeAction: function() {
	},

	onRun: function() {
	},

	actionHome: function() {
		if(this.ready()) {
			this.template = 'home';
			this.render();
		}
	}
});