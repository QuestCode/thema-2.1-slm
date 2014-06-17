## 1.7 Prioriteitbepaling

De volgende prioriteitbepaling wordt gebruikt om de reactie- en afhandeltijd te berekenen, deze tijden zijn afhankelijk van het niveau van de dienstverlening.

De onderstaand genoemde reactietijden zijn gebaseerd op het niveau 'goud'. De verschillen in reactietijd staan per niveau beschreven in paragraaf _Niveau's van Dienstverlening_.

### 1.7.1 Urgentie bepaling

Onderstaand het urgentie niveau per impact op het werkproces.

| Urgentie                         | Niveau     |
| -------------------------------- | ---------- |
| Het werkproces is niet gehinderd | Laag       |
| Het werkproces is gehinderd      | Gemiddeld  |
| Het werkproces ligt stil         | Hoog       |

### 1.7.2 Impact bepaling

Onderstaand het niveau per impact of gebruiker aantallen.

| Impact                                   | Niveau     |
| ---------------------------------------  | ---------- |
| Het incident betreft één gebruiker       | Laag       |
| Het incident betreft meerdere gebruikers | Gemiddeld  |
| Het incident betreft veel gebruikers     | Hoog       |

### 1.7.3 Prioriteitentabel

Onderstaand een matrix voor prioriteitbepaling aan de hand van de impact en urgentie.

| Impact / Urgentie      |                     |                          |                     |
| :--------------------- | ------------------- | ------------------------ | ------------------- |
| _Impact Hoog_          | Hoog                | Gemiddeld                | Gemiddeld           |
| _Impact Gemiddeld_     | Gemiddeld           | Gemiddeld                | Laag                |
| _Impact Laag_          | Gemiddeld           | Laag                     | Laag                |
|                        | _Urgentie Hoog_     | _Urgentie Gemiddeld_     | _Urgentie Laag_     |
|                        | _Urgentie Hoog_     | _Urgentie Gemiddeld_     | _Urgentie Laag_     |

### 1.7.4 Reactietijd

Onderstaand de uiterlijk reactie- en doorlooptijd per prioriteit.

| Prioriteit   | Reactietijd       | Doorlooptijd (planning)   |
| ------------ | ------------      | ------------------------- |
| Hoog         | Binnen 15 minuten | Binnen 1 uur              |
| Gemiddeld    | Binnen 60 minuten | Binnen 8 uur              |
| Laag         | Binnen 8 uur      | Binnen 7 werkdagen        |
