## 4.3 Conclusion

The first query has an average load time of _4,3 seconds_, which allows for a network delay of appromixately _55 seconds_. The second query has an average load time of _17,9 seconds_, which allows for a network delay of approximately _42 seconds_. Both are well within the measured network delay between the Netherlands and Lithuania:

![Ping to Lithuania](Figures/Ping.jpg)

Also the databases uses a [B-tree index](http://docs.mongodb.org/manual/reference/glossary/#term-b-tree) which scales _O(log n)_. Since this will be a small part of the load time -because of rendering, network delay, and logic-, it is safe to say the queries will not reach the 60 second limit any time soon.
