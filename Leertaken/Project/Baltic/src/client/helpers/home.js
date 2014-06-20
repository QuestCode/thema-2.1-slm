Template.home.created = function() {
	d3.json('geo/baltic.json', function(err, baltic) {
		var countries = topojson.feature(baltic, baltic.objects.countries);
		var seas = topojson.feature(baltic, baltic.objects.seas);
		var stations = app.collections.stations.find().fetch();

		var width = 1280;
		var height = 720;

		var svg = d3.select('#map').append('svg')
			.attr('width', width)
			.attr('height', height);

		var projection = d3.geo.mercator()
			.scale(1)
			.translate([0, 0]);

		var path = d3.geo.path()
			.projection(projection);

		var bounds = path.bounds(seas);

		var scale = .85 / Math.max(
			(bounds[1][0] - bounds[0][0]) / width,
			(bounds[1][1] - bounds[0][1]) / height);
		var translate = [
			(width - scale * (bounds[1][0] + bounds[0][0])) / 2,
			(height - scale * (bounds[1][1] + bounds[0][1])) / 2
		];

		projection
			.scale(scale)
			.translate(translate);

		svg.append('g')
			.attr('id', 'countries')
			.selectAll('path')
			.data(countries.features)
			.enter().append('path')
				.attr('class', 'country')
				.attr('name', function(d) { return d.properties.name; })
				.attr('d', path);

		svg.append('g')
			.attr('id', 'borders')
			.append('path')
				.datum(topojson.mesh(baltic, baltic.objects.countries, function(a, b) { return a !== b }))
				.attr('d', path)
				.attr('class', 'borders')

		svg.append('g')
			.attr('id', 'seas')
			.selectAll('path')
			.data(seas.features)
			.enter().append('path')
				.attr('class', 'sea')
				.attr('name', function(d) { return d.properties.name; })
				.attr('d', path);

		svg.append('g')
			.attr('id', 'stations')
			.selectAll('path')
			.data(stations)
			.enter().append('circle')
				.attr('class', 'station')
				.attr('name', function(d) { return d.name; })
				.attr('r', 2)
				.attr('cx', function(d) { return projection(d.position.coordinates)[0] })
				.attr('cy', function(d) { return projection(d.position.coordinates)[1] })
	});
}