# restlet-osgi-example

Example of building and testing a restlet service using OSGI/ServiceMix.

This has been tested on a vanilla Apache Servicemix 4.5.0 installation (full) .

mvn install assumes a vanilla servicemix installation running with the default
ports and default credentials.

## TODO

 * Add integration tests using pax-exam, pax-runner or something similar.
   * One idea is to create a separate 'integration' bundle, then deploy it alongside your bundle, which invokes 
     the embedded tests.
