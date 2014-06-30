## 3.5 Map Reduce

The requirements as set by the ASU were that the measurements should be provide with a frequency of 1 measurement per minute. The actual measurements are however made with a frequency of 1 measurement per second. To meet the requirement a [Map Reduce](http://docs.mongodb.org/manual/core/map-reduce/) was implemented that collects every measurement of a weatherstation, calculats the average of the measurements and finally saves these averages in a new collection. This Map Reduce is executed every minute on the previous minute of measurements.

Finally the collection containing the averages is used within the application. All the data in both the map and the line graphs is provided by this collection of the averages per minute.