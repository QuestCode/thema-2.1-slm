# Leertaak 1 <small>Stresstest rapportage</small>

> __Groep:__ 1a
> __Auteurs:__ André Nanninga &amp; Maurits van Mastrigt
> __Datum:__ 17 mei 2014

---

# Inhoud

- Verklaring programmaonderdelen
	- Infrastructuur
	- Applicatie
- Stresstest resultaten
- Conclusie
- Verklarende woordenlijst

---

# Verklaring programmaonderdelen

## Infrastructuur

<center>
	!["Infrastructuur"](Figures/infrastructure.png "Infrastructuur")
</center>

- [A] Een overzicht van de door jouw gebruikte systemen en infrastructuur (zoals besturingssysteem, CPU, geheugen, netwerkoverzicht etc.);
- Hardwarespecificatie

## Applicatie

| Klasse            | Omschrijving                                                                                                                                    | Heeft instantie(s) van  |
| :---------        | :-----------------------------                                                                                                                  | :---------              |
| Runner            | Start van de applicatie, welke de server een X aantal seconden laat draaien en ondertussen metingen verricht.                                   | Server                  |
| Server            | Maakt een connectie met de database en accepteert continue inkomende connecties (vanaf de generator) en zet hiervoor Worker instanties op.      | Database, Worker        |
| Database          | Verbinding met de database. Stelt het systeem in staat database queries uit te voeren.                                                          | Database.Executor       |
| Database.Executor | Klasse voor het uitvoeren van een query in een aparte thread.                                                                                   |                         |
| Worker            | Accepteert inkomende data, verwerkt en corrigeert de data (middels een Corrector), en schiet deze in de database in (middels een RecordBuffer). | Corrector, RecordBuffer |
| Corrector         | Corrigeert ontbrekende of afwijkende data door middel van extrapolatie.                                                                         |                         |
| RecordBuffer      | Houdt een X aantal records vast, om deze één database query te kunnen inschieten (batch).                                                       | Database                |
| Record            | Helper voor waarden in een record object. voor het bepalen van missende waarden en het omzetten naar een database "INSERT" query.               |                         |

---

# Stresstest resultaten

- [A] Wat de gehaalde verwerkingssnelheid (aantal verwerkte berichten per seconde) is;
- [A] Welke resource de bottleneck vormt en door welk proces dit wordt veroorzaakt;
- [A] De resultaten van de stresstest inclusief je verklaring voor de maximale snelheid van de gegevenswerking. Je geeft hierbij aan:

---

# Conclusie

+ [A] Een onderbouwing van je uitleg met behulp van gegevens van tools zoals taskmanager, perfmon, top (of door jouw gebruikte, vergelijkbare tools). Voeg screenshots van deze gegevens toe.

---

# Verklarende woordenlijst

- Thread
- Query
- Batch
- Generator