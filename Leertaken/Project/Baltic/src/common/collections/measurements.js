app.schemas.measurements = new SimpleSchema({
	stn: {
		type: Number,
		label: 'Stationnumber'
	},
	datetime: {
		type: Date,
		label: 'Date'
	},
	temp: {
		type: Number,
		label: 'Temperature',
		min: -9999.9,
		max: 9999.9,
		decimal: true
	},
	dewp: {
		type: Number,
		label: 'Dewpoint',
		min: -9999.9,
		max: 9999.9,
		decimal: true
	},
	stp: {
		type: Number,
		label: 'Atmospheric pressure (station altitude)',
		min: 0.0,
		max: 9999.9,
		decimal: true
	},
	slp: {
		type: Number,
		label: 'Atmospheric pressure (sea level)',
		min: 0.0,
		max: 9999.9,
		decimal: true
	},
	visib: {
		type: Number,
		label: 'Visibility',
		min: 0.0,
		max: 999.9,
		decimal: true
	},
	prcp: {
		type: Number,
		label: 'Precipitation',
		min: 0.00,
		max: 999.99,
		decimal: true
	},
	sndp: {
		type: Number,
		label: 'Snowfall',
		min: -9999.9,
		max: 9999.9,
		decimal: true
	},
	cldc: {
		type: Number,
		label: 'Cloudcover',
		min: 0.0,
		max: 99.9,
		decimal: true
	},
	winddir: {
		type: Number,
		label: 'Winddirection',
		min: 0,
		max: 359
	},
	frshtt: {
		type: Number,
		label: 'Events',
		min: 0,
		max: 63
	}
});

app.collections.measurements = new Meteor.Collection('measurements', {
	schema: app.schemas.measurements
});
