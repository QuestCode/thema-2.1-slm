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

>- __Application:__ The software for the service. Including new versions of the software, as defined in the agreement and service description;
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
- __Supplier:__ United Nations Weather DataManagement Institute - Da Vinci Data;
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

Team4S biedt de volgende cloud faciliteiten om de 200 werknemers van de opdrachtgever in staat te stellen via internet te beschikken over een centrale, betrouwbare opslag van gegevens. De cloud dienst zal 24/7 beschikbaar zijn. Veiligheid wordt gewaarborgd door het fysiek afschermen van de server (een speciaal toegewijde server die niet toegankelijk is voor derden).

De afdeling ICT heeft de volgende cloud-faciliteiten in beheer:

- Een cloud-server met bijbehorende systeemprogrammatuur;
- De in de cloud-overeenkomst aangegeven cloud-programmatuur;
- De voor het werken via internet benodigde technische infrastructuur (zoals routers, modems, bekabeling, etc.);
- De overige benodigde infrastructuur, zoals fysieke ruimte, elektra en dergelijke.

Deze faciliteiten bieden gebruikers de mogelijkheid om via het internet gebruik te maken van de cloud-dienst en bijbehorende cloud-programmatuur.

Ten behoeve van de operationele ondersteuning van de cloud-programmatuur levert de afdeling ICT de volgende diensten:

- Systeembeheer, applicatiebeheer en onderhoud van de bovenstaande cloud-faciliteiten;
- De voor implementatie van de cloud-programmatuur benodigde diensten, waaronder:
	- Vooronderzoek
	- Projectleiding
	- Inrichting
	- Functioneel en technisch ontwerp
	- Programmering
	- Testen
	- Opleiding
	- Klantbegeleiding
- Operationele ondersteuning, te weten klantbegeleiding en eerste- en tweedelijns servicedeskondersteuning;
- Inrichting hardware en systeemsoftware bij opdrachtgever, indien dit in de cloud-overeenkomst expliciet is vermeld.

De afdeling ICT schat de initiële hoeveelheid van data op 800 gigabyte met een lineaire groei van 10 gigabyte per maand.

Halfjaarlijks zal worden gekeken of deze groei van data nog doorzet of dat deze groei stopgezet kan worden.
### 2.1.1 Service Levels

Onderstaand worden de service levels van de Cloud dienst beschreven.

#### Beschikbaarheid

De Cloud dienst heeft voor de opdrachtgever en eindgebruikers een beschikbaarheid van 24 uur per dag, 7 dagen per week. Met een minimal uptime van 98% per jaar; waarbij de 2% downtime wordt veroorzaakt door storingen en geplande onderhoudswerkzaamheden. Middels Cloud-hosting wordt data aangeboden aan de gebruikers. Hiervoor is een internetverbinding vereist. Opslag van de data gebeurd op dezelfde wijze als voorheen, waardoor gebruikers op een transparante wijze hun werk kunnen voortzetten.

In verband met het verwerken van salarissen en andere kritieke processen worden periodes tussen de 25e en laatste dag van de maand als speciale piekperiodes gezien. Tijdens openstellingstijden (werkdagen van 8:00 - 17:30) en piekperiodes wordt een minimale uptime van 99,5% per jaar gegarandeerd.

#### Prestaties

Voor het bepalen van prestaties (Service Level Targets) zijn er Critical Success Factors (CSFs) opgesteld en hier vervolgens de Key Performance Indicators (KPIs) van afgeleid. Deze worden in de hierop volgende paragrafen beschreven.

Prestaties van de cloud kunnen op de volgende manier worden samengevat:

###### Het ophalen van data:
Op werkdagen van maandag t/m vrijdag van 08:00 - 17:30 kan een geautoriseerde gebruiker binnen 5 seconden data ophalen. Het zal niet vaker dan 10 keer per maand voorkomen dat het langer duurt dan 5 seconden. Beide condities gaan uit van een 'normale' situatie.

###### Het wegschrijven van data:
Op werkdagen van maandag t/m vrijdag van 08:00 - 17:30 kan een geautoriseerde gebruiker binnen 5 seconden data wegschrijven. Deze 5 seconden staan voor _het accepteren van het verzoek om te schrijven naar de cloud_. Afhankelijk van de bestandsgrootte(n) kan het natuurlijk veel langer duren dan 5 seconden om data weg te schrijven. Het zal niet vaker dan 10 keer per maand voorkomen dat het langer duurt dan 5 seconden. Beide condities gaan uit van een 'normale' situatie.

>Een 'normale' situatie is een situatie waarin er geen storingen of andere incidenten spelen die van invloed kunnen hebben op de beschikbaarheid van de cloud.

##### Critical Success Factors

De volgende punten zijn kritiek in het succesvol draaiend houden van de cloud-dienst:

- Data moet 24/7 beschikbaar zijn voor de gebruikers;
- Data moet overal beschikbaar zijn voor de gebruikers;
- Van de data moeten recente backups beschikbaar zijn;
- De data is vertrouwelijk en moet daarom beveiligd zijn en niet inzichtelijk zijn voor 3de partijen.

##### Key Performance Indicators

De onderstaande meeteenheden zijn gedefinieerd naar aanleiding van de kritieke success factoren. Deze succes factoren worden gebruikt voor het meten van de kwaliteit van de basisdiensten.

__Data moet 24/7 beschikbaar zijn voor alle gebruikers.__

| Meeteenheid                                        | Doel  | Bron                           |
| :----------                                        | :---  | :---                           |
| Uptime van de service.                             | 98%   | Gemeten uptime van de service. |
| Uptime van de service tijdens openstellingstijden. | 99.5% | Gemeten uptime van de service. |
| Uptime van de service tijdens piekuren.            | 99.5% | Gemeten uptime van de service. |

__Data moet overal beschikbaar zijn voor de gebruikers.__

| Meeteenheid                              | Doel | Bron                                                                                              |
| :----------                              | :--- | :---                                                                                              |
| Aantal hoge prioriteit incidenten.       | < 3  | Aantal binnengekomen incidenten over de service bij de servicedesk met een hoge prioriteit.       |
| Aantal gemiddelde prioriteit incidenten. | < 20 | Aantal binnengekomen incidenten over de service bij de servicedesk met een gemiddelde prioriteit. |
| Aantal lage prioriteit incidenten.       | < 50 | Aantal binnengekomen incidenten over de service bij de servicedesk met een lage prioriteit.       |

---

__Beschikbaarheid van recente backups.__

| Meeteenheid                                | Doel | Bron                                                                                  |
| :----------                                | :--- | :---                                                                                  |
| Aantal onopgeloste integriteitsincidenten. | 0    | Aantal binnengekomen integriteitsincidenten waarbij de data niet herstelt kan worden. |

__Vertrouwelijkheid van de data.__

| Meeteenheid                                | Doel | Bron                                                                                         |
| :----------                                | :--- | :---                                                                                         |
| Aantal server inbraken.                    | 0    | Aantal veiligheidsincidenten met betrekking tot service waarbij ingebroken is op de servers. |
| Het cijfer van een beveiligingsrapportage. | 8    | Halfjaarlijkse veiligheidsonderzoek door een externe partij.                                 |

#### Verliestijd

Voor het leveren van de cloud-dienst wordt gestreven naar een minimale verliestijd. De verliestijd is de hoeveelheid uren bij een integriteitsincident die verloren gaan. Wanneer een integriteitsincident zich voordoet wordt gebruik gemaakt van de laatst gemaakte backups. In de paragraaf _Backups_ wordt beschreven dat elke nacht een backup wordt gemaakt van de data. 

Dit betekent dat wanneer een integriteitsincident zich voordoet er gemiddeld 4 uur en drie kwartier aan verliestijd ontstaat (uitgaand van een opstellingstijd van 08:00 tot 17:30). Dir betekend dat de norm voor dataverlies per integriteits incident niet meer dan 5 uur is. De norm voor de totale verliestijd over de contractperiode is maximaal 2%. 

Wanneer een van de bovenstaande normen niet behaald wordt, wordt in samenwerking tussen de afdeling ICT en de opdrachtgever een dienstreview gedaan van de cloud-dienst om te bepalen waarom de gestelde norm(en) niet worden behaald.

#### Uitvoeren van onderhoud

Onderhoud aan de dienst zal plaatsvinden op standaard tijden. Dit zal zijn op dinsdagavond tussen 19:00 en 21:00 uur buiten piekperiodes.
Wanneer er met spoed onderhoud moet worden gepleegd (omdat de continuïteit of intergriteit van de dienst anders niet gewaarborgd kan worden) zal dit in overleg met opdrachtgever plaatsvinden en vooraf worden gecommuniceerd naar de gebruikers.

Duur van onderhoud zal subjectief zijn aan de uptime garantie en zal zodoende nooit langer kunnen duren dan 2 uur en 16 minuten per week buiten piekuren en 23 minuten per week binnen de piekuren.

__Berekening:__

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

Team4S biedt ter ondersteuning van de Cloud dienst een servicedesk. Deze servicedesk is gevestigd in Nederland en is beschikbaar voor alle werknemers van Team4S in zowel Nederland als Duitsland. De servicedesk zal van 8:00 tot 17:30 beschikbaar zijn, met uitzondering van algemeen erkende feestdagen in Nederland. Medewerkers van de servicedesk zullen zowel in de Duitse als Nederlandse taal bekwaam zijn.

Werknemers kunnen contact opnemen met de servicedesk voor:

- Vragen om advies en uitleg over de functionaliteit en de werking van de cloud dienst;
- Vastleggen, analyseren en oplossen van problemen.

### 2.2.1 Service Levels

#### Availability

The servicedesk will be available on working days from 8:00 to 17:30. Minimal availability between these hours will be 97%.

Below you'll find the Critical Success Factors and Key Performance Indicators that belong to the Service Level Targets.

##### Critical Success Factors

The following points are critical for the success of the servicedesk:

* Responding on new incidents on time.
* Resolving new incidents on time.
* The availability of the servicedesk.

##### Key Performance Indicators

Below you'll find the standards that define the Critical Success Factors. These will be used to measure the quality of the service.

__Timely responce to new incidents.__

| Measurement                                    | Goal         | Source                                                                                  |
| :----------                                    | :---         | :---                                                                                    |
| Amount of incidents with exeeding IRT          | <5           | Amount of incidents without response within the agreed upon IRT from the last 3 months. |
| Average IRT of incidents with high priority.   | < 15 minutes | Average IRT of all solved incidents with high priority from last 3 months.              |
| Average IRT of incidents with medium priority. | < 1 hour     | Average IRT of all solved incidents with medium priority from last 3 months.            |
| Average IRT of incidents with low priority.    | < 8 hours    | Average IRT of all solved incidents with low priority from last 3 months.               |


__Timely resolving of incidents.__

| Measurement                                             | Goal           | Source                                                                                    |
| :----------                                             | :--            | :---                                                                                      |
| Amount of incidents with exeeding MPT                   | <5             | Amount of incidents without resolution within the agreed upon MPT from the last 3 months. |
| Average resolve time of incidents with high priority.   | < half an hour | Average resolve time of all solved incidents with high priority from last 3 months.       |
| Average resolve time of incidents with medium priority. | < 4 hours      | Average resolve time of all solved incidents with medium priority from last 3 months.     |
| Average resolve time of incidents with low priority.    | < 3 work days  | Average resolve time of all solved incidents with low priority from last 3 months.        |


__The availability of the servicedesk.__

| Measurement           | Goal | Source                                                |
| :----------           | :--  | :---                                                  |
| Amount of complaints. | 0    | Amount of complaints recieved by the Service Manager. |


#### Responce and process times

De maximale duur van het oplossen van een incident ligt aan de prioriteit van het incident. De maximale respons- en oplostijd van incidenten met een gold-level servicedesk is als volgt:

| Prioriteit   | Initial Response Time | Maximum Process Time      |
| ------------ | ------------          | ------------------------- |
| High         | Within 15 minutes     | Within 30 minutes         |
| Medium       | Within 1 hour         | Within 4 hours            |
| Low          | Within 8 hours        | Within 3 work days        |


### 2.2.2 Risk Analysis

The servicedesk can also be subject to several risks. Although some of these risks are highly unlikely we must prepare for the consequenses these might propose, as we want to warrant the availability.

#### Risk descriptions

| Risk                | Chance | Impact |
| :---                | :---   | :---   |
| Phone defects       | Low    | Medium |
| Online-chat failure | Medium | Low    |
| Email failure       | Low    | Low    |



Het gevolg van een telefoonstoring wordt als 'gemiddeld' geclassificeerd omdat telefonisch contact met de servicedesk de meest efficiënte methode is. Telefonisch contact zorgt voor een snellere overdracht van informatie, een servicedesk-medewerker kan bijvoorbeeld ook doorvragen/troubleshooten. Een storing in het online-chat systeem is iets waarschijnlijker, maar de gevolgen hiervan zijn laag. Als de online-chat niet werkt zullen mensen vaak nog wel telefonisch de servicedesk kunnen bereiken. Als laatste risico heeft de email storing zowel een lage kans als een laag gevolg. Dit komt doordat email de minst geprefereerde manier van communicatie is. Email communicatie met de service desk werkt vaak traag, maar is vaak wel stabiel.

#### Maatregelen
Voor alle drie risico's kan er één uniforme maatregel getroffen worden, namelijk het verhogen van de responstijd op alle communicatiemiddelen. Afhankelijk van het gekozen pakket (Gold, Silver, Bronze) zullen er meer communicatiemiddelen beschikbaar zijn. Ook de responstijd per communicatiemiddel zal variëren met het gekozen pakket. Dit zorgt er voor dat áls één van de drie risico's daadwerkelijk voorkomt, klanten en servicedesk-medewerkers altijd kunnen terugvallen op een andere mogelijkheid.

### 2.2.3 Capaciteitsplanning

Omdat de opdrachtgever qua medewerkers verwacht te groeien in de komende jaren zal het aantal gebruikers dat aanspraak doet op de servicedesk ook stijgen. Vanwege deze groei is het belangrijk om tijdens een halfjaarlijkse evaluatie vast te stellen of de doelen gesteld bij de Critical Success Factors ook moeten stijgen.

Tijdens de bovenstaande evaluatie zal er tevens moeten worden bepaald of het budget van de servicedesk toereikend is. Deze zal mogelijk moeten worden verhoogd om de groei van gebruikers en het aantal problems en incidenten te kunnen blijven ondersteunen. En hiermee ook de Key Performance Indicators (zoals beschreven in _2.3.1 Service Levels_) te kunnen waarborgen.

Tot slot kan tijdens de proefperiode blijken dat het aantal geschatte problems en incidenten in eerste instantie te hoog of te laag is ingeschat. In dit geval zal afdeling ICT in overleg met de opdrachtgever tot nieuwe, en meer accurate, schatting moeten komen.

# 3 Tariefstructuur

Tariefstructuur\Eenmalige Kosten.md not found
## 3.2 Structurele Kosten

Om de cloud-software te blijven gebruiken, moet er maandelijks een bedrag betaald worden voor licenties en hosting. Tevens moeten de beschikbaar gestelde servicedesk medewerkers worden betaald. Dit brengt de volgende structurele kosten met zich mee:

| Onderdeel                                       | Maandelijks   | Jaarlijks      |
| :---                                            | :---          | :---           |
| Cloud-hosting                                   | € 400,-       | € 4.800,-      |
| Licenties voor cloud-software                   | € 100,-       | € 1.200,-      |
| Medewerkers servicedesk                         | € 1.000,-     | € 12.000,-     |
| <div style="text-align:right">__Totaal:__</div> | __€ 1.500,-__ | __€ 18.000,-__ |

In verband met de verwachte groei van data zullen de kosten van het onderdeel Cloud-hosting stijgen met €5,- per maand. Per jaar zal dit neerkomen op een stijging van €60,- euro.
## 3.3 Servicedeskondersteuning

De servicedesk krijgt maandelijks een vast bedrag van € 1.000,- toegewezen. Dit bedrag is bedoeld voor de ontwikkeling en onderhoud van de servicedesk. Denk daarbij aan:

- Nieuwe ontwikkelingen in de cloud-software;
- Uitgebreide testmogelijkheden;
- Aanschaf nieuwe apparatuur;
- Aannemen tijdelijke krachten voor ondersteuning bij uitrol-procedures;
- Licentiebeheer.

## 3.4 Niveau's van Dienstverlening

Onderstaand worden de klant- en basisdiensten uiteengezet tegen de beschikbare niveau's dienstverlening (brons, zilver en goed).

### Cloud Hosting

| Cloud-dienst                                      | Brons         | Zilver       | Goud         |
| :-----------                                      | :----         | :-----       | :---         |
| Algemene uptime.                                  | 94%           | 96%          | 98%          |
| Uptime tijdens piekperiodes en opstellingstijden. | 97%           | 98.5%        | 99.5%        |
| Snelheid ophalen van data.                        | < 15 seconden | < 7 seconden | < 5 seconden |
| Snelheid wegschrijven van data.                   | < 15 seconden | < 7 seconden | < 5 seconden |
| Aantal incidenten met hoge prioriteit             | < 10          | < 6          | < 3          |
| Aantal incidenten met gemiddelde prioriteit       | < 50          | < 35         | < 20         |
| Aantal incidenten met lage prioriteit             | < 100         | < 75         | < 50         |
| Aantal serverinbraken.                            | 2             | 1            | 0            |
| Cijfer beveiligingsrapportage.                    | n.v.t.        | 7            | 8            |
| Aantal onopgeloste integriteitsincidenten.        | 5             | 3            | 0            |

In de volgende tabel worden de risico's uiteengezet tegen de maatregelen per niveau van dienstverlening.

| Risico                                    | Maatregel 1                                                    | Maatregel 2                    | Bronze | Silver | Gold  |
| ---                                       | ---                                                            | ---                            | ---    | ---    | ---   |
| Externe cloudhosting partij gaat failliet | Bij kiezen van externe partij een sterkte-zwakteanalyse maken. |                                | -      | 1      | 1     |
| DDoS aanval op datacenter                 | Software om DDoS te voorkomen                                  | Interventieplan DDoS opzetten. | -      | 1      | 1 & 2 |
| Storing serversoftware                    | Onderhoudsabonnement afsluiten bij softwareleverancier         | Personeel bijscholen           | -      | 1      | 1 & 2 |
| Schijfuitval Server                       | Jaarlijks schijfeenheden nalopen en vervangen                  | Raid 10 toepassen              | -      | 1      | 1 & 2 |

---

### Servicedesk

| Servicedesk                                       | Brons        | Zilver      | Goud        |
| :----------                                       | :----        | :-----      | :---        |
| Beschikbaarheid servicedesk.                      | 93%          | 95%         | 97%         |
| Aantal incidenten die reactietijd overschrijden.  | < 15         | < 8         | < 5         |
| Aantal incidenten die doorlooptijd overschrijden. | < 15         | < 8         | < 5         |
| Reactietijd servicedesk - prioriteit hoog.        | 30 minuten   | 20 minuten  | 15 minuten  |
| Reactietijd servicedesk - prioriteit gemiddeld.   | 4 uur        | 2 uur       | 1 uur       |
| Reactietijd servicedesk - prioriteit laag.        | 5 werkdagen  | 2 werkdagen | 8 uur       |
| Doorlooptijd servicedesk - prioriteit hoog.       | 2 uur        | 1 uur       | 30 minuten  |
| Doorlooptijd servicedesk - prioriteit gemiddeld.  | 2 werkdagen  | 1 werkdag   | 4 uur       |
| Doorlooptijd servicedesk - prioriteit laag.       | 10 werkdagen | 6 werkdagen | 3 werkdagen |
| Aantal serviceklachten - servicedesk              | 5            | 3           | 0           |

### Jaarlijkse kosten per service level

| Onderdeel                                       | Brons          | Zilver        | Goud           |
| :---                                            | :-----         | :-----        | :---           |
| Cloud-hosting                                   | € 3.600,-      | € 4.300,-     | € 4.800,-      |
| Licenties voor cloud-software                   | € 1.200,-      | € 1.200,-     | € 1.200,-      |
| Medewerkers servicedesk                         | € 8.000,-      | € 10.500,-    | € 12.000,-     |
| <div style="te-t-align:right">__Totaal:__</div> | __€ 12.800,-__ | __€16.000,-__ | __€ 18.000,-__ |


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

## 5.1 Service Review

Elke maand levert de afdeling ICT een Service Level Rapportage aan de opdrachtgever. In dit rapportage worden van de diensten Cloud Hosting en Servicedesk de doelen van de Critical Success Factors naast de daadwerklijk behaalde waarden gelegd. Dit geeft een duidelijk overzicht of de gewenste kwaliteit van de diensten behaald wordt. Mocht de Critical Success Factor niet adequaat behaald worden dan wordt dit toegelicht in de rapportage waarmee vervolgens gegeken kan worden waar verbetering te halen is.

De Service Level Rapportage wordt uiterlijk 10 dagen na het einde van de maand geleverd.

Zie de bijlage _"Voorbeeld Service Level Rapportage.pdf"_ voor een voorbeeld van een Service Level Rapportage.
## 5.2 Proefperiode Rapportage

Aan het einde van de proefperiode wordt een rapport opgesteld op basis van de maandelijkse Service Level Rapportages. In dit rapport wordt beschreven welke doelen, gesteld in de Critical Success Factors, wel en niet realistisch zijn. Gekeken wordt naar de daadwerkelijk behaalde waardes in de maandelijkse rapportages tegenover de gezette doelen. 

Wanneer een doel regelmatig (meer dan 3 maanden) niet gehaald wordt kan deze als niet realistisch worden beschouwt en moet het doel opnieuw geevalueerd worden. Ook wanneer een doel een (eenmalige) grote overschrijding heeft moet deze opnieuw geevalueerd worden.

# 6 Glossary

#Glossary

Onderstaand verklaring van de in deze SLA gebruikte vaktermen in alfabetische volgorde.
B

- __Server__
	> A server is a computer that provides data to other computers. It may serve data to systems on a local area network (LAN) or a wide area network (WAN) over the Internet.
	> --- http://www.techterms.com/definition/server

-__VPN Connection__
	> A virtual private network is "tunneled" through a wide area network WAN such as the Internet. This means the network does not have to be located in one physical location like a LAN. However, by using encryption and other security measures, a VPN can scramble all the data sent through the wide area network, so the network is "virtually" private.
	> --- http://www.techterms.com/definition/vpn

# 7 Ondertekening

Ondertekening\Ondertekening.md not found