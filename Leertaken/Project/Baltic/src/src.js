if (Meteor.isClient) {
  Session.set('greeting', 'Welcome to src.')

  Template.hello.greeting = function () {
    return Session.get('greeting');
  };

  Template.hello.events({
    'click input': function () {
      // template data, if any, is available in 'this'
      if (typeof console !== 'undefined')

        Session.set('greeting', "You pressed the button");
    }
  });
}

if (Meteor.isServer) {
  Meteor.startup(function () {
    // code to run on server at startup
  });
}
