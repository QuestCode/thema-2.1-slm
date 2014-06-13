## Prioriteitenbepaling

De volgende prioriteiten bepaling wordt gebruikt om de reactie- en afhandeltijd te berekenen. Afhankelijk van het niveau van de dienstverlening kan dit afwijken.

### Urgentie bepaling

| Urgentie                         | Niveau     |
| -------------------------------- | ---------- |
| Het werkproces is niet gehinderd | Laag       |
| Het werkproces is gehinderd      | Gemiddeld  |
| Het werkproces ligt stil         | Hoog       |

### Impact bepaling

| Impact                                   | Niveau     |
| ---------------------------------------  | ---------- |
| Het incident betreft één gebruiker       | Laag       |
| Het incident betreft meerdere gebruikers | Gemiddeld  |
| Het incident betreft veel gebruikers     | Hoog       |

### Prioriteitentabel

| Impact / Urgentie      |                     |                          |                     |
| :--------------------- | ------------------- | ------------------------ | ------------------- |
| _Impact Hoog_          | 3                   | 2                        | 1                   |
| _Impact Gemiddeld_     | 4                   | 3                        | 2                   |
| _Impact Laag_          | 5                   | 4                        | 3                   |
|                        | _Urgentie laag_     | _Urgentie Gemiddeld_     | _Urgentie Hoog_     |

> NOTE: DEZE IS AFHANKELIJK VAN DE SERVICE LEVEL (MOET ERGENS ANDERS???)

### Reactietijd

| Prioriteit   | Reactiteit        | Planning (Doorlooptijd)   |
| ------------ | ------------      | ------------------------- |
| 1            | Binnen 15 minuten | Binnen 1 uur              |
| 2            | Binnen 30 minuten | Binnen 4 uur              |
| 3            | Binnen 60 minuten | Binnen 8 uur              |
| 4            | Binnen 4 uur      | Binnen 2 werkdagen        |
| 5            | Binnen 8 uur      | Binnen 7 werkdagen        |
