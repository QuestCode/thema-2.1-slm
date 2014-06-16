# Notes on SLM by Maurits

Music: https://play.spotify.com/artist/64UHlFDUkT8Hx3RCtDUieN. Ait.

## Lecture 1

ITIL life cycle:

1. Service Strategy
2. __Service Design__
3. __Service Transition__
4. __Service Operation__
5. Continual Service Improvement (CSI)

ITIL processes:

1. Change management
2. Process management
3. Service level management
4. Incident mangement
5. etc.

Process:

1. Tasks (agreement, standardization)
2. Activities (manage, analyse, report)
3. Control (plan-do-check-act)
4. Owner ("centraal aanspreekpunt")

SLM life cycle:

1. SLA management
2. Monitor and report					]
3. Service review						] = loop
4. Service improvement plan (SIP) 		]
5. Continual Process Improvement (CPI)	= outer loop

Implement SLM steps:

1. Determine position of SLM (hierarchy and internal/shared/external)
2. Appoint SLMer (involve in early stage)
3. IT goverance structure (define assets and targets, align with business requirements)
4. Define relationships with ITIL life cycles

Strategic:

1. Business value (interviews and collecting data)
2. Solution exploration (solutions, objectives, scope, CSFs, and KPIs)
3. Planning and closeout (strategic implementation plan, process charter)

1st line = servicedesk
2nd line = manager
3rd line = supplier

SLA period is typically __one year__ (half year pilot period).

## Lecture 2

Core of SLM is __intensive communication with customer__.

CMMI model to measure company maturity. Five levels:

1. Initial
2. Managed
3. Defined
4. Quantitatively Managed
5. Optimizing

Assessment should cover five areas:

1. Vision and control
2. Process
3. People
4. Technology
5. Culture

Activies for assessing:

1. Preparation
2. Interviewing
3. Scoring of gathered information
4. Document currently maturity level (intro, ITIL evaluation, remedation for each gap)
5. Roadmap for improvement, divided into:

	- Short-term (e.g. increase in availability, 1-6 months)
	- Medium-term (e.g. servicedesk, 6+ months)
	- Long-term (e.g. strategy, 1+ year)

Service Structure Document (before SLA) contains high level overview of services:

1. Stakeholders/involved parties
2. Boundaries of SLM
3. Topics:

	- Service scope
	- Financial implications
	- Cost of accounting
	- Service measurement and reporting
	- Budgets and funding
	- How many services?
	- Customer incentives

4. Service provider (SP)
5. Customer
6. Services (catagories and manager of each category), examples:

	- Managed application
	- Server service
	- Network
	- Service Desk
	- Communication
	- Desktop computing

Types:

1. Process
2. Business service (customer service)
3. IT service (base service)
4. Operational service (CI, e.g. hardware)

SLMer has three roles:

1. Service Management operations (owner and maintainer of SLAs)
2. Service Reporting (reports on service performances and trends)
3. Service Relationship Management (relate/interface with customers, performance meetings)

__RACI = Responsible, Accountable, Consulted, and Informed__

| Subprocess                    | SLM operations | Service relationship management | Service reporting |
| :---                          | :---           | :---                            | :---              |
| SLA Management                | R              | A                               | I                 |
| Monitoring and Reporting      | C              | C                               | A                 |
| Service Review                | R              | A                               | C                 |
| Service Improvement Plan      | R              | A                               | I                 |
| Continual Process Improvement | A              | I                               | I                 |

## Lecture 3

Service Level Agreement = Set _reasonable expectations_ through _measurable_ service _targets_ (norms) regarding the _services being provided_ and grant the service provider the ability to _monitor_, _measure_, and _report_ on agreed service levels.

Operational Level Agreement = Present a clear, concise and measurable description of the service provider's internal support relationships.

Parts of SLA:

1. Navigation (user friendly)
2. Introduction

	- Description
	- Owner, customer, and users
	- Service provider
	- SLA period (pilot period)
	- Service review
	- Service level credits (compliance management)
	- Service level reporting (reporting)

3. Scalable (support modifications)
4. Reporting (easy and clear)
5. Compliance management (penalties/bonuses)
6. Customer-based (covers all services for one customer)?
7. Service-based (covers on service for multiple customers)?
8. Service catalogue (list of services)

	- Name and description
	- Tracking period
	- Maintaince (planned downtime)
	- Availability (percentage and maximum number and duration of interruptions)
	- MTTR / MTBF
	- Performance
	- Data sources and tools (CSFs, KPIs)

9. Service objective table (service level targets)

Four quality indicators of SLA:

1. __Availability__
2. __Integrity__ (of data and information)
3. __Exclusivity__
4. __Performance__ (number of service-, support-, and change requests)

### Availability

Mean Time Between Failures (MTBF)

- The average duration of interruption free periods during the measuring period = the average uptime
- The total uptime in the measuring period / number of interruptions in the measuring period

Mean Time To Repair (MTTR)

- The average duration of the periods of interruption during the measuring period = the average downtime
- The total downtime in the measuring period / number of interruptions in the measuring period

Availability = uptime / agreed uptime * 100%
Availability = MTBF / (MTBF + MTTR) * 100%

__An interruption that occurred before the start of the measuring period and has not been solved at the starting point of the measuring period will not be counted__

Example:

	One week measurement
	Interruptions (3):					Downtime (4 hours)
		Monday from 15:00-19:00			2 hours
		Wednesday from 10:30 - 12:00	1.5 hours
		Friday from 16:30 - 18:00		1.5 hours
	Workday			 = 9 hours
	Week			 = 9 * 5 = 45 hours
	MTTR			 = downtime / # of interrupts = 4 / 3 = 1.33 hours
	MTBF			 = uptime / # of interrupts = (45 - 4) / 3 = 13.66 hours
	Availability %	 = available time / opening time * 100% = 41 / 45 = 0.911 = 91.1%
					 = MTBF / (MTBF + MTTR) * 100% = 13.66 / 15 = 0.911 = 91.1%

Threats to availability:

1. Causes and incidents (wearing and aging, overload, human factors)
2. Causes of calamities (fires, floods, hurricanes, vandalism, etc.)

### Integrity

Prevention through:

1. Redundancy (backups, RAID)
2. Fallback facilities
3. Maintenance
4. System management tools
5. Monitoring of systems
6. Capacity planning
7. Prioritizing incidents
8. Use of work-arounds

Two types of integrity:

1. Data integrity (correctness and completeness of IT service data)
2. Information integrity (degree of information corresponding which the data is composed from)

Quantity integrity in SLA:

Loss time = time between start of event and the last backup
          = (sum of all losstime / total opening time) * 100%
          = lost working time (free customer service) or lost number of runs (scheduled customer service)

Example:

	Loss times (3)	Duration (42)
	1				8 hours
	2				9 hours
	3				9 hours
	4				4 hours
	5				7 hours
	6				5 hours

	Opening time = 220 days from 8:00 - 18:00 (10 hours)
	Loss time	 = (sum of loss time / total opening time) * 100%
				 = (42 / (10 * 220)) * 100%
				 = 1.9%

## Lecture 4

### Exclusivity

The extent in which data is accessible for a clearly defined group of authorized users (confidentiality, computer security).

No metrics, but certificates that will give confidence.

Examples:

| Type              | Threat                         | Measurement                            |
| :---              | :---                           | :---                                   |
| Data entry        | Unwanted viewing               | Be careful                             |
| Data transport    | Unwanted listening             | Use of encryption                      |
| Data storage      | Unwanted data access           | Physical protection and authentication |
| Data presentation | Unwanted viewing and listening | Security policy and plan               |

### Performance

Designing metrics and measurements:

1. Define from customer perspective
2. Guarantee certain quality
3. Measurable
4. Balance of technological possibilities and customer requirements (budget)

Type of metrics:

1. Service metrics (measuring quality of customer service)
2. Process metrics (measuring quality of service management)
3. Technology metrics (measuring quality of technical components)

Service metrics:

1. Availability (within opening times)

	- Percentage
	- MTTR
	- MTBF

2. Performance (from customer perspective)

	- Support requests
	- Change requests

3. Integrity
4. Exclusivity
5. Reliability (MTBF)
6. Maintainability (service restore time)

Designing service differentation:

1. Gather information about service, underlying business, requirements, and customer expectations
2. Quantify of service targets and service level requirements (SLRs, availability and performance)
3. Quantify service constraints (technical and financial)

## Lecture 5

### Capacity Planning

Aspects:

1. Adequate capacity for actual demand
2. Overcapacity for expansion of business services (customer services)
3. Overcapacity for better performance (peak hours)

Define unit of measurement per IT service (base service).

General definition: _[service target]% of severity [severity] incidents for [service type] service resolved within [duration] hours during [opening times]._

### Financial Management

Goals:

1. Right services for the right price is the right quality and margin of profit for the service provider (SP).
2. Drive down costs!

How to define costs:

1. Define the goal
2. Identify the business and IT services
3. Choost cost model
4. Identify cost drivers (categorize, e.g. labour costs)
5. Obtain costs for the cost drivers
6. Operate and optimize the cost model

Cost models:

1. Partial cost recovery = budget + part of the costs recovered from the customer
2. Zero sum game = 100% of the costs are charged back; no profit for the SP
3. Profit-oriented pricing = 100% of the costs are charged back + profit margin
4. Notional charging = charging on paper, but no money is transferred

Types of costs:

1. Material costs (direct)

	- Hardware purchase/usage
	- Software
	- Housing
	- Administration
	- Passing costs (electricity, third parties)

2. Personnel costs (indirect)

	- Salaries
	- Educational costs
	- Travelling expenses

Direct cost		 = directly related to service
Indirect cost	 = will later be charged to related services

Chargeback methods:

1. Tiered subscription ('gold', 'silver', 'bronze' levels)
2. Metered usage (measure real-time usage consumption)
3. Direct plus (charge accordingly for costs directly attributed to sevice)
4. Fixed or user cost (actual cost divided by denominator, such as number of users)

### Penalties

Types of penalties (financial incentives):

1. Service level (if service level is not met)
2. Penalty earn-back (allow SP to recoup financial penalties)
3. Bonuses (if SLTs are exceeded)

Penalty calculation through:

1. At-risk amount (percentage of monthly invoice that is subject to service level penalties)
2. Service tower pool allocation (percentage of total service level penalties allocated to service tower)
3. Service level allocation (percentage of total service level penalties allocated to metrics in service tower)

The toal at-risk pool is allocated, as a percentage, across predefined service towers within the SLA, where each service tower represents a grouping of related SLOs and KPIs (metrics).

## Lecture 6

Why is an SLA important?

1. It defines the expectations of the customer and Service Provider.
2. It requires measuring the outcomes of the SLTs (norms)
3. It requires improvements (CSI)

Activities in service operations phase (SLA-management process):

1. Develop SLAs as an _agreement_
2. Prepare SLA templates/metrics and measurement definitions/SLPs
3. Collect Service Level Requirements (SLRs) regarding performance expectations
4. Negotiate SLAs
5. Initiate SLA-audits (at end of pilot period, in context of CSI, and from a customer request)

### Service Review

Three levels of data modification to meet SLTs:

1. In SLA compliance report
2. In the raw, collected data
3. In the original (source) systems

The SLA details a list of service level objectives (SLOs) and the compliance level expected by the SP. Compliance reports present the results for service perfomances specified in the SLA.

Goal of service review (to promote positive customer perception):

1. Feedback from customer
2. Review of the previous period
3. Review of the SLA compliance report
4. REview of the performance costs
5. Review of the next period
6. Action items
7. "Topic of the day"

### Continues Service Improvement (CSI)

The SLM process should continuously improve itself with structured processes, goals and measurable activities:

1. Reactive corrective actions

	- Modify SLA based on audits
	- Modify reports, calculations
	- Modify service reviews
	- Service Improvement Plan (SIP)

2. Proactive corrective actions

	- Gap analysis (CMMI as assessment tool, result is roadmap)
	- Modify targets based of changes in business of the customer
	- Check CSFs and KPIs
	- Update operational activities (outdated knowledge, ineffiency, performance, and tools and methods)

Process improvement methodologies:

- SWOT-analysis
- Control charts
- Six Sigma
- Total Quality Management (TQM)
- Deming Cycle

Process improvement model:

1. Preparation (proactive)
2. Examination
3. Prioritization (reactive)
4. Direction
5. Redesign of the process
6. Implementation of improvements
7. Review of improvements
8. Close process improvement

### Service Improvement Plan (SIP)

Close gap between expected and actual quality of a customer service as measured and reported against SLTs.

All SIP items are in the Continual Service Improvement (CSI) register, which each stakeholder has access to.

The CSI register is a list (database) of prioritized oppurtunities, which will be input for many ITIL processes.

The SLMer attends service review meetings and monitors the progress of improvement actions.

### Service Relationship Management (SRM)

SRM (the SLM human factor) meets the customer frequently on operational level to build and maintain an positive relationship.

Core activities of SRMer:

1. Incident escalation, assist in incident closure, review complaints/compliments
2. Prepare and conduct the service review meetings
3. Prepare and conduct customer satisfaction surveys

Improvement actions will be recorded in the CSI register.

### Risk Management

SLM makes inventory of risks, analyses the risks, and takes measures to minimize/eliminate risks.

Possible risks:

1. Changes will fail
2. Reports are not on time or incorrect
3. SLAs are breached
4. Cultural differences
5. Resource problems
6. Problems with vendors or external SPs
7. Technical problems in the IT infrastructure

## Guest lecturer (two questions on exam)

In Dutch, fuck it.

Patrick Dijks, Ordina, 3000 werknemers.
Gevestigd in Nieuwegijn, Apeldoorn, en Groningen.
Actief in de sectoren overheid, financieel, industrie, en zorg.

Alle SLM'ers op één afdeling.

Agile en SCRUM worden gebruikt in beheer.

Extended Resource Team (near-shoring), partij in Servië.

Fasen:

1. Strategisch
2. Verkenning
3. Transitie
4. Uitvoering
5. Evaluatie
6. Retransitie

### Transitie fase

1. Initiatie

	- Overgang
	- Scope
	- Vertrekpunt
	- Risicoanalyse
	- Transitieplan

2. Overname

	- Contractdocument
	- Rapportages
	- Kennisoverdracht
	- Risicobeheersing
	- Overdracht
		+ Inspannings- en resultaatverplichting
		+ Kijken, meelopen, verifiëren van inzichten, leiden
	- Afspraken maken over:
		+ Diensten
		+ Beschikbaarheid
		+ Onderhoud
		+ Kosten
		+ Servicevenster
		+ Onderhoudsvenster
		+ Hoe en waar beheer (servicewijze)
		+ Service levels

Werken niet alleen met SLA, maar ook met:

1. Dossier Afspraken en Procedures (DAP)

	- Hoe rapporteer je
	- Welke afspraken zijn er gemaakt

2. Dossier Financiële Afspraken (DFA)

	- De SLM'er is verantwoordelijk voor de SLA en DAP, de contract manager voor de DFA. Echter hebben beide een nauwe samenwerking.

	- Bij kleinere klanten is de SLM'er ook verantwoordelijk voor de financiële zaken.

	- Een valkuil bij alleen maar "ja" is een onbeheersbare situatie, "nee" zeggen mag ook! Verkoop geen dingen die je niet waar kunt maken.

	- Accountmanager controleerd of dingen wel geleverd kunnen worden.

	- SLM'er is steeds meer een relatiemanager.

3. Overdracht

	- Formele overdracht
	- Contractdocumenten
	- Definitief
	- Beheerfase

4. Kwaliteit en kwaliteisbewaking

Grafische weergave:

              Functioneel beheer
              /                \
            FAB                 \
            /                    \
Applicatie beheer --- TAB --- Technisch beheer

Tooling:

1. JIRA
2. Customer portal
3. Subversion
4. Sharepoint
5. Monitoringsoftware

### Klanttevredenheidsonderzoek

Practief incidenten voorkomen door __trends rapportage__ met oog op hardware, applicaties, besturingssytemen, etc. (CIs).

Steekproefgewijs.

### Klantteams

Dedicated en shared (oplosgroepen).

Servicemanagere heeft gedeelde verantwoorelijkheid voor uitvoering met klantteams.

Ordina doet geen werkplekbeheer.

### Tot slot

Het service plan wordt met de klant geëvalueerd.

Impactanalyse om het volgende te bepalen:

1. Risico's
2. Tijd
3. Planning
4. Kosten

## Seven secrets of SLM

1. Service level reporting is not service level management
2. Effective SLM requires clear, service-oriented SLAs
3. Effective SLM requires definition of multiple Requirements and Targets
4. Effective SLRs & SLTs require LOB alignment
5. Effective SLA’s require breadth and depth
6. Effective SLA’s require multiple data sources
7. Effective SLM requires automation
