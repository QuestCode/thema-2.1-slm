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
			},
			{
				username: 'stadman',
				password: 'aleksandro',
				email: 'stadman@aleksandro.lt',
				profile: {}
			},
			{
				username: 'wempe',
				password: 'aleksandro',
				email: 'wempe@aleksandro.lt',
				profile: {}
			}, 
			{
				username: 'bredek',
				password: 'aleksandro',
				email: 'bredek@aleksandro.lt'
			}
		];

		for(var i = 0; i < users.length; i++) {
			Accounts.createUser(users[i]);
		}
	}
});