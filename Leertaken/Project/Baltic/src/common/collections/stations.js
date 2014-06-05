app.schemas.stations = new SimpleSchema({
	stn: {
		type: Number,
		label: 'Stationnumber'
	},
	name: {
		type: String,
		label: 'Name'
	},
	country: {
		type: String,
		label: 'Country'
	},
	position: {
		type: Object,
		label: 'Position'
	},
	'position.type': {
		type: String,
		defaultValue: 'Point',
		allowedValues: ['Point']
	},
	'position.coordinates': {
		type: [Number],
		minCount: 2,
		maxCount: 2
	},
	elevation: {
		type: Number,
		label: 'Elevation'
	}
});

app.collections.stations = new Meteor.Collection('stations', {
	schema: app.schemas.stations,
	transform: function(doc) {
		return new app.models.Station(doc);
	}
})