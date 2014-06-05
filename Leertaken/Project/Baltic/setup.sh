#!/bin/bash

if ! which meteor > /dev/null; then
	sudo apt-get update
	sudo apt-get install -y python-software-properties python g++ make
	sudo apt-key adv --keyserver keyserver.ubuntu.com --recv 7F0CEB10
	echo "deb http://downloads-distro.mongodb.org/repo/ubuntu-upstart dist 10gen" | sudo tee -a /etc/apt/sources.list.d/10gen.list
	sudo add-apt-repository ppa:chris-lea/node.js
	sudo apt-get update
	sudo apt-get install -y git mongodb-10gen curl
	sudo apt-get install -y nodejs
	curl https://install.meteor.com | sudo sh
	sudo npm install -g meteorite
fi

if ! ls /data/db 2> /dev/null; then
	sudo mkdir -p /data/db
	sudo chown -R vagrant /data
	sudo chgrp -R vagrant /data
fi
