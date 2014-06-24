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
- Indien de werknemer vermoedt dat een derde zich toegang tot zijn/haar account kan verschaffen dient de werknemer onmiddelijk zijn wachtwoord te veranderen en contact op te nemen met de service desk.

---

##### Monitoring

Alle programmatuur-gerelateerde incidenten worden gelogged en opgeslagen, hier zitten een aantal voorwaarden aan:

- Logs blijven een maand na het incident beschikbaar.
- Afhankelijk van de prioriteit van een incident kan er besloten worden de logs permanent te bewaren, bijvoorbeeld wanneer deze nodig zijn als bewijsmateriaal.

#### Calamiteiten

Onder calamiteiten worden incidenten zoals storing, brand of diefstal waardoor de Cloud dienst niet langer (compleet) beschikbaar is voor de gebruikers. Bij het optreden van een calamiteit wordt alles in werk gesteld om de Cloud dienst zo snel mogelijk te hervatten, wat uiterlijk 5 werkdagen na het optreden van de calamiteit het geval zal zijn.

Zoals beschreven in de paragraaf _Aansprakelijkheid_ valt een calamiteit onder het punt van overmacht en daarmee is ICT niet aansprakelijk voor schade van welke aard dan ook.

In de paragraaf _Backups_ staat beschreven dat er regelmatig backups worden gemaakt. Deze backups kunnen worden gebruikt bij een calamiteit om de Cloud dienst met minimale dataverlies opnieuw in werk te stellen.
