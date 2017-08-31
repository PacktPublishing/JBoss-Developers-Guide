Camel Project for Blueprint 
=========================================

To build this project use

    mvn fabric8:zip install




Deploy the application

Standalone Mode

	 JBossFuse:karaf@root> osgi:install -s mvn:com.beosbank.jbdevg.jbfuse/beosbank-file-processor/1.0.0-SNAPSHOT

Fabric 
 
	JBossFuse:karaf@root> profile-import mvn:com.beosbank.jbdevg.jbfuse/beosbank-file-processor/1.0.0-SNAPSHOT/zip/profile
 

For more help see the Apache Camel documentation

    http://camel.apache.org/
     
