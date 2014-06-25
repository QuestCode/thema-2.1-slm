# Service Level Agreement Summary

## Weather Data Application

##### Critical Success Factors

The following points are of utmost importance in successfully keeping the weather data application available and ensuring it meets the Service Level Targets.

- Data must be retained for at least 6 months and available 99.5% of the time on mondays before 12:00.
- Graphs/Maps related to the queries must load within 1 minute.
- Data must be backed up starting from every midnight (until the next midnight).
- The data may not be viewed or accessed by third parties.

##### Key Performance Indicators

The metrics below have been defined from the Critical Success Factors, these metrics will be used to measure the quality of the services.

__Data must be retained for at least 6 months and available 99.5% of the time on mondays before 12:00.__

| Metric                              | Goal  | Source                   |
| :----------                         | :---  | :---                     |
| Uptime service                      | 98%   | Measured uptime service. |
| Uptime service during opening times | 99.5% | Measured uptime service. |
| Uptime service during peak hours    | 99.5% | Measured uptime service. |

__Graphs/Maps related to the queries must load within 1 minute.__

| Metric                | Goal       | Source                                                        |
| :----------           | :---       | :---                                                          |
| Average response time | < 1 minute | Response time measured in tests on a wide variety of systems. |
| Maximum response time | < 1 minute | Response time measured in tests on a wide variety of systems. |

__Data must be backed up starting from every midnight (until the next midnight).__

| Metric                                 | Goal | Source                                                     |
| :----------                            | :--- | :---                                                       |
| Amount of failed or incomplete backups | 0    | Amount of incidents involving a corrupt or missing backup. |

__The data may not be viewed or accessed by third parties.__

| Metric                                        | Goal | Source                                                                                                          |
| :----------                                   | :--- | :---                                                                                                            |
| Amount of security breaches compromising data | 0    | Amount of security related incidents involving (suspected) successful retrieving of information by third party. |

---

<br/>

## Service desk

##### Critical Success Factors

The following points are critical for the success of the service desk:

* Responding to new incidents on time.
* Resolving new incidents on time.
* The availability of the service desk.

##### Key Performance Indicators

Below you will find the standards that define the Critical Success Factors. These will be used to measure the quality of the service.

__Timely response to new incidents.__

| Measurement                                    | Goal         | Source                                                                                  |
| :----------                                    | :---         | :---                                                                                    |
| Amount of incidents with exeeding IRT          | < 15         | Amount of incidents without response within the agreed upon IRT from the last 3 months. |
| Average IRT of incidents with high priority.   | < 15 minutes | Average IRT of all solved incidents with high priority from last 3 months.              |
| Average IRT of incidents with medium priority. | < 1 hour     | Average IRT of all solved incidents with medium priority from last 3 months.            |
| Average IRT of incidents with low priority.    | < 2 hours    | Average IRT of all solved incidents with low priority from last 3 months.               |


__Timely resolving of incidents.__

| Measurement                                             | Goal           | Source                                                                                    |
| :----------                                             | :--            | :---                                                                                      |
| Amount of incidents with exeeding MPT                   | < 15           | Amount of incidents without resolution within the agreed upon MPT from the last 3 months. |
| Average resolve time of incidents with high priority.   | < half an hour | Average resolve time of all solved incidents with high priority from last 3 months.       |
| Average resolve time of incidents with medium priority. | < 4 hours      | Average resolve time of all solved incidents with medium priority from last 3 months.     |
| Average resolve time of incidents with low priority.    | < 8 hours      | Average resolve time of all solved incidents with low priority from last 3 months.        |


__The availability of the service desk.__

| Measurement           | Goal | Source                                                |
| :----------           | :--  | :---                                                  |
| Amount of complaints. | 0    | Amount of complaints recieved by the Service Manager. |

---

<br/>

## Service Level Packages & Costs

### Implementation costs:

| Component                                                 | Costs          |
| :---                                                      | :---           |
| Development wather data application                       | € 10.125,-     |
| Hardware costs weather data application (Webserver)       | € 4.900,-      |
| Hardware costs weather data application (Database server) | € 8.000,-      |
| Service desk (Hardware)                                   | € 2.000,-      |
| <div style="text-align:right">__Total:__</div>            | __€ 25.025,-__ |

### Costs per year:

In this paragraph, the customer- and basic services' KPI's will be listed for each service level. The available service levels are bronze, silver and gold. __The numbers used in this chapter are based on amounts per month.__

__Weather data application:__

| Weather data application                         | Bronze       | Silver       | Gold         |
| :-----------                                     | :----        | :-----       | :---         |
| General uptime.                                  | 95%          | 97%          | 98%          |
| Uptime during peak times and opening times.      | 97%          | 98%          | 99.5%        |
| Amount of changes available                      | 6            | 9            | 12           |
| General load time for queries.                   | < 60 seconds | < 30 seconds | < 10 seconds |
| Maximum amount of incidents with high priority   | < 10         | < 6          | < 3          |
| Maximum amount of incidents with medium priority | < 50         | < 35         | < 20         |
| Maximum amount of incidents with low priority    | < 100        | < 75         | < 50         |
| Minimum score security report.                   | n.v.t.       | 7            | 9            |
| Maximum amount of unsolved integrity incidents.  | 5            | 3            | 0            |

---

<br/>

In the next table, the risks will be listed along with the measures that will be taken to prevent or react to these risks for each service level package.

| Risk                                | Measure 1                                                                                  | Measure 2                             | Bronze | Silver | Gold  |
| ---                                 | ---                                                                                        | ---                                   | ---    | ---    | ---   |
| Internet outage                     | Contracts with reliable parties                                                            | Backup internet connection            |        | 1      | 1 & 2 |
| Server instability (hardware fault) | After trial period, deliver a report evaluating the current hardware and different options | Free periodic hardware upgrade        | -      | 1      | 1 & 2 |
| DDoS attacks                        | DDoS protection software                                                                   | Intervention plan DDoS                | -      | 1      | 1 & 2 |
| Software fault (security/stability) | Real-time bug reporting to the development and maintenance team.                           | Set up a dedicated bug-resolving team | -      | 1      | 1 & 2 |
| Server software failure             | Employees with sufficient expertise                                                        | Maintenance contract with supplier    | -      | 1      | 1 & 2 |
| Server harddrive failure            | Raid configuration                                                                         | Monthly S.M.A.R.T./drive tests        | -      | 1      | 1 & 2 |


__Service desk:__

| Service desk                                        | Bronze         | Silver         | Gold       |
| :----------                                         | :----          | :-----         | :---       |
| Service desk availability.                          | 95%            | 97%            | 99%        |
| Max. amount of incidents that are exeeding the IRT. | < 10           | < 8            | < 5        |
| Max. amount of incidents that are exeeding the MPT. | < 10           | < 8            | < 5        |
| IRT of the service desk - priority high.            | 30 minutes     | 20 minutes     | 15 minutes |
| IRT of the service desk - priority medium.          | 4 hours        | 2 hours        | 1 hour     |
| IRT of the service desk - priority low.             | 6 hours        | 4 hours        | 2 hours    |
| MPT of the service desk - priority high.            | 90 minutes     | 1 hour         | 30 minutes |
| MPT of the service desk - priority medium.          | 8 hours        | 6 hours        | 4 hours    |
| MPT of the service desk - priority low.             | 3 working days | 2 working days | 8 hours    |
| Maximum amount of service desk complaints           | 5              | 3              | 0          |

---

<br/>

__Yearly costs for each service level:__

| Component                                      | Bronze        | Silver         | Gold           |
| :---                                           | :-----        | :-----         | :---           |
| Weather data application                       | € 6.900,-     | € 10.350,-     | € 20.700,-     |
| Service desk                                   | € 2.000,-     | € 6.000,-      | € 12.000,-     |
| Changes and Maintenance of the application     | € 900,-       | € 1.350        | € 2.700,-      |
| <div style="te-t-align:right">__Total:__</div> | __€ 9.800,-__ | __€ 17.700,-__ | __€ 35.400,-__ |

