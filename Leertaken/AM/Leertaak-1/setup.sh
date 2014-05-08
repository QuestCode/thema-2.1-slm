#!/bin/bash

apt-get install -y postgresql-client

psql -U="super" \
	-W="banaan" \
	-h="127.0.0.1" \
	-p="5432" \
	-d="UNWDMI" \
	< /vagrant/Resources/unwdmi_postgresql.backup