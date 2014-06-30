## Geodata

Voor het tonen van de weerstation is gekozen om deze te tonen over een kaart van het relevante gebied. Dit geeft een goed overzicht van alle weerstations en waar ze zich bevinden. Voornamelijk voor het tonen van de neerslag rondom de Baltische Zee biedt dit een erg mooi beeld. 

<!-- Baltische Zee kaart met kleurtjes -->

Het bovenstaande figuur geeft een voorbeeld van de weergave van neerslag rondom de Baltische Zee. Elke hexagon bestaat uit één of meerdere weerstations. Met de kleur van de hexagon wordt aangegeven hoeveel neerslag er gevallen is in de dat gebied. De grootte van een hexagon geeft een indicatie van het aantal weerstations in die hexagon. Deze kaart geeft in één oogopslag duidelijk weer wat de neerslagsituatie is rondom de Baltische Zee.

### Natural Earth Data

Om de kaarten te kunnen tonen is gebruik gemaakt van de vector kaarten aangeboden door [www.naturalearthdata.com](http://www.naturalearthdata.com). Deze kaarten zijn omgezet naar een [GeoJSON](http://geojson.org) formaat welke in te lezen zijn door D3. 

Het omzetten van de kaarten wordt gedaan met behulp van [ogr2ogr](http://www.gdal.org/ogr2ogr.html) en [TopoJSON](https://github.com/mbostock/topojson). Ogr2ogr wordt ingezet om kaarten van Natural Earth Data te versimpelen voor ons doel. In de onderstaande code is te zien hoe ogr2ogr wordt ingezet om alleen de landen rondom de Baltische Zee uit de kaart van Natural Earth Data te halen.

```
ogr2ogr \
  -simplify .001 \
  -f GeoJSON \
  -where "ADM0_A3_IS IN ('SWE', 'DNK', 'DEU', 'POL', 'RUS', 'LTU', 'LVA', 'EST', 'FIN', 'NOR', 'NLD', 'BLR')" \
  /vagrant/temp/countries.json \
  /vagrant/resources/ne_50m_admin_0_countries/ne_50m_admin_0_countries.shp
```

Vervolgens wordt gebruik gemaakt van TopoJSON om deze kaart om te zetten naar een GeoJSON formaat. De onderstaande code toont een voorbeeld van hoe TopoJSON is ingezet.

```
topojson \
  -o /vagrant/src/public/geo/baltic.json \
  -p name \
  -- /vagrant/temp/topo_countries.json
```

Het resulterende json bestand wordt ingeladen door D3 en uiteindelijk wordt de kaart getoond in de applicatie. Op de kaart worden de weerstations weergegeven op basis van de GPS coördinaten.