/*
How to use:

	$ npm install grunt-cli -g
	$ npm install
	$ grunt
	> See generated "Concept SLA.md" for full document
*/

module.exports = function( grunt ) {
	grunt.initConfig({
		pkg: grunt.file.readJSON( 'package.json' ),
		preprocess: {
			document: {
				src: 'Rapport.structure.md',
				dest: 'Technisch rapport.md'
			}
		},
		watch: {
			markdown: {
				files: [ '**/*.md' ],
				tasks: [ 'preprocess' ],
				options: { spawn: false }
			}
		}
	} );

	grunt.loadNpmTasks( 'grunt-preprocess' );
	grunt.loadNpmTasks( 'grunt-contrib-watch' );
	grunt.registerTask( 'default', [ 'preprocess', 'watch' ] );
};