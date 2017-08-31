package com.beosbank.jbdevg.jbamq.iot;

import java.util.concurrent.TimeUnit;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.Message;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;
public class BeosBankIotDevice {

   private static final String BROKER_URL="tcp://127.0.0.2:1883";
   private static final String FIDELITY_ADS_TOPIC="FIDELITY.ADS";

   public static void main(String[] args) throws Exception {
	   System.out.println("Connecting to Broker1 using MQTT");
	      MQTT mqtt = new MQTT();
	      mqtt.setHost(BROKER_URL);
	      BlockingConnection connection = mqtt.blockingConnection();
	      connection.connect();
	      System.out.println("Connected to Artemis");

	      // Subscribe to  fidelityAds topic
	      Topic[] topics = {new Topic(FIDELITY_ADS_TOPIC, QoS.AT_LEAST_ONCE)};
	      connection.subscribe(topics);

	      // Get Ads Messages

	      while(true){
	    	  Message message = connection.receive(5, TimeUnit.SECONDS);
	    	  if(message!=null){
	    		  System.out.println("Received messages. "+new String(message.getPayload()));
	    	  }
		      
	      }
	    
	      
	      
	      
}
   
}

