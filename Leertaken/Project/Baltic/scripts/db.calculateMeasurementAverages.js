var map = function() {
	function SDD( T ) {
		var a, b;
		if( T >= 0 ) {
			a = 7.5;
			b = 237.3;
		} else {
			a = 7.6;
			b = 240.7;
		}
		return 6.1078 * Math.exp( ( ( a * T ) / ( b + T ) ) / Math.LOG10E );
	}

	function calculateHumidity( temp, dewp ) {
		if( dewp > temp ) {
			return 100;
		}

		return 100 * SDD( dewp ) / SDD( temp );
	}

	var minute = new Date(this.datetime);
	minute.setSeconds(0);
	minute.setMilliseconds(0);

	var key = this.stn + '_' + minute.getTime();

	var value = {
		stn: this.stn,
		datetime: minute,
		count: 1,
		prcp: this.prcp,
		temp: this.temp,
		humi: calculateHumidity(this.temp, this.dewp)
	};

	emit( key, value );
}

var reduce = function( key, values ) {
	var object = {
		stn: values[0].stn,
		datetime: values[0].datetime,
		count: 0,
		total_prcp: 0,
		total_temp: 0,
		total_humi: 0,
		avg_prcp: 0,
		avg_temp: 0,
		avg_humi: 0,
	};

	values.forEach( function(value) {
		if(!isNaN(value.prcp)) {
			object.total_prcp += value.prcp;
			object.total_temp += value.temp;
			object.total_humi += value.humi;
			object.count += value.count;
		}
	});

	return object;
}

var finalize = function(key, value) {
	if(value.count > 0) {
		value.avg_prcp = value.total_prcp / value.count;
		value.avg_temp = value.total_temp / value.count;
		value.avg_humi = value.total_humi / value.count;
	}
	else {
		value.avg_prcp = value.total_prcp;
		value.avg_temp = value.total_temp;
		value.avg_humi = value.total_humi;
	}

	delete value.total_prcp;
	delete value.total_temp;
	delete value.total_humi;

	return value;
}

if( typeof datetime === 'undefined' ) {
	print( 'No datetime giving.' );
}
else {
 	var startDate = new Date(datetime);
 	startDate.setSeconds(0);
 	startDate.setMilliseconds(0);
 	var stopDate = new Date(datetime);
 	stopDate.setSeconds(0);
 	stopDate.setMilliseconds(0);
 	stopDate.setMinutes(stopDate.getMinutes() + 1);

	print( 'Mapreduce.. ');

	db.measurements.mapReduce( map, reduce, {
		query: { datetime: {
			$gte: startDate,
			$lt: stopDate
		} },
		out: {
			merge: 'measurement_averages'
		},
		finalize: finalize
	});
}
