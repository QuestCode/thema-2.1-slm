app.controllers.HomeController = RouteController.extend({
	waitOn: function() {
		var distance = Session.get('distance');
		return this.subscribe('nearbyStations', distance);
	},

	onBeforeAction: function() {
		this.render('loading');
	},

	onRun: function() {
		Session.setDefault('distance', 50);
	},

	actionHome: function() {
		if(!this.ready()) {
			this.render('loading');
		}
		else {
			this.template = 'home';
			this.render();
		}
	}
});