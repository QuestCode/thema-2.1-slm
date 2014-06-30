### Geodata

To visual the data in a clear and concise manner a map with the weatherstations was used. This map gives both insight into the location and relation between weatherstations and into patterns that the weather may have in specific geographical areas. The map of the wordt with the hexagons showing the temperature gives a very good overview.

![World map](Images/worldmap.png)

The figure above gives a very clear picture of the percipitation around the baltic sea. Every hexagon on this map contains one or more weatherstations. The size of the hexagon gives an indication on the amount of weatherstations in that hexagon while the color gives an indication on the amount of percipitation as measured by those weatherstations.

#### Natural Earth Data

The maps are made using vector maps provided by [www.naturalearthdata.com](http://www.naturalearthdata.com). These are converted to the [GeoJSON](http://geojson.org) format which can be used by D3.

To convert the maps both to GeoJSON both [ogr2ogr](http://www.gdal.org/ogr2ogr.html) and [TopoJSON](https://github.com/mbostock/topojson) are used. Ogr2ogr is used to simplify and reduce the maps to only the area we need and TopoJSON then converts that to the GeoJSON format.

The code below shows how these tools were used.

```
ogr2ogr \
  -simplify .001 \
  -f GeoJSON \
  -where "ADM0_A3_IS IN ('SWE', 'DNK', 'DEU', 'POL', 'RUS', 'LTU', 'LVA', 'EST', 'FIN', 'NOR', 'NLD', 'BLR')" \
  /vagrant/temp/countries.json \
  /vagrant/resources/ne_50m_admin_0_countries/ne_50m_admin_0_countries.shp

topojson \
  -o /vagrant/src/public/geo/baltic.json \
  -p name \
  -- /vagrant/temp/topo_countries.json
```