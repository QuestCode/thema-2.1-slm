# Weatherstation Measurements Specifications

Da Vinci Data provides weather data from weatherstations around the world. Each of these weatherstations measures an array of different meteorological data. Details of each of these data measurements are included in the table below.

| Measurement                              | Code   | Format                                                   |
| :----------                              | :---   | :-----                                                   |
| Station number                           | STN    | N/A                                                      |
| Date                                     | DATE   | Date in _YYYY-MM-DD_ format.                             |
| Time                                     | TIME   | Local time in _HH:MM:ss_ format.                         |
| Temperature                              | TEMP   | Temperature in _degrees celsius_.                        |
| Dew point                                | DEWP   | Dewpoint in _degrees celsius_.                           |
| Atmospheric pressure at station altitude | STP    | Atmospheric pressure at station altitude in _millibars_. |
| Atmospheric pressure at sea level        | SLP    | Atmospheric pressure at sea level in _millibars_.        |
| Visibility                               | VISIB  | Visibility in _kilometers_.                              |
| Windspeed                                | WDSP   | Windspeed in _kilometers per hour_.                      |
| Precipitation                            | PRCP   | Precipitation in _centimeters_.                          |
| Snow fall                                | SNDP   | Snow fall in _centimeters_.                              |
| Cloud cover                              | CLDC   | Cloud cover in _percentages_.                            |
| Winddirection                            | WNDDIR | Winddirection in _arc degrees_.                          |

## Events

Aside from the above measurements Da Vinci Data also registers wether any weather specific events have occured that day. These events are simply represented by a true or false value.

| Event        | Details                                                     |
| :----        | :------                                                     |
| Freeze       | Wether the temperature has dropped below 0 degrees celsius. |
| Rain         | Wether any precipitation has occured.                       |
| Snow         | Wether any snowfall has occured.                            |
| Hail         | Wether any hail has fallen.                                 |
| Thunderstorm | Wether any thunderstorms have occured.                      |
| Tornado      | Wether any tornados have occured.                           |
