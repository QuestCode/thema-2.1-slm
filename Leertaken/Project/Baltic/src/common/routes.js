Router.map(function(){
	this.route('home', {
		path: '/',
		controller: 'app.controllers.HomeController',
		action: 'actionHome'
	});

	this.route('graph', {
		path: '/graph',
		controller: 'app.controllers.GraphController',
		action: 'actionGraph'
	});

	this.route('login', {
		path: '/login',
		controller: 'app.controllers.LoginController'
	});

	this.route('logout', {
		path: '/logout',
		action: function() {
			Meteor.logout(function(err) {
				Router.go('home');
			});
		}
	});
});

if(Meteor.isClient) {
	// Redirect logged out user to 'login'
	Router.onBeforeAction(function() {
		if(Meteor.userId() === null) {
			this.redirect('login');
		}
	}, {
		except: ['login']
	});

	// Redirect logged in users to 'home'
	Router.onBeforeAction(function() {
		if(Meteor.userId() !== null) {
			this.redirect('home');
		}
	}, {
		only: ['login']
	});
}
