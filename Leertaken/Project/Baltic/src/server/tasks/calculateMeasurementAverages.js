var Future = Npm.require( 'fibers/future' );

Meteor.startup( function() {

	function SDD( T ) {
		var a, b;
		if( T >= 0 ) {
			a = 7.5;
			b = 237.3;
		} else {
			a = 7.6;
			b = 240.7;
		}
		return 6.1078 * Math.exp( ( ( a * T ) / ( b + T ) ) / Math.LOG10E );
	}

	function calculateHumidity( temp, dewp ) {
		if( dewp > temp ) {
			return 100;
		}

		return 100 * SDD( dewp ) / SDD( temp );
	}

	function calculateMeasurementAverages( datetime ) {
		var i, start, stop, future, results;
		var db = MongoInternals.defaultRemoteCollectionDriver().mongo.db;

		start = new Date( datetime );
		start.setSeconds( 0 );
		stop = new Date( datetime );
		stop.setSeconds( 0 );
		stop.setMinutes( stop.getMinutes() + 1 );

		console.log( 'Calculating measurement averages for minute: ' + start );

		future = new Future();
		db.collection( 'measurements' ).aggregate( [
			{ $match: {
				datetime: { $gte: start, $lt: stop }
			} },
			{ $group: {
				_id: "$stn",
				avg_prcp: { $avg: "$prcp" },
				avg_temp: { $avg: "$temp" },
				avg_dewp: { $avg: "$dewp" }
			} }
		], function( err, cursor ) {
			if( err ) {
				future.throw( err );
			}
			future.return( cursor );
		} );

		results = future.wait();

		app.collections.measurementAverages.remove( { datetime: start } );

		console.log( 'Inserting averages for ' + results.length + ' station.' );

		results.forEach( function( result ) {
			app.collections.measurementAverages.insert( {
				datetime: start,
				stn: result._id,
				avg_prcp: result.avg_prcp,
				avg_temp: result.avg_temp,
				avg_dewp: result.avg_dewp,
				avg_humi: calculateHumidity( result.avg_temp, result.avg_dewp )
			} );
		} );
	}

	if( ! app.collections.measurementAverages.find().count() ) {
		var result = app.collections.measurements.findOne( {}, { sort: { datetime: 1 } } );

		if( typeof result === 'object' ) {
			var start  = result.datetime.getTime();
			var stop   = Date.now();

			while( start < stop ) {
				calculateMeasurementAverages( start );
				start += 60 * 1000;
			}
		}
	}

	Meteor.setInterval( function() {
		// Calculate averages from previous minute
		calculateMeasurementAverages( new Date() - 60 * 1000 );
	}, 60 * 1000 );
} );