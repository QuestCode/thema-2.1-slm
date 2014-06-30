# Ant

To simplify the development of the application the build tool [Ant](http://ant.apache.org/) was used. Ant is a Java built tool by Apache which is used to automate common tasks. These tasks could then be easily execute as to save time on development. By executing for example `ant setup` multiple tasks are executed to setup the entire development environment. Within the setup tasks the database is setup to create the appropiate collections and indexes, and import the weatherstations from a JSON file into the database. And the vector maps as detailed in the GeoData section are converted to GeoJSON to be used within the application.

Automated these tasks means that they are easier to use and any possible human errors are greatly reduced.