Camel Project for Blueprint 
=========================================

To build this project use

    mvn fabric8:zip install

To run the project you can execute the following Maven goal
   Add the beosbank-moneytransfert-cacheloader profile to a child container.

To deploy the project in OSGi. For example using Apache ServiceMix
or Apache Karaf. You can run the following command from its shell:


Start the databases docker containers
$ cd jbdevg/jbdatavirt/docker/
$ docker-compose up 



Deploy the application

Standalone Mode
	 JBossFuse:karaf@root> osgi:install -s mvn:com.beosbank.jbdevg.jbfuse/beosbank-moneytransfert-cacheloader/1.0.0-SNAPSHOT

Fabric 
   JBossFuse:karaf@root> profile-import mvn:com.beosbank.jbdevg.jbfuse/beosbank-moneytransfert-cacheloader/1.0.0-SNAPSHOT/zip/profile

For more help see the Apache Camel documentation

    http://camel.apache.org/
    
  Sample Logs
    
2017-05-28 09:39:28,437 | INFO  | //EsbTimerMinute | Codec21                          | 317 - org.jboss.logging.jboss-logging - 3.3.0.Final-redhat-1 | ISPN004006: /127.0.0.1:11322 sent new topology view (id=1, age=0) containing 1 addresses: [/127.0.0.1:11322]
2017-05-28 09:39:28,438 | INFO  | //EsbTimerMinute | mysqldb-africa-esblistener       | 232 - org.apache.camel.camel-core - 2.17.0.redhat-630187 | New Cache Entry: MoneyTransfer [id=1;CMRCMR001;1000.00;null;0237-2222-3333-0001;null;null]
2017-05-28 09:39:28,438 | INFO  | //EsbTimerMinute | mysqldb-africa-esblistener       | 232 - org.apache.camel.camel-core - 2.17.0.redhat-630187 | New Cache Entry: MoneyTransfer [id=2;CMRCAN001;5000.00;null;0237-2222-3333-0002;null;null]
2017-05-28 09:39:28,439 | INFO  | //EsbTimerMinute | mysqldb-africa-esblistener       | 232 - org.apache.camel.camel-core - 2.17.0.redhat-630187 | New Cache Entry: MoneyTransfer [id=3;CIVCMR001;2000.00;null;0225-2222-3333-0001;null;null]
2017-05-28 09:39:28,439 | INFO  | //EsbTimerMinute | mysqldb-africa-esblistener       | 232 - org.apache.camel.camel-core - 2.17.0.redhat-630187 | New Cache Entry: MoneyTransfer [id=4;SENCMR001;1500.00;null;0221-1111-1111-0001;null;null]
2017-05-28 09:39:28,440 | INFO  | //EsbTimerMinute | mysqldb-africa-esblistener       | 232 - org.apache.camel.camel-core - 2.17.0.redhat-630187 | New Cache Entry: MoneyTransfer [id=5;NIGCMR001;9000.00;null;0234-2344-4444-4401;null;null]
2017-05-28 09:39:28,440 | INFO  | //EsbTimerMinute | mysqldb-africa-esblistener       | 232 - org.apache.camel.camel-core - 2.17.0.redhat-630187 | New Cache Entry: MoneyTransfer [id=6;SAFETH001;1500.00;null;0027-4444-4444-0001;null;null]
2017-05-28 09:39:28,441 | INFO  | //EsbTimerMinute | mysqldb-africa-esblistener       | 232 - org.apache.camel.camel-core - 2.17.0.redhat-630187 | New Cache Entry: MoneyTransfer [id=7;CIVCMR002;1000.00;null;0225-2222-3333-0001;null;null]
2017-05-28 09:39:28,441 | INFO  | //EsbTimerMinute | mysqldb-africa-esblistener       | 232 - org.apache.camel.camel-core - 2.17.0.redhat-630187 | New Cache Entry: MoneyTransfer [id=8;CMRCMR002;1000.00;null;0237-2222-3333-0002;null;null]
2017-05-28 09:39:28,441 | INFO  | //EsbTimerMinute | mysqldb-africa-esblistener       | 232 - org.apache.camel.camel-core - 2.17.0.redhat-630187 | New Cache Entry: MoneyTransfer [id=9;CMRCMR003;5000.00;null;0237-2222-3333-0001;null;null]
2017-05-28 09:39:28,442 | INFO  | //EsbTimerMinute | mysqldb-africa-esblistener       | 232 - org.apache.camel.camel-core - 2.17.0.redhat-630187 | New Cache Entry: MoneyTransfer [id=10;CMRCMR004;800.00;null;0237-2222-3333-0001;null;null]
