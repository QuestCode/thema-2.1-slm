<h1 style="font-size:4em">Service Level Agreement</h1>
<h2 style="font-size:2.5em;margin:-30px 0 580px">Weather Data Application</h2>

> __Opdracht:__ Leertaak 4 (SLM2), thema 2.1-I, groep 1
>
> __Auteurs:__ <span style="display:inline-block;vertical-align:top">Tom Broenink, Ward Holthof, Yuri Hoogeweg,<br/>André Nanninga en Maurits van Mastrigt</span>
>
> __Datum:__ 23 juni 2014

<!-- header: Vertrouwelijk document - SLM2, Groep 1, Thema 2.1-I -->

# Inhoud

- 1 &nbsp;General											<span style="float:right;font-weight:bold">3</span>
	- 1.1 &nbsp;Begripsbepaling								<span style="float:right;font-weight:normal">3</span>
	- 1.2 &nbsp;Partijen									<span style="float:right;font-weight:normal">3</span>
	- 1.3 &nbsp;Inleiding									<span style="float:right;font-weight:normal">3</span>
	- 1.4 &nbsp;Goedkeuring SLA								<span style="float:right;font-weight:normal">3</span>
	- 1.5 &nbsp;Beschrijving van de Dienstverlening			<span style="float:right;font-weight:normal">3</span>
	- 1.6 &nbsp;Continuïteit van de Cloud-dienstverlening	<span style="float:right;font-weight:normal">4</span>
	- 1.7 &nbsp;Prioriteitbepaling							<span style="float:right;font-weight:normal">4</span>
	- 1.8 &nbsp;Aansprakelijkheid							<span style="float:right;font-weight:normal">5</span>
- 2 &nbsp;Customer Services										<span style="float:right;font-weight:bold">6</span>
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
- 6 &nbsp;Verklarende Woordenlijst							<span style="float:right;font-weight:bold">21</span>
- 7 &nbsp;Ondertekening										<span style="float:right;font-weight:bold">22</span>

# 1 General

In this chapter you will find a general description of the service and requirements.

## 1.1 Definitions

>- __Application:__ The weather data application. Including new versions of the software, as defined in the agreement and service description;
>- __Servicedesk:__ The point of contact for the customer for changes and problems regarding the service;
>- __Service:__ The service (and maintenance) that's supplied to the customer;
>- __Authentication:__ Electronic identification to ensure that the user trying to access the service is authorized to do so;
>- __Incident:__ A disturbance that keeps a user(s) from (partially) using a service;
>- __Major Incident__ A severe incident that cannot be solved within the MPT;
>- __Problem:__ A collection of incidents that might indicate a common cause;
>- __Initial Responce time (IRT):__ Within this time a response should be given to a new incident;
>- __Maximum Process Time (MPT):__ Within this time a incident should be resolved or be scaled up to a major incident / problem;


## 1.2 Parties

This Service Level Agreement (hereafter called: SLA) is a contract between the following parties:

- __Client:__ Aleksandro Stulginskio Universitetas - Faculty of Water and Land Management;
- __Supplier:__ United Nations Weather Data Management Institute - Da Vinci Data;
- __UNWDMI:__ The United Nations Weather Data Management Institute the umbrella organisation of Da Vinci Data
- __Users:__ The students and teachers of Aleksandro Stulginskio Universitetas;


## 1.3 Introduction

This Service Level Agreement (SLA) applies to all by Da Vinci Data signed contracts between Da Vinci Data and the client. This SLA describes the scope and the general requirements of the service to be delivered by Da Vinci Data.

On initial delivery of the service, Da Vinci Data and the client will sign a service contract. This service contract describes what the requirements are under which the service will be supplied to the client. This contract can be altered by the supplier; changes in the contract will therefore prevail above the definitions in this SLA.

The percentages and goals in this SLA are based on the 'gold' service level. The differences between levels are defined in the paragraph _Levels of Service_.


## 1.4 Approval Service Level Agreement

The approval of the SLA is a shared responsibility between the supplier and the client. If the SLA has to be altered, the responsibility for changing the SLA lies with the supplier. Permission for changes has to be given by the supplier. When changes have been made in the current SLA and the aspects of the service, the new SLA has to be agreed on by the supplier as well as the client.
 

## 1.5 Service Description/Definition

The client wants to perform calculations on weather data to conduct research on climate change. The client is interested in climate change in Lithuania and other countries around the Baltic Sea and is especially interested in weather changes regarding the milder weather in the past years.

The client is interested in the following measurements:
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


## 1.6 Continuity of the service

To preserve the continuity of the service, all software and data will regularly be backed up. Additional information on ways of preserving the continuity can be found in the _'Security'_ chapter.


## 1.7 Priority definitions

The following priority matrix will be used to define the IRT and the MPT.

### 1.7.1 Urgency definition

The urgency level defining the impact on the working process:

| Urgency                          | Level      |
| -------------------------------- | ---------- |
| Service is not hindered          | Low        |
| Service is hindered              | Medium     |
| Service has stopped              | High       |


### 1.7.2 Impact definition

The impact level defined by the amount of users affected:

| Users affected                           | Impact level |
| ---------------------------------------  | ----------   |
| The incident affects one user            | Low          |
| The incident affects several users       | Medium       |
| The incident affects a majority of users | High         |

### 1.7.3 Priorities Table

This matrix defines the priority of an incident, depending on the impact and urgency.

| Impact / Urgency       |                     |                          |                     |
| :--------------------- | ------------------- | ------------------------ | ------------------- |
| _Impact High_          | High                | Medium                   | Medium              |
| _Impact Medium_        | Medium              | Medium                   | Low                 |
| _Impact Low_           | Medium              | Low                      | Low                 |
|                        | _Urgency High_      | _Urgency Medium_         | _Urgency Low_       |
  
## 1.8 Responsibilities

Da Vinci Data is under no circumstances responsible if the requirements in this SLA are not met, if:

- The cause of the requirements not being met was out of Da Vinci Data's Control, such as:
	- Earthquakes
	- Fire
	- Theft
	- Floods
	- Epidecimics
	- Wars  
	
or:  
- If the incident has not been caused by Da Vinci Data, but by the client or a third party.



# 2 Customer Services

In this chapter you will find a description of the Customer services (Weather data application and Servicedesk).

## 2.1 Weather data application

The client wants to perform calculations on weather data to conduct research on climate change. The client is interested in climate change in Lithuania and other countries around the Baltic Sea and is especially interested in weather changes regarding the milder weather in the past years.
Da Vinci Data provides an application that allows the client to access the weather data.

The application will be used by 50 users who will all need a username and password in order to use the application. The service will be made available using an SSL connection. The application will be hosted in the Netherlands using a server that is property of the UNWMDI.

The supplier offers the following features in the application:

- A way for the customer to get a representation in which the rain fall of each weatherstation within 50 km of the coastline around the baltic sea is shown. (if the rain fall was more than 10 mm)
- A way for the customer to get a representation in which the temperature and humidity since the most recent midnight of any UNWDMI weather station is shown.
- A map showing weather stations with a colour code depending on the current temperature.
- A way for the customer to download data of the last 6 months in an Excel (files contain either a day, a week or a month of information)

These features offer an intuitive and cockpit-like feeling to the application, enabling users to easily access detailed information on current weather data as well as weather data from any period in the last 6 months.


The supplier manages to the following facilities needed to provide the service:
- A webserver containing the application;
- Certificates needed to make the SSL connection possible;
- The nessesary technical infrastructure (Computers, Firewalls, Routers, Kabels, etc.);
- Other infrasturcture, e.g., physical space, power supplies, offices, etc.;

These facilities offer users the possibility to access the service using the internet.


To support the development and implementation as well as continued operation of the service, Da Vinci Data offers the following services:
- System administrators, application administrators, maintanance of the service;
- Services needed to implement the service, e.g.:
	- Project management
	- Preparatory research
	- Functional an technical design
	- Software Programming
	- Testing
	- Installation
	- Education
	- User management
- Operational support, i.e. First- and seccond level servicedesk support;
- Installation of hardware and software at the client, if nessesary;
### 2.1.1 Service Levels

This chapter will describe the service levels regarding the Web Interface service. This chapter was written assuming no particular Service Level Package. The chapter _Service Levels_ contains more information on the options and differences between these options.

#### Availability

The Web Interface has a minimum availability of 97% on Mondays before 12:00. However, because this is a web application, Da Vinci Data will strive to reach and maintain a minimal uptime of 99% over the course of a year, even outside of the by the client stated times (Mondays before 12:00). There is a slight margin of not more than 3% (depending on the service level) to ensure room for software patches/releases and hardware maintenance.

Because the initial requirement was for the Web Interface to be accessible on Mondays before 12:00, this will now be deemed the peak period of the service. Depending on the service level, Da Vinci Data offers a higher minimum availability during these peak periods. (minimum 97%)

#### Service Level Targets

Several Critical Success Factors (CSFs) and Key Performance Indicators (KPIs) have been outlined to define the Service Level Targets in a clear and concise manner.

Service Level Targets of the Web Interface can be summarised in the following way;

###### Query load time
Both queries have a maximum load time of 1 minute on Mondays before 12:00. Only authorised users will be able to issue a query request.   

N.B.: Da Vinci Data guarantees the maximum load time of 1 minute only when there is no problem on the customer's side slowing the load time down. Chapter _1.8 Responsibilities_ contains more information on situations like these.

##### Critical Success Factors

The following points are of utmost importance in successfully keeping the Web Interface available and ensuring it meets the Service Level Targets.

- Data must be retained for at least 6 months and available 97% of the time on mondays before 12:00
- Graphs/Maps related to the queries must load within 1 minute.
- Data must be backed up starting from every midnight (until the next midnight).
- The data may not be viewed or accessed by third parties.

##### Key Performance Indicators

The metrics below have been defined from the Critical Success Factors, these metrics will be used to measure the quality of the services.


__Data must be retained for at least 6 months and available 97% of the time on mondays before 12:00__

| Metric                              | Target | Source                   |
| :----------                         | :---   | :---                     |
| Uptime service                      | 98%    | Measured uptime service. |
| Uptime service during opening times | 99.5%  | Measured uptime service. |
| Uptime service during peak hoours   | 99.5%  | Measured uptime service. |

__Graphs/Maps related to the queries must load within 1 minute.__

| Metric                | Target     | Source                                                        |
| :----------           | :---       | :---                                                          |
| Average response time | < 1 minute | Response time measured in tests on a wide variety of systems. |
| Maximum response time | < 1 minute | Response time measured in tests on a wide variety of systems. |

__Data must be backed up starting from every midnight (until the next midnight).__

| Metric                                 | Target | Source                                                     |
| :----------                            | :---   | :---                                                       |
| Amount of failed or incomplete backups | 0      | Amount of incidents involving a corrupt or missing backup. |

__The data may not be viewed or accessed by third parties.__
| Metric                                        | Target | Source                                                                                                          |
| :----------                                   | :---   | :---                                                                                                            |
| Amount of security breaches compromising data | 0      | Amount of security related incidents involving (suspected) successful retrieving of information by third party. |

---

#### Losstime

To ensure service availability and data integrity, Da Vinci Data set up a maximum losstime. The definition of losstime is the amount of hours it takes for a backup to be restored after an integrity incident. This inevitably means that some amount of data depending on the losstime will be lost.

The maximum losstime for weather data is half an hour. If this loss time is exceeded, Da Vinci Data will schedule a service review with the client to evaluate why the loss time was exceeded and what measures can be taken to prevent this from happening.

#### Maintenance

Service maintenance will take place during set times. This will be on tuesday nights between 19:00 and 21:00 (if necessary). When maintenance has to urgently be performed (because the continuity or integrity of the service may be at risk), this will take place in accordance with the client. Customers will receive notice of maintenance at least half an hour before the start of the maintenance.

The duration of maintenance may depend on the severity of the issues and the uptime guarantee depending on the service level package.

__Calculation:__

Een jaar heeft 365,25 dagen (kwart dag is voor schikkeljaren).
Van de 25e t/m het einde van de maand is per jaar 65,25 dagen.
De piekperiodes bevatten gemiddeld 5 werkdagen.

| Moment              | Dagen                         | Uren                        | Availability 99,5% | Maximale downtime op jaarbasis |
| :---                | :---                          | :---                        | :---               | :---                           |
| Piekuren            | 65,25                         | 65,25 * 24 = 1566           | 99,5%              | 1566 * (100% - 99,5%) = 7,83   |
| Openstellingstijden | 365,25 - 65,25 - 12 * 5 = 240 | 240 * 9,5 = 2280            | 99,5%              | 2280 * (100% - 99,5%) = 11,4   |
| __Subtotaal__       | __305,25__                    | __3846__                    |                    | __19,23__                      |
| Overig              | 365,25 - 305,25 = 60          | (365,25 * 24) - 3846 = 4920 | 98%                | 4920 * (100% - 98%) = 98,4     |
| __Totaal__          | __365,25__                    | __8766__                    |                    | __117,63__                     |

De maximale downtime per week tijdens piekuren en openstellingstijden is: 19,23 / 52 = 0,37 uur = 22,2 minuten.
Voor de overige tijden geldt een wekelijkse maximale downtime van: 117,63 / 52 = 2,26 uur = 2 uur en 15,6 minuten.

#### Verwachte maximale aantal problems per jaar

Per jaar worden er ongeveer maximaal 150 problems verwacht. Onder problems valt: alles wat van invloed kan zijn op de bereikbaarheid van de cloud voor één of meerdere gebruikers gedurende een bepaalde periode. Een trage of niet-werkende verbinding met het internet op de locatie van de gebruiker wordt niet als incident beschouwd.

#### Beveiliging

Omdat er wordt gewerkt met zeer vertrouwelijke informatie is een goede beveiliging van groot belang. Onderstaand worden maatregelen beschreven die zijn genomen om de veiligheid van de data te kunnen waarborgen.

##### Backups

Elke nacht wordt een incrementele backup gemaakt van de data op de cloud servers. Deze backup wordt uitgevoerd om twee uur 's nachts en duurt maximaal twee uur. Elke zondagnacht wordt een totale backup gemaakt van de data van de afgelopen week om de integriteit van de data te behouden. Deze backup wordt om twee uur 's nachts uitgevoerd en duurt maximaal vier uur.

De backups worden opgeslagen op twee fysiek gescheiden locaties om het risico van data verlies te beperken. De locaties bestaan uit het hoofdkantoor van Team4s en de cloud servers zelf.

Bij een integriteitsincident kan dankzij de dagelijkse backups een maximale dataverlies van één dag ontstaan. Het terugzetten van een incrementele back-up zal maximaal twee uur in beslag nemen. Het herstellen van de volledige dataset zal maximaal één werkdag in beslag nemen.

##### Exclusiviteit

De cloud server is op een afzonderlijke server gehost, dit zorgt voor fysieke exclusiviteit ten opzichte van de andere servers in het datacentrum.

De vertrouwelijke informatie is alleen beschikbaar voor werknemers van Team4S. Om zeker te zijn van de identiteit van de gebruiker wordt er gebruik gemaakt van encryptiemethoden. Elke gebruiker zal dan ook zijn eigen gebruikersnaam en wachtwoord krijgen.

##### Wachtwoord policy

Om ongeauthoriseerde toegang te voorkomen wordt er gebruik gemaakt van een stricte wachtwoord policy. Dit betekent dat:

- Gebruikers elke 2 maanden, vóór de eerste maandag van de maand hun wachtwoord dienen te veranderen.
- Wachtwoorden moeten voldoen aan de volgende eisen:
	- 8 of meer karakters
	- 1 of meer hoofdletters
	- 1 of meer symbolen

Deze policy wordt door de cloud-programmatuur gehandhaafd.

##### Eisen aan de leverancier

Voor het hosten van de server wordt gebruik gemaakt van een externe leverancier. Team4S stelt stricte eisen aan de betrouwbaarheid van deze leverancier om hoge kwaliteit in zowel uptime en beveiliging te kunnen garanderen.

- De leverancier dient te voldoen aan de eerder gestelde 'exclusiviteit' voorwaarden.
- De leverancier dient een rapportage op te leveren met alle incidenten die in het afgelopen jaar (vóór ingang van deze SLA) hebben plaatsgevonden. Aan de hand van een review van deze incidenten wordt besloten of de hardware van de leverancier voldoende beveiligd en beschikbaar is.
- De leverancier dient gevestigd te zijn in Nederland.

##### Eisen aan de klant

Ook de klant zal een aantal voorzorgsmaatregelen moeten treffen om de integriteit van zijn account te garanderen:

- Als de werknemer via een publiek netwerk ('hotspot') verbinding maakt zal deze eerst een VPN verbinding moeten opzetten.
- Indien de werknemer vermoedt dat een derde zich toegang tot zijn/haar account kan verschaffen dient de werknemer onmiddelijk zijn wachtwoord te veranderen en contact op te nemen met de servicedesk.

---

##### Monitoring

Alle programmatuur-gerelateerde incidenten worden gelogged en opgeslagen, hier zitten een aantal voorwaarden aan:

- Logs blijven een maand na het incident beschikbaar.
- Afhankelijk van de prioriteit van een incident kan er besloten worden de logs permanent te bewaren, bijvoorbeeld wanneer deze nodig zijn als bewijsmateriaal.

#### Calamiteiten

Onder calamiteiten worden incidenten zoals storing, brand of diefstal waardoor de Cloud dienst niet langer (compleet) beschikbaar is voor de gebruikers. Bij het optreden van een calamiteit wordt alles in werk gesteld om de Cloud dienst zo snel mogelijk te hervatten, wat uiterlijk 5 werkdagen na het optreden van de calamiteit het geval zal zijn.

Zoals beschreven in de paragraaf _Aansprakelijkheid_ valt een calamiteit onder het punt van overmacht en daarmee is ICT niet aansprakelijk voor schade van welke aard dan ook.

In de paragraaf _Backups_ staat beschreven dat er regelmatig backups worden gemaakt. Deze backups kunnen worden gebruikt bij een calamiteit om de Cloud dienst met minimale dataverlies opnieuw in werk te stellen.

### 2.1.2 Risicoanalyse

Onderstaand de risico- en maatregelbeschrijvingen voor de cloud-dienstverlening.

#### Risicobeschrijvingen

In de volgende tabel worden de risico's uiteengezet tegen impact, gevolgschade, kans en risico.

<table>
	<thead>
	  <tr>
	    <th>Dienst</th>
	    <th></th>
	    <th>Cloudhosting</th>
	    <th></th>
	    <th></th>
	    <th></th>
	    <th></th>
	    <th></th>
	    <th></th>
	  </tr>
	</thead>
	<tbody>
	  <tr>
	    <td>Betrouwbaarheidseisen</td>
	    <td></td>
	    <td>Beschikbaarheid</td>
	    <td>Integriteit</td>
	    <td>Exclusiviteit</td>
	    <td>RISICO</td>
	    <td>Beschikbaarheid</td>
	    <td>Integriteit</td>
	    <td>Exclusiviteit</td>
	  </tr>
	  <tr>
	    <td></td>
	    <td></td>
	    <td>Hoog</td>
	    <td>Hoog</td>
	    <td>Hoog</td>
	    <td>&nbsp;&nbsp;</td>
	    <td>&nbsp;&nbsp;</td>
	    <td>&nbsp;&nbsp;</td>
	    <td>&nbsp;&nbsp;</td>
	  </tr>
	  <tr>
	    <td></td>
	    <td>Impact</td>
	    <td></td>
	    <td>Gevolgschade</td>
	    <td></td>
	    <td>Kans</td>
	    <td>&nbsp;&nbsp;</td>
	    <td>RISICO</td>
	    <td>&nbsp;&nbsp;</td>
	  </tr>
	  <tr>
	    <td>Externe cloudhosting partij gaat failliet</td>
	    <td>Hoog</td>
	    <td>Hoog</td>
	    <td>Hoog</td>
	    <td></td>
	    <td>Laag</td>
	    <td>Gemiddeld</td>
	    <td>Gemiddeld</td>
	    <td></td>
	  </tr>
	  <tr>
	    <td>Internetstoring</td>
	    <td>Laag</td>
	    <td>Hoog</td>
	    <td>Laag</td>
	    <td></td>
	    <td>Laag</td>
	    <td>Gemiddeld</td>
	    <td>Laag</td>
	    <td></td>
	  </tr>
	  <tr>
	    <td>DDoS aanval op datacenter</td>
	    <td>Hoog</td>
	    <td>Hoog</td>
	    <td>Laag</td>
	    <td>Gemiddeld</td>
	    <td>Laag</td>
	    <td>Gemiddeld</td>
	    <td>Laag</td>
	    <td>Laag</td>
	  </tr>
	  <tr>
	    <td>Storing serversoftware</td>
	    <td>Hoog</td>
	    <td>Hoog</td>
	    <td>Laag</td>
	    <td></td>
	    <td>Gemiddeld</td>
	    <td>Hoog</td>
	    <td>Laag</td>
	    <td></td>
	  </tr>
	  <tr>
	    <td>Schijfuitval server</td>
	    <td>Gemiddeld</td>
	    <td>Hoog</td>
	    <td>Laag</td>
	    <td></td>
	    <td>Gemiddeld</td>
	    <td>Hoog</td>
	    <td>Gemiddeld</td>
	    <td></td>
	  </tr>
	</tbody>
</table>

---

#### Maatregelbeschrijvingen

In de volgende tabel worden de risico's uiteengezet tegen de maatregelen.

| Risico                                    | Kans      | Impact    | Maatregel  | Opmerking                                                                                     |
| :---                                      | :---      | :---      | :---       | :---                                                                                          |
| Externe cloudhosting partij gaat failliet | Laag      | Hoog      | Preventie  | De opslag van data bij twee losstaande partijen voorkomt dataverlies.                         |
| Internetstoring                           | Laag      | Laag      | Acceptatie | Internetstoringen zijn vaak van korte duur en hebben geen invloed op de correctheid van data. |
| DDoS aanval op datacenter                 | Laag      | Hoog      | Repressie  |                                                                                               |
| Storing serversoftware                    | Gemiddeld | Hoog      | Repressie  |                                                                                               |
| Schijfuitval server                       | Gemiddeld | Gemiddeld | Preventie  |                                                                                               |

| Risico                                    | Maatregel 1                                                    | Maatregel 2                    |
| ---                                       | ---                                                            | ---                            |
| Externe cloudhosting partij gaat failliet | Bij kiezen van externe partij een sterkte-zwakteanalyse maken. |                                |
| DDoS aanval op datacenter                 | Software om DDoS te voorkomen                                  | Interventieplan DDoS opzetten. |
| Storing serversoftware                    | Onderhoudsabonnement afsluiten bij softwareleverancier         | Personeel bijscholen           |
| Schijfuitval Server                       | Jaarlijks schijfeenheden nalopen en vervangen                  | Raid 10 toepassen              |

### 2.1.3 Capaciteitsplanning

De werklast van de Cloud dienst ligt voornamelijk op de Cloud servers en de hoeveelheid dataopslag. Omdat het principe van "de Cloud" is ontworpen met oog op het verwerken en opslaan van grote hoeveelheden data, is opschaling van de servers eenvoudig en heeft dit een lage impact op de beschikbaarheid. Tevens is het inzetten van minders servers bij een werklast of hoeveelheid data die lager uitvalt dan geschat, ook zonder grote gevolgen.

Voor de opslag van de data wordt er te allen tijden een overcapaciteit van minimaal 10% gehanteerd. Dit wil zeggen dat de Cloud Hosting opslagruimte altijd minimaal 10% meer is dan de hoeveelheid opgeslagen data. Omdat de Opdrachtgever verwacht flink te groeien in de komende jaren, zal tijdens een half jaarlijkse evaluatie bepaald worden of de opslagruimte op de Cloud Server uitgebreid moet worden. Hierbij wordt ook de bovenstaande 10% in acht genomen.

Omdat we hier praten over een cloud dienst nemen we bij de externe partij alleen opslagruimte af. Achterliggende processen als bandbreedte, cpu cycles en KWh zijn hier al in doorberekend.

Opslagruimte wordt weergegeven als Gigabytes (GB). Er zal in eerste instantie 800GB worden afgenomen en dit aantal zal stijgen met 10GB per maand.

## 2.2 Servicedesk

The supplier will support the weather data application with a Servicedesk. The Servicedesk will be hosted in the Netherlands and will be availible for all users of the application. The Servicedesk will be availible from Monday to Friday from 07:00 to 20:00 (local time in Kaunas). Employees of the servicedesk will be English speaking.

Users can contact the servicedesk for:
- Questions and advice about the application and its functionality;
- Recording, analysing and resolving of incidents;


### 2.2.1 Service Levels

#### Availability

The servicedesk will be available from Monday to Friday from 07:00 to 20:00 (local time in Kaunas). Minimal availability between these hours will be 97%.

Below you will find the Critical Success Factors and Key Performance Indicators that belong to the Service Level Targets.

##### Critical Success Factors

The following points are critical for the success of the servicedesk:

* Responding on new incidents on time.
* Resolving new incidents on time.
* The availability of the servicedesk.

##### Key Performance Indicators

Below you will find the standards that define the Critical Success Factors. These will be used to measure the quality of the service.

__Timely responce to new incidents.__

| Measurement                                    | Goal         | Source                                                                                  |
| :----------                                    | :---         | :---                                                                                    |
| Amount of incidents with exeeding IRT          | <5           | Amount of incidents without response within the agreed upon IRT from the last 3 months. |
| Average IRT of incidents with high priority.   | < 15 minutes | Average IRT of all solved incidents with high priority from last 3 months.              |
| Average IRT of incidents with medium priority. | < 1 hour     | Average IRT of all solved incidents with medium priority from last 3 months.            |
| Average IRT of incidents with low priority.    | < 2 hours    | Average IRT of all solved incidents with low priority from last 3 months.               |


__Timely resolving of incidents.__

| Measurement                                             | Goal           | Source                                                                                    |
| :----------                                             | :--            | :---                                                                                      |
| Amount of incidents with exeeding MPT                   | <5             | Amount of incidents without resolution within the agreed upon MPT from the last 3 months. |
| Average resolve time of incidents with high priority.   | < half an hour | Average resolve time of all solved incidents with high priority from last 3 months.       |
| Average resolve time of incidents with medium priority. | < 4 hours      | Average resolve time of all solved incidents with medium priority from last 3 months.     |
| Average resolve time of incidents with low priority.    | < 8 hours      | Average resolve time of all solved incidents with low priority from last 3 months.        |


__The availability of the servicedesk.__

| Measurement           | Goal | Source                                                |
| :----------           | :--  | :---                                                  |
| Amount of complaints. | 0    | Amount of complaints recieved by the Service Manager. |


#### Responce and process times

The maximum time spent on solving a incident depends on the priority of the incident. The maximum response- and processtime with a gold-level servicedesk is as following:

| Priority     | Initial Response Time | Maximum Process Time      |
| ------------ | ------------          | ------------------------- |
| High         | Within 15 minutes     | Within 30 minutes         |
| Medium       | Within 1 hour         | Within 4 hours            |
| Low          | Within 2 hours        | Within 8 hours            |



### 2.2.2 Risk Analysis

The servicedesk can also be subject to several risks. Although some of these risks are highly unlikely we must prepare for the consequenses these might propose, as we want to warrant the availability.

#### Risk descriptions

| Risk                | Chance | Impact |
| :---                | :---   | :---   |
| Phone defects       | Low    | Medium |
| Online-chat failure | Medium | Low    |
| Email failure       | Low    | Low    |

The consequences of a phone defect is described as 'medium' because phone contact is the most efficient way of contacting the Servicedesk. Phone contact ensures a fast transfer of information and allows the servicedesk employee to 
question and troubleshoot with the user.
A failure in the online-chat system has a higher probability but has no major consequences. When the online-chat function is no longer availible users are still able to phone the Servicedesk.
An email failure is also very unlikely and although this is a preffered means of communication for users it is not a very functional way communication. Therefore we consider the consequences to be low and give it a low impact.


#### Measures
In order to saveguard the availability of the Servicedesk we will increase the responce times of these means of communication. Depending on the service level (Gold, Silver, Bronze) there will be a higher responce time of the Servicedesk. This ensures that whenever one of there risks occurs users can fallback to one of te other means of communication.


### 2.2.3 Capaciteitsplanning

Because there will be a fixed amount of users on the system we can make an accurate estimate of the amount of users that will contact the Servicedesk.

If at any time reports show that the Servicedesk cannot handle the amount of incidents there will be an evaluation to decide if the budget for the servicedesk is still realistic or if some changes in this SLA need to be made in order to guarantee the Key Performance Indicators (as described in _2.3.1 Service Levels_).

If the conclusion at the end of the trial period shows that the amount of estimated incidents and problems is much higher or lower as initialy suggested the supplier and client will redefine these estimates (as described in _4.3 Trial period_).



# 3 Pricing

### 3.1 Implementation costs

To set up the servicedesk to support the new weather data application, new hardware and servicedesk training/employees will be necessary. These processes cause implementation costs:

| Part                                                | Costs          |
| :---                                                | :---           |
| Hardware costs web interface (Dedicated Server etc) | € 8.000,-      |
| Service desk (extra staff, service desk hardware)   | € 2.000,-      |
| <div style="text-align:right">__Total:__</div>      | __€ 10.000,-__ |

After the execution of the implementation processes, changes and maintenance can cause other costs. For example, the supplier will keep maintaining the software, ensuring it is up to date and remains bug-free. The client is obliged to start using the new releases within 6 months after the supplier delivers a new release. The estimated cost for this service is __€2500,-__ yearly. This includes installation, delivery, convertion and education for the servicedesk staff.


## 3.2 Structural costs

To provide continued use of the weather data application, a monthly sum will be needed for for example hosting. In addition to that, the servicedesk employees will need to be paid. Due to situations like these, the following structural costs have been defined:

__For the client:__  

| Monthly       | Yearly         |
| :---          | :---           |
| __€ 1.500,-__ | __€ 18.000,-__ |


__For the teacher:__

| Component                                       | Monthly       | Yearly         |
| :---                                            | :---          | :---           |
| Hosting                                         | € 400,-       | € 4.800,-      |
| Service desk employees                          | € 1.000,-     | € 12.000,-     |
| <div style="text-align:right">__Totaal:__</div> | __€ 1.500,-__ | __€ 18.000,-__ |


## 3.3 Servicedesk support

The servicedesk will recieve a monthly sum of € 1.000,-. This money will be used for the develoopment and maintenance of the servicedesk. For example:
- Keep the knowledge up-to-date when the weather data application gets a new release.
- Expand on servicedesk infrastructure and hardware when necessary.
- Hire new employees temporarily during release procedures.
- Licence management.


## 3.4 Levels of Service

In this chapter, each the customer- and basic services' KPI's will be listed for each service level. The available service levels are bronze, silver and gold.

### Weather data application

| Weather data application                         | Bronze       | Silver       | Gold         |
| :-----------                                     | :----        | :-----       | :---         |
| General uptime.                                  | 95%          | 97%          | 99%          |
| Uptime during peak times and opening times.      | 97%          | 98.5%        | 99.5%        |
| Load time for queries.                           | < 60 seconds | < 30 seconds | < 10 seconds |
| Maximum amount of incidents with high priority   | < 10         | < 6          | < 3          |
| Maximum amount of incidents with medium priority | < 50         | < 35         | < 20         |
| Maximum amount of incidents with low priority    | < 100        | < 75         | < 50         |
| Minimum score security report.                   | n.v.t.       | 7            | 9            |
| Maximum amount of unsolved integrity incidents.  | 5            | 3            | 0            |

In the table below, the risks will be listed along with the measures that will be taken to prevent or react to these risks for each service level package.

| Risk                                | Measure 1                                                                                  | Measure 2                             | Bronze | Silver | Gold  |
| ---                                 | ---                                                                                        | ---                                   | ---    | ---    | ---   |
| Server instability (hardware fault) | After trial period, deliver a report evaluating the current hardware and different options | Free periodic hardware upgrade        | -      | 1      | 1 & 2 |
| DDoS attacks                        | Software to prevent DDoS.                                                                  | Create an intervention plan.          | -      | 1      | 1 & 2 |
| Software fault (security/stability) | Real-time bug reporting to the development and maintenance team.                           | Set up a dedicated bug-resolving team | -      | 1      | 1 & 2 |

---

### Servicedesk

| Servicedesk                                                                         | Bronze          | Silver         | Gold           |
| :----------                                                                         | :----           | :-----         | :---           |
| Servicedesk availability.                                                           | 95%             | 97%            | 99%            |
| Max. amount of incidents that are not responded to within the maximum response time | < 15            | < 8            | < 5            |
| Max. amount of incidents that are not solved within the maximum solve time.         | < 15            | < 8            | < 5            |
| Responsetime servicedesk - priority high.                                           | 30 minutes      | 20 minutes     | 15 minutes     |
| Responsetime servicedesk - priority medium.                                         | 4 hours         | 2 hours        | 1 hours        |
| Responsetime servicedesk - priority low.                                            | 5 working days  | 2 working days | 8 hours        |
| Maximum solve time servicedesk - priority high.                                     | 2 hours         | 1 hours        | 30 minutes     |
| Maximum solve time servicedesk - priority medium.                                   | 2 working days  | 1 working days | 4 hours        |
| Maximum solve time servicedesk - priority low.                                      | 10 working days | 6 working days | 3 working days |
| Maximum amount of service desk complaints                                           | 5               | 3              | 0              |

### Yearly costs for each service level

| Component                                      | Bronze         | Silver        | Gold           |
| :---                                           | :-----         | :-----        | :---           |
| Web Interface                                  | € 3.600,-      | € 4.300,-     | € 4.800,-      |
| Employees servicedesk                          | € 8.000,-      | € 10.500,-    | € 12.000,-     |
| <div style="te-t-align:right">__Total:__</div> | __€ 11.600,-__ | __€14.800,-__ | __€ 16.800,-__ |



# 4 Implementation and Conditions

## 4.1 Demands to Infrastructure

The management of the IT-services of the company should be performed professionally with a high availability. The demands mentioned in _1.5 Service Description/Definitation_ can be translated to the following demands of infrastructure:

- Data and webinterface will be hosted by the Supplier;
- Application must be compatible with Google Chrome and the latest version of Internet Explorer;
- Users must authenticate using their personal username and password;
- Allow for data to be downloaded in Excel file for the past half a year in days/weeks/months;
- SSL to secure safe data transport.


## 4.2 Estimated date of delivery

The estimated date of delivery is 26th of June, 2014.


## 4.3 Trial period

This agreement has a trial period of six months. During this period, the set requirements and goals will be evaluated to determine whether they are realistic or not. 

At the end of the trial period, an extra report written based on the monthly Service Level Reports will be delivered. This report will describe every service and evaluate if each individual service requirement is reachable and which service requirements may need to be adjusted. Following the delivery of the report to the client, an evaluation will take place between the client and the supplier.

There are no bonus and malus arrangements during the trial period.


## 4.4 Bonus and Malus

There are bonuses, fines or other penalties defined in this Service Level Agreement. When the promised requirements, as defined in chapter _1.4 Service Description_ are not fully met, a warning will be issued by the client. After a warning, The supplier will start an internal evaluation and investigation to determine why they failed to deliver on the promised requirements.

When three warnings have been issued by the client, the supplier as well as the client will evaluate the situation together and possibly alter the SLA in order to guarantee meeting the requirements.



# 5 Rapportageverplichtingen

Rapportageverplichtingen\Service Review.md not found
Rapportageverplichtingen\Proefperiode Rapportage.md not found

# 6 Glossary

#Glossary

Onderstaand verklaring van de in deze SLA gebruikte vaktermen in alfabetische volgorde.
B

- __Server__
	> A server is a computer that provides data to other computers. It may serve data to systems on a local area network (LAN) or a wide area network (WAN) over the Internet.
	> --- http://www.techterms.com/definition/server


- __VPN Connection__
	> A virtual private network is "tunneled" through a wide area network WAN such as the Internet. This means the network does not have to be located in one physical location like a LAN. However, by using encryption and other security measures, a VPN can scramble all the data sent through the wide area network, so the network is "virtually" private.
	> --- http://www.techterms.com/definition/vpn

# 7 Ondertekening

Ondertekening\Ondertekening.md not found