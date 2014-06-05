app.models.Measurement = function(doc) {
	app.models.Model.call(
		this,
		doc,
		app.schemas.measurements,
		app.collections.measurements
	);
}

app.models.Measurement.prototype = Object.create(app.models.Model.prototype);

app.models.Measurement.prototype.getEvents = function() {
	var events = {
		tornado: false,
		thunderstorm: false,
		hail: false,
		snow: false,
		rain: false,
		freezing: false
	}

	if(this.events & 1) {
		events.tornado = true;
	}
	if(this.events & 2) {
		events.thunderstorm = true;
	}
	if(this.events & 4) {
		events.hail = true;
	}
	if(this.events & 8) {
		events.snow = true;
	}
	if(this.events & 16) {
		events.rain = true;
	}
	if(this.events & 32) {
		events.freezing = true;
	}

	return events;
}