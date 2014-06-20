app.controllers.LoginController = RouteController.extend({
	onBeforeAction: function() {
		Session.set('loginError', null);
	},

	onAfterAction: function() {
		Session.set('loginError', null);
	},
	
	action: function() {
		this.template = 'login';
		this.render();
	}
});