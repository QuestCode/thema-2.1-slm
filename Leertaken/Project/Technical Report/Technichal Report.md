<h1 style="font-size:4em">Technisch Rapportage</h1>
<h2 style="font-size:2.5em;margin:-30px 0 580px">Baltic Sea Weather Data</h2>

> __Assignment:__ Technical Report for Learning Task 5, Group 1, Theme 2.1-I
>
> __Authors:__ <span style="display:inline-block;vertical-align:top">Tom Broenink, Ward Holthof, Yuri Hoogeweg,<br/>André Nanninga, and Maurits van Mastrigt</span>
>
> __Date:__ June 30th 2014

<!-- header: Technical Report, LT5, Group 1, Theme 2.1-I -->

# Inhoud
<!--
- 1 &nbsp;Algemeen											<span style="float:right;font-weight:bold">3</span>
	- 1.1 &nbsp;Begripsbepaling								<span style="float:right;font-weight:normal">3</span>
	- 1.2 &nbsp;Partijen									<span style="float:right;font-weight:normal">3</span>
	- 1.3 &nbsp;Inleiding									<span style="float:right;font-weight:normal">3</span>
	- 1.4 &nbsp;Goedkeuring SLA								<span style="float:right;font-weight:normal">3</span>
	- 1.5 &nbsp;Beschrijving van de Dienstverlening			<span style="float:right;font-weight:normal">3</span>
	- 1.6 &nbsp;Continuïteit van de Cloud-dienstverlening	<span style="float:right;font-weight:normal">4</span>
	- 1.7 &nbsp;Prioriteitbepaling							<span style="float:right;font-weight:normal">4</span>
	- 1.8 &nbsp;Aansprakelijkheid							<span style="float:right;font-weight:normal">5</span>
- 2 &nbsp;Klantdiensten										<span style="float:right;font-weight:bold">6</span>
	- 2.1 &nbsp;Cloud Hosting								<span style="float:right;font-weight:normal">6</span>
	- 2.2 &nbsp;Servicedesk									<span style="float:right;font-weight:normal">12</span>
- 3 &nbsp;Tariefstructuur									<span style="float:right;font-weight:bold">15</span>
	- 3.1 &nbsp;Eenmalige Kosten							<span style="float:right;font-weight:normal">15</span>
	- 3.2 &nbsp;Structurele Kosten							<span style="float:right;font-weight:normal">15</span>
	- 3.3 &nbsp;Servicedeskondersteuning					<span style="float:right;font-weight:normal">15</span>
	- 3.4 &nbsp;Niveau's van Dienstverlening				<span style="float:right;font-weight:normal">16</span>
- 4 &nbsp;Implementatie en Condities						<span style="float:right;font-weight:bold">18</span>
	- 4.1 &nbsp;Eisen aan Infrastructuur					<span style="float:right;font-weight:normal">18</span>
	- 4.2 &nbsp;Geschatte Opleverdatum						<span style="float:right;font-weight:normal">18</span>
	- 4.3 &nbsp;Proefperiode								<span style="float:right;font-weight:normal">19</span>
	- 4.4 &nbsp;Bonus en Malus								<span style="float:right;font-weight:normal">19</span>
- 5 &nbsp;Rapportageverplichtingen							<span style="float:right;font-weight:bold">20</span>
	- 5.1 &nbsp;Service Review								<span style="float:right;font-weight:normal">20</span>
	- 5.2 &nbsp;Proefperiode Rapportage						<span style="float:right;font-weight:normal">20</span>
- 6 &nbsp;Glossary											<span style="float:right;font-weight:bold">21</span>
- 7 &nbsp;Ondertekening										<span style="float:right;font-weight:bold">22</span>
-->

# 1 Introduction

Aleksandro Stulginskio Universitetas will perform calculations on weather data to conduct research on climate change. The university is interested in climate change in Lithuania and other countries around the Baltic Sea. The university is especially interested in weather changes regarding the milder weather in the past years.

# 2 Application Specification

- Something about UNWDMI, Da Vinci Data
- About the meeting with Aleksandro..
- Introduction of the next requirement paragraph

# 3.1 Requirements

Through a first meeting the following requirements were agreed upon..







Aleksandro Stulginskio Universitetas will perform calculations on weather data to conduct research on climate change. The university is interested in climate change in Lithuania and other countries around the Baltic Sea. The university is especially interested in weather changes regarding the milder weather in the past years.

Would like 'sleet' measurements.

Interested in the following measurements:

- Wind speed
- Rain fall
- Temperature
- Humidity

Relevant countries:

- Lithuania
- Denmark
- Germany
- Poland
- Kalingrad (Russia)
- Estonia
- Latvia
- Finland
- Sweden

Want a view to display the top 10 of weather stations by highest average wind speed.

## Technical

#### Queries:
1. __Top 10 by Wind Speed.__  
Show top 10 of Weather Stations determined by highest average wind speed. Only stations within 50 km of coastline of the Baltic Sea.
2. __Rain fall above 10 mm within 50 km.__  
Show data about rain fall when it is above 10 mm. Don't show when rain fall is below that. Only stations within 50 km of coastline of the Baltic Sea.
3. __Graphs of temperature and humidity.__  
Be able to show a graph of temperature and humidity of any individual weatherstation. (Since previous midnight). Any weatherstation worldwide.

#### Key requirements
- Cockpit-like graphical presentation, no 'boring' tables.
- History of data by days, weeks and months.
- Half a year (6 months) data retention.
- Support Google Chrome and latest version of Internet Explorer.
- Data and webinteface will be hosted by Da Vinci Data.
- Map with colour code for wind speed and temperature values.
- Authenticate using username and password, no specific user roles.
- Allow for data to be downloaded in Excel file for the past half a year in days/weeks/months.
- ONLY measurements per minute.
- SSL to secure safe data transport.

#### Load time for queries
- Query 1: 10 seconds.
- Query 2: 1 minute.
- Query 3: 1 minute.

# 3 Applicaton Design






D3 is een JavaScript library voor het manipuleren van documenten op basis van data. Met deze library wordt de weerdata gevisualiseerd zodat deze makkelijk opgenomen kan worden. De D3 library wordt gebruikt om een kaart te tonen met de weerstations maar ook voor de lijngrafieken met de gemiddelde temperatuur, neerslag en luchtvochtigheid.

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
## Hexbinning

Het direct tonen van de weerstations op de kaarten bleek vanwege de hoeveelheid stations onduidelijk te zijn. Om een beter inzicht te geven van de stations op de kaarten wordt gebruik gemaakt van Hexbinning. Hexbinning is een techniek om een grote hoeveelheid datapunten te verdelen in gelijke zeshoeken. Vervolgens worden deze zeshoeken ingekleurd om een indicatie te geven van het aantal datapunten in het zeshoek.

<!--  afbeelding met het verschil tussen datapunten en hexbin --> 

In de bovenstaande afbeelding is het verschil tussen het tonen van datapunten versus het gebruik van hexbinning te zien.


# 4 Test Results

- To validate the response times we did some tests..
- Introduction to tests
# 4.1 First Query

2. __Rain fall above 10 mm within 50 km.__  
Show data about rain fall when it is above 10 mm. Don't show when rain fall is below that. Only stations within 50 km of coastline of the Baltic Sea.

## 4.2 Second Query

3. __Graphs of temperature and humidity.__  
Be able to show a graph of temperature and humidity of any individual weatherstation. (Since previous midnight). Any weatherstation worldwide.


# 5 Glossary

This is an alphabetical list of technical terms used in this SLA with their definitions.

- __Server__
	> A server is a computer that provides data to other computers. It may serve data to systems on a local area network (LAN) or a wide area network (WAN) over the Internet.
	> --- http://www.techterms.com/definition/server

- __SSL Connection__
	> Stands for "Secure Sockets Layer." SSL is a secure protocol developed for sending information securely over the Internet. Many websites use SSL for secure areas of their sites, such as user account pages and online checkout. Usually, when you are asked to "log in" on a website, the resulting page is secured by SSL.
	> --- http://www.techterms.com/definition/ssl

- __Database__
	> A database is a data structure that stores organized information. 
	> --- http://www.techterms.com/definition/database
