var path = require('path');
var exec = require('child_process').exec;

function calculateMeasurementAverages( datetime ) {
	console.log( 'Calculating measurement averages for minute: ' + new Date(datetime) );

	var script = path.resolve('./db.calculateMeasurementAverages.js');
	var eval = 'var datetime=' + datetime;
	var command = 'mongo localhost/meteor --eval "' + eval + '" ' + script

	var child = exec(command, function(err, stdout, stderr) {
		if(err) {
			console.error(err);
		}

		if(stderr) {
			console.error(stderr);
		}
	});
}

calculateMeasurementAverages( new Date() - 60 * 1000 );

setInterval( function() {
	// Calculate averages from previous minute
	calculateMeasurementAverages( new Date() - 60 * 1000 );
}, 60 * 1000 );