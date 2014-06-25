db.createCollection( 'stations', { } );
db.createCollection( 'measurements', { } );
db.createCollection( 'measurement_averages' , { } );

db.stations.ensureIndex( { position: '2dsphere' } );
db.measurements.ensureIndex( { datetime: 1 } );
db.measurement_averages.ensureIndex( { 'value.datetime': 1, 'value.stn': 1} );
db.measurement_averages.ensureIndex( { 'value.datetime': 1 } );
db.measurement_averages.ensureIndex( { 'value.stn': 1 } );