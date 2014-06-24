Template.home.events = {
	'click #toggle-world': function toggleWorld( e ) {
		e.preventDefault();

		console.log( 'show world map' );
	},
	'click #toggle-baltic': function toggleBaltic( e ) {
		e.preventDefault();

		console.log( 'show baltic map' );
	},
	'click #export-day': function exportDay( e ) {
		e.preventDefault();

		console.log( 'export day' );
	},
	'click #export-week': function exportWeek( e ) {
		e.preventDefault();

		console.log( 'export week' );
	},
	'click #export-month': function exportMonth( e ) {
		e.preventDefault();

		console.log( 'export month' );
	}
};