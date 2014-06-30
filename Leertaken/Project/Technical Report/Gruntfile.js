/*
How to use:

	$ npm install grunt-cli -g
	$ npm install
	$ grunt
	> See generated "Technical Report.md" for full document
*/

module.exports = function( grunt ) {
	grunt.initConfig({
		pkg: grunt.file.readJSON( 'package.json' ),
		preprocess: {
			document: {
				src: 'Report.structure.md',
				dest: 'Technichal Report.md'
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