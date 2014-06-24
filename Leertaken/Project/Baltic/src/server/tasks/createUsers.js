Meteor.startup(function() {
	var users = app.collections.users.find().fetch();

	if(users.length === 0) {
		console.log('Creating initial users.');

		var users = [
			{
				username: 'admin',
				password: 'admin',
				email: 'admin@davincidata.nl',
				profile: {}
			},
			{
				username: 'user',
				password: 'password',
				email: 'user@davincidata.nl',
				profile: {}
			}
		];

		for(var i = 0; i < users.length; i++) {
			Accounts.createUser(users[i]);
		}
	}
});