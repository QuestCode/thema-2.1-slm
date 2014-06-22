app.schemas.measurements = new SimpleSchema({
	stn: {
		type: Number,
		label: 'Stationnumber'
	},
	date: {
		type: Date,
		label: 'Date'
	},
	time: {
		type: Date,
		label: 'Time'
	},
	temp: {
		type: Number,
		label: 'Temperature',
		min: -9999.9,
		max: 9999.9
	},
	dewp: {
		type: Number,
		label: 'Dewpoint',
		min: -9999.9,
		max: 9999.9
	},
	stp: {
		type: Number,
		label: 'Atmospheric pressure (station altitude)',
		min: 0.0,
		max: 9999.9
	},
	slp: {
		type: Number,
		label: 'Atmospheric pressure (sea level)',
		min: 0.0,
		max: 9999.9
	},
	visib: {
		type: Number,
		label: 'Visibility',
		min: 0.0,
		max: 999.9
	},
	prcp: {
		type: Number,
		label: 'Precitipation',
		min: 0.00,
		max: 999.99
	},
	sndp: {
		type: Number,
		label: 'Snowfall',
		min: -9999.9,
		max: 9999.9
	},
	cldc: {
		type: Number,
		label: 'Cloudcover',
		min: 0.0,
		max: 99.9
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
	schema: app.schemas.measurements,
	// transform: function(doc) {
	// 	return new app.models.Measurement(doc);
	// }
});