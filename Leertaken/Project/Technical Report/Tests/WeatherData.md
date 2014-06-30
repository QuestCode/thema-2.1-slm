## 4.1 Weather Data

In the previous assignment (learning task 2) the throughput of the weather data processor was tested. Here are the results:

| Duration      | Clusters  | Memory    | Mutations      | # of records            | Expected # of records | Efficiency  |
| :------------ | :-------- | :------   | :------------- | :---------------------- | :----------           | :---------- |
| 15 minutes    | 800       | 153.50 MB | 7207550        | 7206750                 | 7200000               | 100.09%     |
| 30 minutes    | 800       | 149.00 MB | 14176000       | 14472520                | 14400000              | 100.05%     |
| 60 minutes    | 800       | 148.50 MB | 28805760       | 28804960                | 28800000              | 100.02%     |

After executing numerous long term running stresstests, the application was still able to process without data loss. The efficiency remains 100% en the amount of used memory is stable. After a runtime of 15 minutes the size of the database was _1.73 GB_, and after 1 hour runtime it was _6.91 GB_. Which is almost exactly 4 times larger. Also a runtime of 30 minutes results in a database with a size of _3.46 GB_ (twice the size of a 15 minute runtime). From this can be concluded that the database has a lineair growth, with a size increase of approximately _6.9 GB_ per hour.
