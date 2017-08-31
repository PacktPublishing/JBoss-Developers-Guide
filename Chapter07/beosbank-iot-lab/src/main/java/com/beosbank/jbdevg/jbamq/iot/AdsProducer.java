package com.beosbank.jbdevg.jbamq.iot;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;
public class AdsProducer {

   private static final String BROKER_URL="tcp://127.0.0.2:1883";
   private static final String FIDELITY_ADS_TOPIC="FIDELITY.ADS";

   public static void main(String[] args) throws Exception {
	   	  System.out.println("Connecting to Broker1 using MQTT");
	      MQTT mqtt = new MQTT();
	      mqtt.setHost(BROKER_URL);
	      BlockingConnection connection = mqtt.blockingConnection();
	      connection.connect();
	      System.out.println("Connected to Broker1");
	      // Subscribe to  fidelityAds topic
	      Topic[] topics = { new Topic(FIDELITY_ADS_TOPIC, QoS.AT_LEAST_ONCE)};
	      connection.subscribe(topics);
	      // Publish Ads
	      String ads1 = "Discount on transfert fees up to -50% with coupon code JBOSSDOCTOR.  www.beosbank.com";
	      long index=0;
	      while(true){
	    	  connection.publish(FIDELITY_ADS_TOPIC, (index+":"+ads1).getBytes(), QoS.AT_LEAST_ONCE, false);
			  System.out.println("Sent messages with index="+index);
		      Thread.sleep(10000);
		      index++;
	      }
}
   
}

