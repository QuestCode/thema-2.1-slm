# Minutes

> * Date: June 4th 2014
> * Time: 09.30 AM (CEST)
> * Venue: Van Doorenveste, room H150
> * Chair: Maurits van Mastrigt
> * Secretary: Yuri Hoogeweg

## Attendees

### Aleksandro Stulginskio Universtitetas
Mr. Stadman (Chancellor)
Ms. Wempe (Actinv vice Chancellor)

### Da Vinci Data
Mr. van Mastrigt (CEO)
Mr. Nanninga (Senior Data Acquisition)
Mr. Holthof (Senior ICT Services)
Mr. Hoogeweg (Senior Development & Maintenance)
Mr. Broenink (Junior Development & Maintenance)

## Announcements
Markus Wind was absent due to illess.

## General information
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

---

## Service

#### Security
- Users will not store usernames or passwords locally.
- 50 users, no segregation in privileges.

#### Availability
Three different levels of availability:

- Query 1: High. (99%) between 13:00 and 15:00
- Query 2: Moderate. (97%) every week on Monday before 12:00
- Query 3: Moderate. (97%) every week on Monday before 12:00

#### Lost data
- Query 1: Back-up of the last 2 hours.
- Query 2: Back-up of all data received that day from 00:00 (midnight, local time in Kaunas).
- Query 3: Back-up of all data received that day from 00:00 (midnight, local time in Kaunas).

#### Load time for queries
- Query 1: 10 seconds.
- Query 2: 1 minute.
- Query 3: 1 minute.

#### Language
The interface and data will be in English. No need for Lithuanian translations due to the many international students at the university.

#### Reporting
Monthly service reports.

#### Contract
Initially, one-year contract with a half year draft period. Possibility of increasing this to 5 years.

#### Service desk
- Service desk will be available on Monday to Friday from 7:00 to 20:00 (local time in Kaunas).
- Response time will depend on package. Maximum response time 2 hours.

#### Changes
- The amount of changes will depend on package. At least 6 changes a year will be allowed on any package.

## Agreements

- Email minutes
- Email suggestion and representations for type of graphs

## Any other business

There were no other points to discuss.

## Unscheduled business

There were no other points to discuss.

## Arrangements next meeting
- Minutes will be sent within 2 working days by email in PDF or Word format;
- Next meeting will be on the 26th of June;
- We will have a fully working application for the next meeting;
- We can email Chancellor Stadman or Acting Vice Chancellor Wempe if any questions arise.
