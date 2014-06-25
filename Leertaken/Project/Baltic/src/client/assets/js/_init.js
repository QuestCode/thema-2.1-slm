app.fixCasing = function( str ) {
	str = ( '' + str ).toLowerCase();
	var f = str.charAt( 0 ).toUpperCase();
	return f + str.substr( 1 );
};

Handlebars.registerHelper( 'fixCasing', function( text ) {
	return app.fixCasing( text );
} );