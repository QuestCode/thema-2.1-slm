Meteor.publish( 'measurementAreaAverages', function( stations, date ) {
  var self = this;

  var startDate = new Date(date);
  startDate.setMilliseconds(0);
  startDate.setSeconds(0);

  var stopDate = new Date(date);
  stopDate.setMilliseconds(0);
  stopDate.setSeconds(0);
  stopDate.setMinutes(stopDate.getMinutes() + 1);

  var query = {
    stn: {
      $in: stations
    },
    datetime: {
      $gte: startDate,
      $lt: stopDate
    }
  };

  var handle = app.collections.measurementAverages.find(query).observerChanges({
    added: function(id, doc) {
      self.added('measurementAreaAverages', id, doc);
    },
    removed: function(id) {
      self.removed('measurementAreaAverages', id);
    }
  });

  self.ready();

  self.onStop(function() {
    handle.stop();
  });
});
