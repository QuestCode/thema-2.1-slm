app.controllers.HomeController = RouteController.extend({
	actionHome: function() {
		this.template = 'home';
		this.render();
	}
});