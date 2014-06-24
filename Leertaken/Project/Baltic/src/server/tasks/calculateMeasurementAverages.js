function calculateMeasurementAverages( datetime ) {
	console.log( 'Calculating measurement averages for minute: ' + new Date(datetime) );

	var path = Meteor.require('path');
	var exec = Meteor.require('child_process').exec;

	var script = path.resolve('/vagrant/scripts/db.calculateMeasurementAverages.js');
	var eval = 'var datetime=' + datetime;
	var command = 'mongo 10.0.2.2/meteor --eval "' + eval + '" ' + script

	var child = exec(command, function(err, stdout, stderr) {
		if(err) {
			throw err;
		}

		if(stderr) {
			console.error(stderr);
		}
	});
}

Meteor.startup(function() {
	Meteor.setInterval( function() {
		// Calculate averages from previous minute
		calculateMeasurementAverages( new Date() - 60 * 1000 );
	}, 60 * 1000 );
});