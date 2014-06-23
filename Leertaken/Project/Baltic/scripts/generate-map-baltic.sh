ogr2ogr \
	-f GeoJSON \
	-where "ADM0_A3_IS IN ('SWE', 'DNK', 'DEU', 'POL', 'RUS', 'LTU', 'LVA', 'EST', 'FIN', 'NOR', 'NLD', 'BLR')" \
	/vagrant/temp/countries.json \
	/vagrant/resources/ne_50m_admin_0_countries/ne_50m_admin_0_countries.shp

ogr2ogr \
	-f GeoJSON \
	-where "id IN ('1a', '1b', '1c', '1', '2')" \
	/vagrant/temp/seas.json \
	/vagrant/resources/seas/World_Seas.shp

topojson \
	-o /vagrant/temp/topo_countries.json \
	-p name=NAME \
	-- /vagrant/temp/countries.json

topojson \
	-o /vagrant/temp/topo_seas.json \
	-p name=NAME \
	-- /vagrant/temp/seas.json

topojson \
	-o /vagrant/src/public/geo/baltic.json \
	-p name \
	-- /vagrant/temp/topo_countries.json /vagrant/temp/topo_seas.json