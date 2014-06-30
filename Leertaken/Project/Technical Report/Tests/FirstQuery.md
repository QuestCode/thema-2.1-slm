## 4.2 First Query

The first query is __rainfall above 10 mm within 50 km of the Baltic Sea coast__.

The response should be served within 1 minute. Because there are many things to take in consideration, a simple timing test seems te most appropriate. During a period of 20 minutes the Baltic Sea page was fully refreshed 10 times. This page contains a map with 188 weatherstations and a rainfall graph per station. This test resulted in the following load times:

| Test        | Start time | Stop time | Response time |
| :----       | :----      | :----     | :----         |
| 1           | 11:16:01   | 11:16:04  | 3.2 seconds   |
| 2           | 11:16:20   | 11:16:25  | 4.7 seconds   |
| 3           | 11:16:28   | 11:16:32  | 3.5 seconds   |
| 4           | 11:22:36   | 11:22:40  | 3.8 seconds   |
| 5           | 11:22:54   | 11:23:04  | 8.4 seconds   |
| 6           | 11:23:10   | 11:23:15  | 4.2 seconds   |
| 7           | 11:23:18   | 11:23:22  | 3.4 seconds   |
| 8           | 11:30:20   | 11:30:04  | 3.8 seconds   |
| 9           | 11:30:28   | 11:30:32  | 4.5 seconds   |
| 10          | 11:30:40   | 11:30:44  | 3.7 seconds   |
| __Average__ |            |           | 4.3 seconds   |

From this can be concluded that the response times are well within the 60 second limit.

Because data is stored in a temporary and local Mongo database, a big part of the load is made redundant, since loading the stations and old weather data will be cached. Therefore the number data requests will be limited, which will lower the server and database load.