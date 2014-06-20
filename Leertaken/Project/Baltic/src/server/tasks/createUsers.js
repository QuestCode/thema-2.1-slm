Meteor.startup(function() {
	var users = app.collections.users.find().fetch();

	if(users.length === 0) {
		var users = [
			{
				username: 'admin',
				password: 'admin',
				email: 'admin@davincidata.nl',
				profile: {}
			}
		];

		for(var i = 0; i < users.length; i++) {
			var user = users[i];

			Accounts.createUser(user);
		}
	}
});