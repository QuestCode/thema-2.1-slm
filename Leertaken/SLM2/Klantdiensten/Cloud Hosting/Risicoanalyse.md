### 2.2.2 Risicoanalyse

Onderstaand de risico- en maatregelbeschrijvingen voor de cloud-dienstverlening.

#### Risicobeschrijvingen

In de volgende tabel worden de risico's uiteengezet tegen de kans, gevolgschade en benodigde maatregel.

| Risico                                    | Kans      | Gevolgschade | Maatregel                                                                                                 |
| :---                                      | :---      | :---         | :---                                                                                                      |
| Externe cloudhosting partij gaat failliet | Laag      | Hoog         | Preventie.                                                                                                |
| Internetstoring                           | Laag      | Laag         | Acceptatie. Internetstoringen zijn vaak van korte duur en hebben geen invloed op de correctheid van data. |
| DDoS aanval op datacenter                 | Laag      | Hoog         | Repressie.                                                                                                |
| Storing serversoftware                    | Gemiddeld | Hoog         | Repressie.                                                                                                |
| Schijfuitval server                       | Gemiddeld | Gemiddeld    | Preventie.                                                                                                |

#### Maatregelbeschrijvingen

In de volgende tabel worden de risico's uiteengezet tegen de maatregelen per niveau van dienstverlening.

| Risico                                    | Maatregel 1                                                    | Maatregel 2                    | Bronze | Silver | Gold   |
| ---                                       | ---                                                            | ---                            | ---    | ---    | ---    |
| Externe cloudhosting partij gaat failliet | Bij kiezen van externe partij een sterkte-zwakteanalyse maken. |                                | x      | 1      | 1      |
| DDoS aanval op datacenter                 | Software om DDoS te voorkomen                                  | Interventieplan DDoS opzetten. | x      | 1      | 1 & 2 |
| Storing serversoftware                    | Onderhoudsabonnement afsluiten bij softwareleverancier         | Personeel bijscholen           | x      | 1      | 1 & 2 |
| Schijfuitval Server                       | Jaarlijks schijfeenheden nalopen en vervangen                  | Raid 10 toepassen              | x      | 1      | 1 & 2 |
