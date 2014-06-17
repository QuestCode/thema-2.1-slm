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

##### Monitoring

Alle programmatuur-gerelateerde incidenten worden gelogged en opgeslagen, hier zitten een aantal voorwaarden aan:

- Logs blijven een maand na het incident beschikbaar.
- Afhankelijk van de prioriteit van een incident kan er besloten worden de logs permanent te bewaren, bijvoorbeeld wanneer deze nodig zijn als bewijsmateriaal.

#### Calamiteiten

Onder calamiteiten worden incidenten zoals storing, brand of diefstal waardoor de Cloud dienst niet langer (compleet) beschikbaar is voor de gebruikers. Bij het optreden van een calamiteit wordt alles in werk gesteld om de Cloud dienst zo snel mogelijk te hervatten, wat uiterlijk 5 werkdagen na het optreden van de calamiteit het geval zal zijn.

Zoals beschreven in de paragraaf _Aansprakelijkheid_ valt een calamiteit onder het punt van overmacht en daarmee is ICT niet aansprakelijk voor schade van welke aard dan ook.

In de paragraaf _Backups_ staat beschreven dat er regelmatig backups worden gemaakt. Deze backups kunnen worden gebruikt bij een calamiteit om de Cloud dienst met minimale dataverlies opnieuw in werk te stellen.
