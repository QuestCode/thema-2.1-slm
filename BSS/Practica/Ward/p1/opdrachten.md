# Practicum opdrachten week 1

**1.1 Explain the difference between protection and security. (1.7)**

Protection is het reguleren van de toegang van processen of gebruikers naar de data.
Security is het beveiligen van deze data van misbruik van derden en het beveiligen tegen aanvallen van zowel intern als extern.


**2.1 What is the main function of the command interpreter? (2.3)**

Het opvangen en uitvoeren van het volgende commando dat door een gebruiker is opgegeven.


**2.2 Describe three general methods for passing parameters to the operating system (2.13) system calls. (2.8)**

* Registers (maximale lengte en maximaal aantal registers)
* Opgeslagen in een block of tabel in het geheugen en de locatie wordt opgeslagen (als een parameter) in een register
* Op de stack


**3.1 What is the difference between a process and a program? (3.1)**

Een process is een programma wat op het moment uitgevoerd wordt. Een programma is niets meer dan een serie bestanden op een medium. Een process ontstaat wanneer dit programma wordt uitgevoerd.


**3.2 What are the five process states that defines the current activity of a process. (3.2)**

1. __New__
  * Er wordt een process aangemaakt
2. __Ready__
  * Het process wacht tot het een processor krijgt toegewezen
3. __Running__
  * Het process (instructies) wordt uitgevoerd
4. __Waiting__
  * Het process wacht tot het verder mag/kan (wacht bijv op een I/O taak of wacht op een ander process)
5. __Terminated__
  * Het process is klaar of beindigd


**3.3 What is the difference between a process and a thread? (3.3)**

Een tread is een entiteit binnen een process waarin iets afgehandeld kan worden. In nieuwere systemen kan een process meerdere treads bevatten en dus meerdere taken tegelijk doen.


**3.4 What are the two models of interprocess communication? What are the strengths and weaknesses of the two approaches ? (3.10)**

* Shared memory
  * Hoge snelheid, Niet scalable
* Message passing
  * Lagere snelheden, Scalable


**3.5 Describe the actions taken by a kernel to context-switch between processes. (3.17)**

1. Status van huidige process wordt opgeslagen in zijn pcb
2. Status van volgende process wordt geladen (of teruggezet vanuit het pcb)