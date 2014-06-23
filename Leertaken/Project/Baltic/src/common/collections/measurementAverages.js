app.schemas.measurementAverages = new SimpleSchema( {
	stn: {
		type: Number,
		label: 'Station Number'
	},
	datetime: {
		type: Date,
		label: 'Datetime'
	},
	avg_prcp: {
		type: Number,
		label: 'Average Precipitation',
		min: 0.00,
		max: 999.99,
		decimal: true
	},
	avg_temp: {
		type: Number,
		label: 'Average Temperature',
		min: -9999.9,
		max: 9999.9,
		decimal: true
	},
	avg_humi: {
		type: Number,
		label: 'Average Humidity',
		min: 0,
		max: 100,
		decimal: true
	}
} );

app.collections.measurementAverages = new Meteor.Collection( 'measurement_averages', {
	schema: app.schemas.measurementAverages
} );
