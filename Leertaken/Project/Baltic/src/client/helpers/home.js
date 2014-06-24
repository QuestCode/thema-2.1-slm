Template.home.events = {
	'click #toggle-world': function toggleWorld( e ) {
		e.preventDefault();

		app.WorldMap.showWorld();
	},
	'click #toggle-baltic': function toggleBaltic( e ) {
		e.preventDefault();

		app.WorldMap.showBalticSea();
	},
	'click #export-day': function exportDay( e ) {
		e.preventDefault();

		app.Export.lastDay();
	},
	'click #export-week': function exportWeek( e ) {
		e.preventDefault();

		app.Export.lastWeek();
	},
	'click #export-month': function exportMonth( e ) {
		e.preventDefault();

		app.Export.lastMonth();
	}
};