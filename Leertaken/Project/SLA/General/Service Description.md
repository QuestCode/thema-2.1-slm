## 1.5 Service Description/Definition

The client wants to perform calculations on weather data to conduct research on climate change. The client is interested in climate change in Lithuania and other countries around the Baltic Sea and is especially interested in weather changes regarding the milder weather in the past years.

The client is interested in the following measurements:
- Wind speed
- Rainfall
- Temperature
- Humidity

The relevant countries:
- Lithuania
- Denmark
- Germany
- Poland
- Kalingrad (Russia)
- Estonia
- Latvia
- Finland
- Sweden

### 1.5.1 Application

The client wants a SSL secured webpages protected by a username and password showing a map of the Baltic countries. When clicking on a weather station the client wants a 'cockpit'-like view showing the wind speed, rainfall, temperature and humidity (color coded) per minute.

The application should have historic data of days, weeks and months included. Data should be saved for at least a half year. Allow this data to be downloaded.

### 1.5.2 Queries

The client wants to see data visualised according to the following two 'queries':    
__1. Rainfall above 10 mm within 50 km.__  
Show data about rainfall when the rainfall is more than 10 mm. Don’t show when rainfall is below that.
This query only applies to weatherstations within 50 km of the coastline of the Baltic Sea. 

__2. Graphs of temperature and humidity.__  
Be able to show a graph of temperature and humidity of any individual weatherstation (since previous midnight).
This query applies to any weatherstation worldwide.


### 1.5.3 Client's requirements

The client's requirements regarding the service are:

- 'Cockpit'-like graphical representation;
- History of data by days, weeks & months;
- Data retention: 6 months;
- Support for Google Chrome & latest version of Internet Explorer;
- Data & webinterface will be hosted by Supplier;
- Map with colourcode for windspeed and temperature values;
- Authenticate using username and password;
- No specific user roles, all users get the same permissions.
- Allow for data (for the past half a year in days/weeks/months) to be downloaded in Excel file;
- Only measurements per minute;
- SSL to secure safe datatransport.

### 1.5.4 Responsibilities supplier

Supplier will make sure the service will satisfy the following requirements:

- The service will be up 24/7, but the different queries have different availability requirements;
- Data will be backed up in different intervals depending on the query;
- There are different maximum response times defined depending on the query;
- Supplier will deliver monthly service reports;
- Supplier will set up a service desk;
- Supplier will ensure access is possible for 50 users.

