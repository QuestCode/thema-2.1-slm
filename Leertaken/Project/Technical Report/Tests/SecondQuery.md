## 4.3 Second Query

The second query is __graphs of temperatue and humidty for any weatherstation worldwide__.

This response should also be served within 1 minute. For the second query there are the same things to take in consideration as the first query, except for the larger amount of weather stations (8000 instead of 188) and removal of the limitation of not showing stations (with rainfall less than 10 mm). Also a simple timing test seems te most appropriate in this case. During a period of 20 minutes the World map page, with map and graphs, was fully refreshed 10 times. This resulted in the following load times:

| Test        | Start time | Stop time | Response time |
| :----       | :----      | :----     | :----         |
| 1           | 11:32:22   | 11:32:38  | 16.3 seconds  |
| 2           | 11:32:42   | 11:33:00  | 17.2 seconds  |
| 3           | 11:33:05   | 11:33:22  | 16.6 seconds  |
| 4           | 11:40:48   | 11:41:14  | 25.8 seconds  |
| 5           | 11:41:16   | 11:41:32  | 16.2 seconds  |
| 6           | 11:41:37   | 11:41:52  | 16.3 seconds  |
| 7           | 11:50:06   | 11:50:23  | 16.8 seconds  |
| 8           | 11:50:29   | 11:50:49  | 20.2 seconds  |
| 9           | 11:50:54   | 11:51:11  | 16.6 seconds  |
| 10          | 11:51:17   | 11:50:34  | 16.7 seconds  |
| __Average__ |            |           | 17.9 seconds  |

From this can be concluded that the response times are well within the 60 second limit.

The world map uses the same functionality as the Baltic Sea map (with a few differences). Because of this the data is also stored in a temporary and local Mongo database, which in turn also lowers the number of data requests and server and database load.
