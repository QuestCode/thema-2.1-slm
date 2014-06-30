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