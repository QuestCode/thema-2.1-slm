Meteor.publish( 'measurementAreaAverages', function( stations, datetime ) {
  var self = this;

  if( datetime ) {
    var datetime = new Date(datetime);
    datetime.setMilliseconds(0);
    datetime.setSeconds(0);
  }
  else {
    var last = app.collections.measurementAverages.findOne({}, { sort: { 'value.datetime': -1 }, limit: 1 });
    var datetime = new Date(last.value.datetime);
    datetime.setMinutes(datetime.getMinutes() - 1);
  }

  var query = {
    'value.stn': {
      $in: stations
    },
    'value.datetime': datetime
  };

  var handle = app.collections.measurementAverages.find(query).observeChanges({
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
