/* In Mongo shell run:

	load('/path/to/db.stretchMeasurementAverages.js')
	stretchMeasurementAverages( 100 ) // 7,5 hour of date becomes 7,5 * 100 hours of data (a month)
*/

function stretchMeasurementAverages( times ) {
	db.createCollection('measurement_averages2');
	var i = 0;
	var j;
	var total = db.measurement_averages.count();
	print( 'Stretching ' + total + '..' );
	function stretched( i ) {
		print( 'Stretched ' + i + '/' + total + ' (' + ( ( i / total ) * 100 ).toFixed( 2 ) + '%).' );
	}
	var date;
	db.measurement_averages.find().sort( { 'value.datetime': -1 } ).forEach( function( obj ) {
		if( date === undefined ) {
			date = obj.value.datetime;
		}
		delete obj._id;
		for( j = 0; j < times; ++j ) {
			obj.value.datetime = date;
			db.measurement_averages2.insert( obj );
			date.setMinutes( date.getMinutes() - 1 );
		}
		++i;
		if( i % 10000 === 0 ) {
			stretched( i );
		}
	} );
	stretched( i );
}