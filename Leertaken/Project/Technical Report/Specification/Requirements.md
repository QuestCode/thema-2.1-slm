## 2.1 Requirements

The first meeting resulted in a general outline of the application, which in turn exists of the following requirements:

Aleksandro Stulginskio Universitetas will perform calculations on weather data to conduct research on climate change. The university is interested in climate change in Lithuania and other countries around the Baltic Sea. The university is especially interested in weather changes regarding the milder weather in the past years. They would like 'sleet' measurements.

Also they are interested in the following measurements:

- Wind speed
- Rain fall
- Temperature
- Humidity

In the following (relevant) countries:

- Lithuania
- Denmark
- Germany
- Poland
- Kalingrad (Russia)
- Estonia
- Latvia
- Finland
- Sweden

#### Queries

These global functional requirements in turn translate into more detailed queries:

1. __Rain fall above 10 mm within 50 km.__  
Show data about rain fall when it is above 10 mm. Don't show when rain fall is below that. Only stations within 50 km of coastline of the Baltic Sea.

2. __Graphs of temperature and humidity.__  
Be able to show a graph of temperature and humidity of any individual weatherstation. (Since previous midnight). Any weatherstation worldwide.

#### Key requirements

The following key requirements were agreed upon:

- Cockpit-like graphical presentation, no 'boring' tables;
- History of data by days, weeks and months;
- Half a year (6 months) data retention;
- Support Google Chrome and latest version of Internet Explorer;
- Data and webinteface will be hosted by Da Vinci Data;
- Map with colour code for wind speed and temperature values;
- Authenticate using username and password, no specific user roles;
- Allow for data to be downloaded in Excel file for the past half a year in days/weeks/months;
- ONLY measurements per minute;
- SSL to secure safe data transport.

#### Load time for queries

Finally the maximum load time for the queries was discussed. The agreed time is 1 minute for both queries.
