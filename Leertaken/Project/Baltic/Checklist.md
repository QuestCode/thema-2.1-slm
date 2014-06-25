- Andre
	- Show legend for graph colors
	- Quick test in IE
- Technical report
	- Specificatie
	- Ontwerp + toelichting
		- Infrastructure
			- Ant, Java, UNWDMIDP, Vagrant, NodeJS, Meteor, D3, Geodata
			- SSL/HTTPS
		- Backups
			- Explain backup using RSYNC
			- No option: http://docs.mongodb.org/manual/reference/program/mongodump/#bin.mongodump (full dataset)
			- No option: https://github.com/micahwedemeyer/automongobackup/blob/master/src/automongobackup.sh (doesn't work)
			- http://docs.mongodb.org/manual/core/master-slave/
			- mongod --port 37017 --slave --slavedelay 50400 --source localhost:27017 --dbpath /tmp/mongotest
			- 12 hours behind
		- Security
			- SRP protocol for passwords
	- Testrapportage

- ToDo
	- Add day/week/month radio button below legend

- Extra
	- Zoom
	- Search with autocomplete

