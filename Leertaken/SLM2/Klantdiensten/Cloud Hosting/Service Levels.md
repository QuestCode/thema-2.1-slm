### Service Levels

Onderstaand worden de service levels van de Cloud dienst beschreven.

#### Beschikbaarheid

De Cloud dienst heeft voor de opdrachtgever en eindgebruikers een beschikbaarheid van 24 uur per dag, 7 dagen per week. Met een minimal uptime van 98% per jaar; De 2% downtime wordt veroorzaakt door storingen en geplande onderhoudswerkzaamheden. Middels Cloud-hosting wordt data aangeboden aan de gebruikers. Hiervoor is een internetverbinding vereist. Opslag van de data gebeurd op dezelfde wijze als voorheen, waardoor gebruikers op een transparante wijze hun werk kunnen voortzetten.

In verband met het verwerken van salarissen en andere kritieke processen tussen de 25e en laatste dag van de maand, worden hiervoor speciale piekperiodes gehanteerd. De openstellingstijden (werkdagen van 8:00 - 17:30) worden ook als piekperiodes gezien. De piekperiodes hebben een minimale uptime van 99,5%.

#### Prestaties

Voor het bepalen van prestaties zijn er Critical Success Factors (CSFs) opgesteld en hier vervolgens de Key Performance Indicators (KPIs) van afgeleid. Deze worden in de komende paragrafen beschreven.

##### Critical Success Factors

De volgende punten zijn kritiek in het succesvol draaiend houden van de cloud-dienst:

- Data moet 24/7 beschikbaar zijn voor de gebruikers;
- Data moet overal beschikbaar zijn voor de gebruikers;
- Van de data moeten recente backups beschikbaar zijn;
- De data is vertrouwelijk en moet daarom beveiligd zijn en niet inzichtelijk zijn voor 3de partijen.

##### Key Performance Indicators

De onderstaande meeteenheden zijn gedefinieerd naar aanleiding van de kritieke success factoren. Deze worden gebruikt voor het meten van de kwaliteit van de basisdienst.

__Data moet 24/7 beschikbaar zijn voor alle gebruikers.__

| Meeteenheid                             | Bron                           |
| :----------                             | :---                           |
| Uptime van de service.                  | Gemeten uptime van de service. |
| Uptime van de service tijdens piekuren. | Gemeten uptime van de service. |

__Data moet overal beschikbaar zijn voor de gebruikers.__

| Meeteenheid                              | Bron                                                                                                              |
| :----------                              | :---                                                                                                              |
| Aantal hoge prioriteit incidenten.       | Aantal binnengekomen beschikbaarheidsincidenten over de service bij de servicedesk met een hoge prioriteit.       |
| Aantal gemiddelde prioriteit incidenten. | Aantal binnengekomen beschikbaarheidsincidenten over de service bij de servicedesk met een gemiddelde prioriteit. |
| Aantal lage prioriteit incidenten.       | Aantal binnengekomen beschikbaarheidsincidenten over de service bij de servicedesk met een lage prioriteit.       |
| Gemiddelde oplostijd per incident.       | Gemiddelde van de oplostijden van de beschikbaarheids incidenten.                                                 |

__Beschikbaarheid van recente backups.__

| Meeteenheid                               | Bron                                                                                  |
| :----------                               | :---                                                                                  |
| Aantal onopgelost integriteitsincidenten. | Aantal binnengekomen integriteitsincidenten waarbij de data niet herstelt kan worden. |

__Vertrouwelijkheid van de data.__

| Meeteenheid                                | Bron                                                                                         |
| :----------                                | :---                                                                                         |
| Aantal server inbraken.                    | Aantal veiligheidsincidenten met betrekking tot service waarbij ingebroken is op de servers. |
| Het cijfer van een beveiligingsrapportage. | Halfjaarlijkse veiligheidsonderzoek door een externe partij.                                 |

#### Betrouwbaarheid

	- MTBSI of MTBF

#### Uitvoeren van onderhoud

Onderhoud aan de dienst zal plaatsvinden op standaard tijden. Dit zal zijn op dinsdagavond tussen 19:00 en 21:00 uur.
Wanneer er met spoed onderhoud moet worden gepleegd (omdat de continuiteit of intergriteit van de dienst anders niet gewaarborgd kunnen worden) zal dit in overleg met opdrachtgever plaatsvinden en vooraf worden gecommuniceerd naar de gebruikers.

Duur van onderhoud zal subjectief zijn aan de uptime garantie en zal zodoende nooit langer kunnen duren dan 45 minuten per dag buiten piekuren en 10 minuten per dag binnen de piekuren.

#### Verwachte maximale aantal storingen per jaar

Per jaar worden er ongeveer maximaal 150 storingen verwacht. Onder storing valt: alles wat van invloed kan zijn op de bereikbaarheid van de cloud voor één of meerdere gebruikers gedurende een bepaalde periode. Een trage- of geen verbinding met het internet heeft op de locatie van de gebruiker wordt niet als incident beschouwd.

#### Beveiliging

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

##### Monitoring
Alle programmatuur-gerelateerde incidenten worden gelogged en opgeslagen, hier zitten een aantal voorwaarden aan:

- Logs blijven een maand na het incident beschikbaar.
- Afhankelijk van de prioriteit van een incident kan er besloten worden de logs permanent te bewaren, bijvoorbeeld wanneer deze nodig zijn als bewijsmateriaal.

#### Calamiteiten
Onder calamiteiten worden incidenten zoals storing, brand of diefstal waardoor de Cloud dienst niet langer (compleet) beschikbaar is voor de gebruikers. Bij het optreden van een calamiteit wordt alles in werk gesteld om de Cloud dienst zo snel mogelijk te hervatten, wat uiterlijk 5 werkdagen na het optreden van de calamiteit het geval zal zijn.

Zoals beschreven in de paragraaf _Aansprakelijkheid_ valt een calamiteit onder het punt van overmacht en daarmee is de afdeling ICT niet aansprakelijk voor schade van welke aard dan ook.

Om de integritiet van de cloud-dienstverlening te waarborgen worden alle cloud-programmatuur en gegevensbestanden regelmatig gekopieerd van de operationele cloud-server naar een tweede (backup) server, die eigendom is van de afdeling ICT. 

- Afhandeling van storingen in de cloud-programmatuur
- Back-up en restore (beschrijven hoeveel data er verloren gaat)
