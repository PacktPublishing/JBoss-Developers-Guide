Camel Project for Blueprint 
=========================================

To build this project use

    mvn fabric8:zip install

To run the project you can execute the following Maven goal
   Add the beosbank-vdb-wsproxy  profile to a child container.

To deploy the project in OSGi. For example using Apache ServiceMix
or Apache Karaf. You can run the following command from its shell:


Start the databases docker containers
$ cd jbdevg/jbdatavirt/docker/
$ docker-compose up 

# Start the VDB

	cd books/jbdevg/BeosBankDataVirtLab/install/dv63
	bin/standalone.sh

17:20:24,166 INFO  [org.jboss.as.server] (Controller Boot Thread) JBAS015859: Déploiement de "beosbank.vdb" (runtime-name: "beosbank.vdb


Deploy the application

Standalone Mode

	 JBossFuse:karaf@root> osgi:install -s mvn:com.beosbank.jbdevg.jbfuse/beosbank-vdb-wsproxy/1.0.0-SNAPSHOT

Fabric 
 
	JBossFuse:karaf@root> profile-import mvn:com.beosbank.jbdevg.jbfuse/beosbank-vdb-wsproxy/1.0.0-SNAPSHOT/zip/profile
 

For more help see the Apache Camel documentation

    http://camel.apache.org/
     http://camel.apache.org/JBossFuse:karaf@root> profile-import mvn:com.beosbank.jbdevg.jbfuse/beosbank-vdb-wsproxy/1.0.0-SNAPSHOT/zip/profile
     
     
    
    
 Testing with Httpie
 if you container httPort is 8182
$ http	http://127.0.0.1:8182/vdbproxy/Transactions.MoneyTransfer
 
$ http  http://127.0.0.1:8182/vdbproxy/Transactions.MoneyTransfer?\$format=json
HTTP/1.1 200 OK
$format: json
Accept: */*
Accept-Encoding: gzip, deflate
Content-Type: application/json;charset=utf-8
DataServiceVersion: 2.0
Expires: Thu, 01 Jan 1970 01:00:00 CET
Server: Apache-Coyote/1.1
Transfer-Encoding: chunked
User-Agent: HTTPie/0.9.8
breadcrumbId: ID-MBP-de-elvadas-54529-1496408822089-8-6

{
    "d": {
        "results": [
            {
                "__metadata": {
                    "type": "Transactions.MoneyTransfer",
                    "uri": "http://localhost:8080/odata/beosbank.1/Transactions.MoneyTransfer('BEBR002')"
                },
                "amount_paid_with_taxes": null,
                "amount_sent_without_taxes": "100.00",
                "amount_to_receive": null,
                "code": "BEBR002",
                "country_from": "Brasil",
                "country_to": "Belgium",
                "fees": null,
                "receiver_name": "Adriana Pinto",
                "receiving_currency": "BRL",
                "receiving_date": null,
                "sender_name": "Yohan Pieter",
                "sending_currency": "EUR",
                "sending_date": "/Date(1494374400000)/",
                "status": "DRAFT",
                "vat": null
            },
    
