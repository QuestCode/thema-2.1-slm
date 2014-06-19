# Customer services

## Application

A SSL secured webpages protected by a username and password showing a map of the baltic countries. When clicking on a weather station they want a cockpit like view showing the wind speed, rain fall, temperature and humidity (color coded) per minute.

Historic data of days, weeks and months. Data should be saved for at least a half year. Allow this data to be downloaded.

#### Query 2: A overview of rain fall above 10mm

Show rainfall when above 10mm for stations within 50km of the coastline of the Baltic Sea.

#### Query 3:  Graphs of temperature and humidity

A graph that shows the temperature and humidity of any individual weatherstation worldwide (since previous midnight).

#### Key performance indicatiors for both queries

97% availability every week on mondays before 12:00. Back-up of all the data recieved that day from 00:00 local time. Maximum load time of 1 minute.

## Servicedesk

A servicedesk that will be availible on Monday to Friday from 07:00 to 20:00 local time.
Maximum responce time of 2 hours.

# Base services

None so far.

# Technical requirements

The following paragraphs describe the technical requirements per customer service.

## Application

#### Presentation of data

- __Rain fall above 10 mm within 50 km.__  
Show data about rain fall when it is above 10 mm. Don't show when rain fall is below that. Only stations within 50 km of coastline of the Baltic Sea.
- __Graphs of temperature and humidity.__  
Be able to show a graph of temperature and humidity of any individual weatherstation. (Since previous midnight). Any weatherstation worldwide.

Also see the following paragraph for more presentation requirements.

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

#### Lost data
- Query 2: Back-up of all data received that day from 00:00 (midnight, local time in Kaunas).
- Query 3: Back-up of all data received that day from 00:00 (midnight, local time in Kaunas).

#### Load time for queries

- Query 1: 10 seconds.
- Query 2: 1 minute.
- Query 3: 1 minute.

## Servicedesk

The servicedesk will be provided through the already setup Top-Desk enviroment.

Also:

- Service desk will be available on Monday to Friday from 7:00 to 20:00 (local time in Kaunas).
- Response time will depend on package. Maximum response time 2 hours.