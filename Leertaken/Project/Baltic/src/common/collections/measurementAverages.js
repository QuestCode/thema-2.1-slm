app.schemas.measurementAverages = new SimpleSchema( {
	'_id.stn': {
		type: Number,
		label: 'Station Number'
	},
	'_id.datetime': {
		type: Date,
		label: 'Datetime'
	},
	'value.stn': {
		type: Number,
		label: 'Station Number'
	},
	'value.datetime': {
		type: Date,
		label: 'Datetime'
	},
	'value.count': {
		type: Number,
		label: 'Number of measurements',
		min: 0
	},
	'value.avg_prcp': {
		type: Number,
		label: 'Average Precipitation',
		min: 0.00,
		max: 999.99,
		decimal: true
	},
	'value.avg_temp': {
		type: Number,
		label: 'Average Temperature',
		min: -9999.9,
		max: 9999.9,
		decimal: true
	},
	'value.avg_humi': {
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
