### 2.2.1 Service Levels

Onderstaand worden de service levels van de Cloud dienst beschreven.

#### Beschikbaarheid

De Cloud dienst heeft voor de opdrachtgever en eindgebruikers een beschikbaarheid van 24 uur per dag, 7 dagen per week. Met een minimal uptime van 98% per jaar; waarbij de 2% downtime wordt veroorzaakt door storingen en geplande onderhoudswerkzaamheden. Middels Cloud-hosting wordt data aangeboden aan de gebruikers. Hiervoor is een internetverbinding vereist. Opslag van de data gebeurd op dezelfde wijze als voorheen, waardoor gebruikers op een transparante wijze hun werk kunnen voortzetten.

In verband met het verwerken van salarissen en andere kritieke processen worden periodes tussen de 25e en laatste dag van de maand als speciale piekperiodes gezien. Tijdens openstellingstijden (werkdagen van 8:00 - 17:30) en piekperiodes wordt een minimale uptime van 99,5% per jaar gegarandeerd.

#### Prestaties

Voor het bepalen van prestaties zijn er Critical Success Factors (CSFs) opgesteld en hier vervolgens de Key Performance Indicators (KPIs) van afgeleid. Deze worden in de komende paragrafen beschreven.

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

| Meeteenheid                                                  | Doel         | Bron                                                                                                              |
| :----------                                                  | :---         | :---                                                                                                              |
| Aantal hoge prioriteit incidenten.                           | < 3          | Aantal binnengekomen beschikbaarheidsincidenten over de service bij de servicedesk met een hoge prioriteit.       |
| Aantal gemiddelde prioriteit incidenten.                     | < 20         | Aantal binnengekomen beschikbaarheidsincidenten over de service bij de servicedesk met een gemiddelde prioriteit. |
| Aantal lage prioriteit incidenten.                           | < 50         | Aantal binnengekomen beschikbaarheidsincidenten over de service bij de servicedesk met een lage prioriteit.       |
| Gemiddelde oplostijd per incident met hoge prioriteit.       | < half uur    | Gemiddelde van de oplostijden van de beschikbaarheidsincidenten met een hoge prioriteit.                          |
| Gemiddelde oplostijd per incident met gemiddelde prioriteit. | < 4 uur      | Gemiddelde van de oplostijden van de beschikbaarheidsincidenten met een gemiddelde prioriteit.                    |
| Gemiddelde oplostijd per incident met lage prioriteit.       | < halve week | Gemiddelde van de oplostijden van de beschikbaarheidsincidenten met een lage prioriteit.                          |

__Beschikbaarheid van recente backups.__

| Meeteenheid                               | Doel | Bron                                                                                  |
| :----------                               | :--- | :---                                                                                  |
| Aantal onopgelost integriteitsincidenten. | 0    | Aantal binnengekomen integriteitsincidenten waarbij de data niet herstelt kan worden. |

__Vertrouwelijkheid van de data.__

| Meeteenheid                                | Doel | Bron                                                                                         |
| :----------                                | :--- | :---                                                                                         |
| Aantal server inbraken.                    | 0    | Aantal veiligheidsincidenten met betrekking tot service waarbij ingebroken is op de servers. |
| Het cijfer van een beveiligingsrapportage. | 8    | Halfjaarlijkse veiligheidsonderzoek door een externe partij.                                 |

#### Betrouwbaarheid

> MTBSI of MTBF

#### Uitvoeren van onderhoud

Onderhoud aan de dienst zal plaatsvinden op standaard tijden. Dit zal zijn op dinsdagavond tussen 19:00 en 21:00 uur buiten piekperiodes.
Wanneer er met spoed onderhoud moet worden gepleegd (omdat de continuiteit of intergriteit van de dienst anders niet gewaarborgd kunnen worden) zal dit in overleg met opdrachtgever plaatsvinden en vooraf worden gecommuniceerd naar de gebruikers.

Duur van onderhoud zal subjectief zijn aan de uptime garantie en zal zodoende nooit langer kunnen duren dan 15 minuten per dag buiten piekuren en 4 minuten per dag binnen de piekuren.

#### Verwachte maximale aantal problems per jaar

Per jaar worden er ongeveer maximaal 150 problems verwacht. Onder problems valt: alles wat van invloed kan zijn op de bereikbaarheid van de cloud voor één of meerdere gebruikers gedurende een bepaalde periode. Een trage of niet-werkende verbinding met het internet op de locatie van de gebruiker wordt niet als incident beschouwd.

#### Beveiliging

Omdat er wordt gewerkt met zeer vertrouwelijke informatie is een goede beveiliging van groot belang. Onderstaand worden maatregelen beschreven die zijn genomen om de veiligheid van de data te kunnen waarborgen.

##### Backups

Elke nacht wordt een incrementele backup gemaakt van de data op de cloud servers. Deze backup wordt uitgevoerd om twee uur 's nachts en duur maximaal twee uur. Elke zondagnacht wordt een totale backup gemaakt van de data om de integriteit van de data te behouden. Deze backup wordt om twee uur 's nachts uitgevoerd en duurt maximaal vier uur.

De backups worden opgeslagen op meerdere locaties om het risico van data verlies te beperken. De locaties bestaan uit het hoofdkantoor van Team4s en de cloud servers zelf.

Bij een integriteitsincident kan dankzij de dagelijkse backups een maximale dataverlies van één dag ontstaan.

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

Zoals beschreven in de paragraaf _Aansprakelijkheid_ valt een calamiteit onder het punt van overmacht en daarmee is ICT niet aansprakelijk voor schade van welke aard dan ook.

In de paragraaf _Backups_ staat beschreven dat er regelmatig backups worden gemaakt. Deze backups kunnen worden gebruikt bij een calamiteit om de Cloud dienst met minimale dataverlies opnieuw in werk te stellen.
