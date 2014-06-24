var path = Npm.require('path');
var Future = Npm.require('fibers/future');
var json2csv = Meteor.require('json2csv');

app.exportMeasurements = function(stations, startDate, stopDate) {
  var fields = [
    'stn',
    'datetime',
    'avg_prcp',
    'avg_temp',
    'avg_dewp',
    'avg_humi'
  ];

  for( var i = 0; i < stations.length; ++i ) {
    stations[i] = parseInt( stations[i], 10 );
  }

  var measurements = app.collections.measurementAverages.find({
    stn: {
      $in: stations
    },
    datetime: {
      $gte: new Date( startDate ),
      $lt: new Date( stopDate )
    }
  }).fetch();

  console.log(stations,startDate,stopDate,measurements);

  var future = new Future();

  json2csv({
    fields: fields,
    data: measurements
  }, function(err, csv) {
    if(err) {
      future.throw(err);
      return;
    }

    future.return(csv);
  });

  return future.wait();
};
