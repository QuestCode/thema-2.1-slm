Router.map(function(){
	this.route('home', {
		path: '/',
		controller: 'app.controllers.HomeController',
		action: 'actionHome'
	});
});