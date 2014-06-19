## 1.5 Service Description/Definition

Customer wants to perform calculations on weather data to conduct research on climate change. Customer is interested in climate change in Lithuania and other countries around the Baltic Sea. Customer is especially interested in weather changes regarding the milder weather in the past years. Customer is interested in the following measurements:
- Windspeed
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

The customer wants to see data visualised according to the following two 'queries':  
__1. Rain fall above 10 mm within 50 km.__  
Show data about rain fall when the rain fall is more than 10 mm. Don’t show when rain fall is below that. Only stations within 50 km of coastline of the Baltic Sea. 

__2. Graphs of temperature and humidity.__  
Be able to show a graph of temperature and humidity of any individual
weatherstation. (Since previous midnight). Any weatherstation worldwide.


### 1.5.1 Client's requirements

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

### 1.5.2 Responsibilities supplier

Supplier zal ervoor instaan dat de service voldoet aan de volgende eisen:

- The service will be up 24/7, but the different queries have different availability requirements.
- Data will be backed up in different intervals depending on the query.
- There are different maximum response times defined depending on the query.
- Supplier will deliver monthly service reports.
- Supplier will set up a service desk.
- Supplier will ensure access is possible for 50 users.
  