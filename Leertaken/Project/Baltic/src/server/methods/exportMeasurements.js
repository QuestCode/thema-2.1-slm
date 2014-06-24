var path = Npm.require('path');
var Future = Npm.require('fibers/future');
var json2csv = Npm.require('json2csv');

app.exportMeasurements = function(stations, startDate, stopDate) {
  var fields = [
    'stn' 
    'datetime' 
    'avg_prcp' 
    'avg_temp' 
    'avg_dewp' 
    'avg_humi' 
  ];

  var measurements = app.collections.measurementAverages.find({
    stn: {
      $in: stations
    },
    datetime: {
      $gte: startDate,
      $lt: stopDate
    }
  }).fetch();

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
}
