#!/bin/bash

if ! ls ~/meteorapp 2> /dev/null; then
	mrt create ~/meteorapp

	rm -rf /vagrant/src/.meteor
	mkdir /vagrant/src/.meteor
	sudo mount --bind /home/vagrant/meteorapp/.meteor /vagrant/src/.meteor/
fi

export MONGO_URL=mongodb://localhost:27017/meteor
export METEOR_LOCAL_DIR=/data/meteor
cd /vagrant/src
meteor run
