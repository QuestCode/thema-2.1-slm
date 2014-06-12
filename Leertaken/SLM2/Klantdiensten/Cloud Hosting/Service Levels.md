### Service Levels

Onderstaand worden de service levels van de Cloud dienst beschreven.

#### Beschikbaarheid

De Cloud dienst heeft voor de opdrachtgever en eindgebruikers een beschikbaarheid van 24 uur per dag, 7 dagen per week. Met een minimal uptime van 98% per jaar; De 2% downtime wordt veroorzaakt door storingen en geplande onderhoudswerkzaamheden. Middels Cloud-hosting wordt data aangeboden aan de gebruikers. Hiervoor is een internetverbinding vereist. Opslag van de data gebeurd op dezelfde wijze als voorheen, waardoor gebruikers op een transparante wijze hun werk kunnen voortzetten.

In verband met het verwerken van salarissen en andere kritieke processen tussen de 25e en laatste dag van de maand, worden hiervoor speciale piekperiodes gehanteerd. Tijdens openstellingstijden (werkdagen van 8:00 - 17:30) en piekperiodes wordt een minimale uptime van 99,5% gegarandeerd.

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

#### Snelheid en responstijd

	- Reactietijd
	- Gemiddelde en maximale storingsduur

#### Betrouwbaarheid

	- MTBSI of MTBF

#### Uitvoeren van onderhoud

Mean Time To Repair of Mean Time To Restore Service

Onderhoud aan de dienst zal plaatsvinden op standaard tijden. Dit zal zijn op dinsdagavond tussen 19:00 en 21:00 uur.
Wanneer er met spoed onderhoud moet worden gepleegd (omdat de continuiteit of intergriteit van de dienst anders niet gewaarborgd kunnen worden) zal dit in overleg met opdrachtgever plaatsvinden en vooraf worden gecommuniceerd naar de gebruikers.

Duur van onderhoud zal subjectief zijn aan de uptime garantie en zal zodoende nooit langer kunnen duren dan 

365 dagen per jaar = 8760uur



	- service windows, downtime

#### Verwachte maximale aantal storingen per jaar [Tom]

Per jaar worden er ongeveer maximaal 150 storingen verwacht. Onder storing valt: alles wat van invloed kan zijn op de bereikbaarheid van de cloud voor één of meerdere gebruikers gedurende een bepaalde periode. Als een gebruiker geen internetverbinding heeft, dan wordt dit niet als storing gezien.

#### Beveiliging

	- Exclusiviteit
	- Uitzendkrachtinformatie is vertrouwelijk. Waar staat de data (wel in Nederland)? Eigendom van data.
		- Contract met externe partij die de data opslaat in Nederland. Goede partij kiezen. Hoe kunnen wij dit verantwoorden? Juiste, meest betrouwebare, beschikbarepartij? 24/7 beschikbaarheid. Data mag fysiek gezien niet op gedeelde schijven staan. Beveiliging is belangrijk.

#### Calamiteiten

	- Integriteit
	- Afhandeling van storingen in de cloud-programmatuur
	- Back-up en restore (beschrijven hoeveel data er verloren gaat)
