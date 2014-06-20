#!/bin/bash

if ! ls ~/meteorapp 2> /dev/null; then
	mrt create ~/meteorapp
	mkdir ~/meteorapp/packages

	rm -rf /vagrant/src/.meteor
	rm -rf /vagrant/src/packages
	mkdir /vagrant/src/.meteor
	mkdir /vagrant/src/packages

	rm -rf ~/meteorapp/.meteor/packages
	ln -s /vagrant/src/installed-packages ~/meteorapp/.meteor/packages
fi

sudo mount --bind /home/vagrant/meteorapp/.meteor /vagrant/src/.meteor/
sudo mount --bind /home/vagrant/meteorapp/packages /vagrant/src/packages/

export MONGO_URL=mongodb://localhost:27017/meteor
export METEOR_LOCAL_DIR=/data/meteor
# cd /vagrant/src
# meteor run