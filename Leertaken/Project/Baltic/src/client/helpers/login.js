Template.login.events({
	'submit .form-signin': function login(event) {
		var $form = $(event.target);

		var username = $form.find('[name=username]').val();
		var password = $form.find('[name=password]').val();

		event.preventDefault();
		event.stopPropagation();
		Session.set('loginError', null);

		Meteor.loginWithPassword(username, password, function(err) {
			if(err) {
				console.error(err);

				Session.set('loginError', err.reason);
			}
			else {
				window.location.replace('/');
			}
		});

		return false;
	}
});

Template.login.getLoginError = function() {
	return Session.get('loginError');
}

Template.login.isDisabled = function() {
	if(Meteor.loggingIn()) {
		return 'disabled="disabled"';
	}
}