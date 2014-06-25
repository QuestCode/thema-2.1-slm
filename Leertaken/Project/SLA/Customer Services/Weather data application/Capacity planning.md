### 2.1.3 Capacity planning

The Weather Data Application is expected to cause the most workload on the storage space of the server. The supplier does not expect the graphical representations and the calculations needed for these to cause too much strain on the system itself. However, the application might cause some strain on the storage space, seeing as all data has to be saved over a period of 6 months. Because the supplier has not yet processed 6 months of data it is hard to make an exact measurement concerning the maximum amount o...(line truncated)...

Instead of an exact measurement, the supplier has made a rough estimate, assuming that the amount of data per day will stay consistent and not taking into account caching/compression algorithms that may be implemented at a later stage: 

| Size of weather data per day | Backup size per day | Caching |
| :----                        | :----               |         |
| ~2GB                         | ~2GB                | ~50Mb   |

As seen in the calculation, a maximum amount of storage space of _365.5 GB_ will be required to store half a year of weather data. 

To ensure that the application will not run out of storage capacity, the supplier will strive to maintain an overcapacity of 10%. Important to note is the ease of adding additional storage space. The expectation is that the supplier will be able to provide the application with additional storage hardware at any given moment (given the necessary hardware is available on site), this process will not cause more than 30 minutes of downtime.

The total startcapacity including the overcapacity margin for the Weather Data Application will be: _365.5GB * 1,10 = 402.5GB_

