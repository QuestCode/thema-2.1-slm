## 3.7 Backups

Backups are essential in case of hardware failure and data loss. As described in the Service Level agreement backups will be made on a daily basis. Because the dataset itself is large and will only grow, making a full backup isn't an option. Unfortunately with a NoSQL database like MongoDB incremental backups are also not a built in feature and must be done manually.

Luckily with MongoDB there is a far more clever approach: Replication with slave delay. This essentially is a full backed up running copy of the full server, but with synchronization delay of a half day (a reasonable restoring time). This ensures always having the data of the previous the last day.

Setting up delayed master-slave replication with MongoDB is relatively easy. It can be done by running the following command on a seperate server:

    mongod --port 37017 --slave --slavedelay 43200 \
    	--source <master server>:27017 --dbpath /tmp/backup

The slave delay is specified in seconds (43200 = 12 hours) and all data is stored in the `/tmp/backup` folder.

Each weather measurement that this assignment requires takes up _240 bytes_ of diskspace. Which means each day takes only `60 * 24 * 240 ~= 0.33 MB` diskspace. This is _59,68 MB_ worth of data for half a year.

A downside -that should be mentioned- is the requirement of having a server with the same disk capacity as the original server. Moving old data from the slave server to a backup disk can be done, but has to be investigated more thoroughly. This downside is currently not relevant, since the assignment requirements only require a half a year data retention.

More information about master-slave replication can be found on the [MongoDB website](http://docs.mongodb.org/manual/core/master-slave/).