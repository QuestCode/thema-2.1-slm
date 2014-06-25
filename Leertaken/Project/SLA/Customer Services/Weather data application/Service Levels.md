### 2.1.1 Service Levels

This chapter will describe the service levels regarding the weather data application. This chapter was written assuming no particular Service Level Package. The chapter _Service Levels_ contains more information on the options and differences between these options.

#### Availability

The weather data application has a minimum availability of 97% on Mondays before 12:00. However, because this is a web application, the supplier will strive to keep the application available even outside of peak times. However, the supplier can not guarantee an availability percentage over this time period. The supplier will strive to perform all maintenance related processes during this time.

Because the initial requirement was for the weather data application to be accessible on Mondays before 12:00, this will now be deemed the peak times of the service. Depending on the service level, the supplier offers a higher minimum availability during these peak periods. (minimum of 97%)

#### Service Level Targets

Several Critical Success Factors (CSFs) and Key Performance Indicators (KPIs) have been outlined to define the Service Level Targets in a clear and concise manner.

Service Level Targets of the weather data application can be summarized in the following way;

###### Query load time
Both queries have a maximum load time of 1 minute on Mondays before 12:00. Only authorised users will be able to issue a query request.   

N.B.: the supplier guarantees the maximum load time of 1 minute only when there is no problem on the customer's side slowing the load time down. Chapter _1.8 Responsibilities_ contains more information on situations like these.

##### Critical Success Factors

The following points are of utmost importance in successfully keeping the weather data application available and ensuring it meets the Service Level Targets.

- Data must be retained for at least 6 months and available 97% of the time on mondays before 12:00
- Graphs/Maps related to the queries must load within 1 minute.
- Data must be backed up starting from every midnight (until the next midnight).
- The data may not be viewed or accessed by third parties.

##### Key Performance Indicators

The metrics below have been defined from the Critical Success Factors, these metrics will be used to measure the quality of the services.


__Data must be retained for at least 6 months and available 97% of the time on mondays before 12:00__

| Metric                              | Goal  | Source                   |
| :----------                         | :---  | :---                     |
| Uptime service                      | 98%   | Measured uptime service. |
| Uptime service during opening times | 99.5% | Measured uptime service. |
| Uptime service during peak hoours   | 99.5% | Measured uptime service. |

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


#### Losstime

To ensure service availability and data integrity, the supplier set up a maximum losstime. The definition of losstime is the amount of hours it takes for a backup to be restored after an integrity incident. This inevitably means that some amount of data depending on the losstime will be lost.

The maximum losstime for weather data is half an hour. If this loss time is exceeded, the supplier will schedule a service review with the client to evaluate why the loss time was exceeded and what measures can be taken to prevent this from happening.

#### Maintenance

Service maintenance will take place during set times. This will be on tuesday nights between 19:00 and 21:00 (if necessary). When maintenance has to urgently be performed (because the continuity or integrity of the service may be at risk), this will take place in accordance with the client. Customers will receive notice of maintenance at least half an hour before the start of the maintenance.

The duration of maintenance may depend on the severity of the issues and the uptime guarantee depending on the service level package.

__Calculation:__

A year has 365,25 (0,25 days to account for leap years).
The peak time (Mondays before 12:00) accounts for 12 hours a week. Which is 12 / 7 = 1,71 hours a day on average. Or 1,71 * 365,25 = 626,14 hours a year on average. And 626,14 / 24 = 26,09 days a year on average.

| Time       | Days  | Hours  | Availability | Maximum hours of downtime yearly |
| :---       | :---  | :---   | :---         | :---                             |
| Peak times | 26,09 | 626,14 | 97%          | 626,14 * 0,03 = __18,78__        |

The maximum amount of downtime a week during peak times is 26,09 / 52 = 0,50 hours (30 minutes).

#### Expected maximum amount of problems a year.

The supplier expects to encounter no more than 150 problems a year. Problems are defined as: anything that is not out of the supplier's control that will negatively impact the availability of the service for one or multiple users during the peak times. 

#### Security

Because the information is of great value to the supplier as well as the client, both these parties will take security measures to ensure the data remains secure. These security measures will be outlined and described in this chapter.
The supplier will setup a SSL-connection to secure safe data transport. Users of the application will agree to not store usernames or password locally. There will be a total of 50 users, with no segregation in privileges.

##### Backups

An incremental backup of all data used in the service will be started at midnight (local time in Kaunas) on every day and kept until the next midnight. This ensures that the client will always have access to the most recent data.

After an integrity incident, the daily backup will prevent data loss for the most part. The maximum amount of lost data will be equal to the amount of downtime. The supplier estimates that restoring a backup will not take more than an hour. 

##### Password policy

To prevent third parties from gaining access to the system by exploiting weak passwords, the service will enforce a password policy for all users. The password policy consists of the following requirements:

- Users are obliged to change their password every two months, before the first Monday of the month.
- Passwords have to meet the following requirements:
	- At least 8 characters
	- At least 1 capital letter
	- At least 1 symbol

Of course the passwords will be saved in a secure way (hashed and encrypted).

##### Customer responsibilities 

Even secure, complex passwords can be compromised. It is for this reason that the supplier also places strict requirements on the security on the customer's end.

Every customer logging in to the service needs to:
- Have ran a virus scan in the past week.
- Immediately change his/her password and notify the service desk if the customer suspects a third party has gained access to his/her account.

##### Monitoring

All software-related incidents will be logged. These logs will be saved. There are a couple conditions to this process:

- Logs will be saved up until a month after the incident.
- Depending on the priority of the incident, the supplier may decide to keep the log permanently. Especially if the supplier suspects this incident may indicate a problem in the future.

#### Calamities

The supplier defines calamities as incidents such as:
- Power outage
- Fire
- Theft

In the unlikely event of a calamity, the supplier will take immediate action to attempt to get the service back up and running as soon as possible. The supplier estimates that the service will always be back up within 5 hours of the event happening.

The _Responsibilities_ paragraph contains more information on what a calamity is and when a calamity is deemed 'beyond the supplier's control'.

The paragraph _Backups_ states that backups will be kept on a regular basis. These backups can be used in the event of a calamity to ensure the service will be back online with the least amount of data loss possible.