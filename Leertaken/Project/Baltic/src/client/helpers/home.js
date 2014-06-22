Template.home.created = function() {

	d3.json('geo/baltic.json', function(err, baltic) {
		var countries = topojson.feature(baltic, baltic.objects.countries);
		var seas = topojson.feature(baltic, baltic.objects.seas);
		var stations = app.collections.stations.find().fetch();

		var width = 720;
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
			.attr('id', 'seas')
			.selectAll('path')
			.data(seas.features)
			.enter().append('path')
				.attr('class', 'sea')
				.attr('name', function(d) { return d.properties.name; })
				.attr('d', path);

		svg.append('g')
			.attr('id', 'borders')
			.append('path')
				.datum(topojson.mesh(baltic, baltic.objects.countries, function(a, b) { return a !== b }))
				.attr('d', path)
				.attr('class', 'borders')

		var hexbin = d3.hexbin()
			.size([width, height])
			.radius(15);

		var colors = ['#ffffd9','#edf8b1','#c7e9b4','#7fcdbb','#41b6c4','#1d91c0','#225ea8','#253494','#081d58'];

		// svg.append('g')
		// 	.attr('id', 'stations')
		// 	.selectAll('path')
		// 	.data(stations)
		// 	.enter().append('circle')
		// 		.attr('class', 'station')
		// 		.attr('name', function(d) { return d.name; })
		// 		.attr('r', 20)
		// 		.attr('cx', function(d) { return projection(d.position.coordinates)[0] })
		// 		.attr('cy', function(d) { return projection(d.position.coordinates)[1] })
		// 		.attr('fill', function() { return colors[Math.floor(Math.random() * colors.length)]; })

		stations.forEach(function(d) {
			var p = projection(d.position.coordinates);
			d[0] = p[0];
			d[1] = p[1];
	  });

		var color = d3.scale.linear()
			.domain([0, 5])
			.range(["#ef8a62", "#f7f7f7", "#67a9cf"]);

	  svg.append('g')
      .attr('class', 'hexagons')
    .selectAll('path')
      .data(hexbin(stations))
    .enter().append('path')
    	.attr('class', 'hexagon')
      .attr('d', function(d) { return hexbin.hexagon(); })
      .attr('transform', function(d) { return 'translate(' + d.x + ',' + d.y + ')'; })
      .style('fill', function(stations) { 
      	var stns = _.pluck(stations, 'stn');

      	var measurements = app.collections.measurements.find({ 
      		stn: { $in: stns }
      	}).fetch();

      	var temp = _.reduce(measurements, function(memo, m) { return memo + m.temp }, 0);
      	var temp = temp / measurements.length;

      	if(measurements.length == 0) {
      		return 'none'
      	}

      	return color(temp);
      });

		// var points = [];
		// for(var i = 0; i < stations.length; i++) {
		// 	var station = stations[i];
		// 	var duplicate = false;

		// 	for(var j = 0; j < points.length; j++) {
		// 		var point = points[j];

		// 		if(station.position.coordinates[0] == point[0] && station.position.coordinates[1] == point[1]) {
		// 			duplicate = true;
		// 		}
		// 	}

		// 	if(!duplicate) {
		// 		points.push({
		// 			'0': station.position.coordinates[0],
		// 			'1': station.position.coordinates[1],
		// 			'stn': station.stn,
		// 			'name': station.name
		// 		});
		// 	}
		// }

		// var colors = ['#ffffd9','#edf8b1','#c7e9b4','#7fcdbb','#41b6c4','#1d91c0','#225ea8','#253494','#081d58'];

		// svg.append('g')
		// 	.attr('id', 'areas')
		// 	.selectAll('path')
		// 	.data(d3.geom.voronoi(points.map(projection)))
		// 	.enter().append('path')
		// 		.attr('clip-path', 'url(#mask)')
		// 		.attr('class', function(d, i) {
		// 			if(balticStations.indexOf(points[i].stn) === -1) {
		// 				return 'area inactive'
		// 			}

		// 			return 'area'
		// 		})
		// 		.attr('name', function(d, i) { return points[i].name; })
		// 		.attr('stn', function(d, i) { return points[i].stn; })
		// 		.attr('d', function(d) { return 'M' + d.join('L') + 'Z'; })
		// 		.style('fill', function() {
		// 			return colors[Math.floor(Math.random() * colors.length)];
		// 		})

		// svg.append('path')
		// 	.datum(d3.geom.voronoi(points.map(projection)))
		// 	.style('stroke', 'red')
		// 	.style('fill', 'none')
  //     .attr('class', 'voronoi')
  //     .attr('d', function(d) { return 'M' + d.map(function(d) { return d.join('L'); }).join('ZM') + 'Z'; });

	});
}