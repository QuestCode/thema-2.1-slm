app.models.Station = function(doc) {
	app.models.Model.call(
		this,
		doc,
		app.schemas.stations,
		app.collections.stations
	);
}

app.models.Station.prototype = Object.create(app.models.Model.prototype);

app.models.Station.prototype.getCoordinates = function() {
	return this.position.coordinates;
}