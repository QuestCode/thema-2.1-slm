/*

Source: http://www.meteobeverwijk.nl/info/luchtvochtigheid.aspx

De basis van de berekeningen is de aanpassing voor de verzadigde dampdruk (Vergelijking 1),
de zogenaamde Magnus formule.
De relatieve vochtigheid is gedefinieerd als de verhouding van de momentane dampdruk om verzadigde dampdruk (vergelijking 2).
Wanneer het dauwpunt temperatuur wordt gedefinieerd als de verzadigde dampdruk gelijk is aan de huidige dampspanning. Uit deze twee definities volgt onmiddellijk vergelijking 3,
de formule voor de berekening van de relatieve vochtigheid van de dauwpunt temperatuur.
De vierde Vergelijking beschrijft de omgekeerde berekening van het dauwpunt van de relatieve vochtigheid en de huidige temperatuur. Dit vierde Vergelijking is in principe niet anders dan de T verdwenen na de eerste Vergelijking met de verzadigde dampdruk van de werkelijke dampspanning (en niet de huidige verzadigde dampdruk) wordt gebruikt voor, zodat het dauwpunt temperatuur en niet het resultaat komt als een normale temperatuur. Uit de algemene gas vergelijking resultaten in de vijfde Vergelijking .
Alle vergelijkingen zijn voor een constante dampspanning. Omdat de dampspanning door een hydrostatische druk (gewicht van de waterdamp in de kolom ") is deze veronderstelling juist is, zolang de totale hoeveelheid waterdamp in de atmosfeer blijft hetzelfde.
Namen:
r = relatieve vochtigheid
T = temperatuur in ° C
TK = temperatuur in Kelvin (TK = T + 273,15)
TD = dauwpunt temperatuur in ° C
DS = dampspanning in hPa
SDD = verzadigde dampdruk in hPa
parameters:
a = 7,5
b = 237,3 voor T> = 0
a = 7.6
b = 240,7 voor T <0 boven water (dauwpunt)
a = 9.5
b = 265,5 voor T <0 op het ijs (vorst punt)
R* = 8314,3 J / (kmol * K) (universele gasconstante )
mw = 18.016 kg (moleculair gewicht van de waterdamp)
AF = absolute vochtigheid in gram waterdamp per m3 lucht
formules:
SDD (T) = 6,1078 * 10 ^ ((a * T) / (b + T))
DS (r, t) = r/100 SDD * (T)
r (T, TD) = 100 * SDD (TD) / SDD (T)
TD (r, t) = b * v / (av) v (r, t) = log10 (DS (r, t) / 6.1078)
AF (r, TK) = 10 m ^ 5 *w/ R* DS * (r, t) / TK, AF (TD, TC) = 10 m ^ 5 *w/ R* * SDD (TD) / TC
*/

var calculate_measurement_averages = ( function() {
	function SDD( T ) {
		var a, b;
		if( T >= 0 ) {
			a = 7.5;
			b = 237.3;
		} else {
			a = 7.6;
			b = 240.7;
		}
		return 6.1078 * Math.exp( ( ( a * T ) / ( b + T ) ) / Math.LOG10E );
	}

	function calculate_humidity( temp, dewp ) {
		if( dewp > temp ) {
			return 100;
		}

		return 100 * SDD( dewp ) / SDD( temp );
	}

	return function( datetime ) {

		var i, start, stop, cursor, result;

		start = new Date( datetime );
		start.setSeconds( 0 );
		stop = new Date( datetime );
		stop.setSeconds( 0 );
		stop.setMinutes( stop.getMinutes() + 1 );

		print( "Calculating measurement averages for minute: " + start );

		cursor = db.measurements.aggregate( [
			{ $match: {
				datetime: { $gte: start, $lt: stop }
			} },
			{ $group: {
				_id: "$stn",
				avg_prcp: { $avg: "$prcp" },
				avg_temp: { $avg: "$temp" },
				avg_dewp: { $avg: "$dewp" }
			} }
		] );

		db.measurement_averages.remove( { datetime: start } );

		while( cursor.hasNext() ) {
			result = cursor.next();

			db.measurement_averages.insert( {
				datetime: start,
				stn: result._id,
				avg_prcp: result.avg_prcp,
				avg_temp: result.avg_temp,
				avg_dewp: result.avg_dewp,
				avg_humi: calculate_humidity( result.avg_temp, result.avg_dewp )
			} );
		}
	};
} )();
