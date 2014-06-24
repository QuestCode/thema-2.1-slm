### 2.1.2 Risk Analysis

This chapter describes the possible risks for the availability of the application, and included are the measures to possibly prevent the risks.

#### Risk descriptions

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

#### Measures

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
