db.createCollection( 'stations', { } );
db.createCollection( 'measurements', { } );

db.stations.ensureIndex( { position: '2dsphere' } );