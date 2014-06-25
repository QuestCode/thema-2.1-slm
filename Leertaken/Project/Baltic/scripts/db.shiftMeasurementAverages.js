/* In Mongo shell run:

	load('/path/to/db.shiftMeasurementAverages.js')
	shiftMeasurementAverages( 10 * 60 * 60 * 1000 ) // 10 hours (in milliseconds)
*/

function shiftMeasurementAverages( ms ) {
	var i = 0;
	var total = db.measurement_averages.count();
	print( 'Shifting ' + total + '..' );
	function shifted( i ) {
		print( 'Shifted ' + i + '/' + total + ' (' + ( ( i / total ) * 100 ).toFixed( 2 ) + '%).' );
	}
	db.measurement_averages.find().forEach( function( obj ) {
		obj.value.datetime = new Date( obj.value.datetime + ms );
		db.measurement_averages.save( obj );
		++i;
		if( i % 10000 === 0 ) {
			shifted( i );
		}
	} );
	shifted( i );
}