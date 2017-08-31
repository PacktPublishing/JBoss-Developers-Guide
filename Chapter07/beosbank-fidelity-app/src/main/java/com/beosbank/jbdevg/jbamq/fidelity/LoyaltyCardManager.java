package com.beosbank.jbdevg.jbamq.fidelity;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.qpid.jms.JmsConnectionFactory;
public class LoyaltyCardManager {

   private static final String ROUTER_URL="amqp://192.168.56.102:5672";
   private static final String QUEUE_NAME="FIDELITY.REQUEST";
   private static final String CSVDATA="CSVDATA";

   public static void main(String[] args) throws Exception {
      Connection connection = null;
      String csvData = System.getProperty(CSVDATA);
      if(CSVDATA == null || CSVDATA.equals(""))
          throw new RuntimeException("LoyaltyCardManager.main() must pass the "+CSVDATA +" system property With format  OPERATION;USERID;FIRSTNAME;LASTNAME;TRXID;TRXFEESAMOUNT;CURRENCY");
      System.out.println("LoyaltyCardManager() will connect to router: "+ROUTER_URL+" : at the following address: "+QUEUE_NAME);
      ConnectionFactory connectionFactory = new JmsConnectionFactory(ROUTER_URL);
      try {
         // Step 1. Create an AMQP qpid connection
         connection = connectionFactory.createConnection();
         // Step 2. Create a JMS session
         Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
         // Step 3. Create a Producer
         Queue fidelityRequestQueue = session.createQueue(QUEUE_NAME);
         MessageProducer beosbankFidelityRequestProducer = session.createProducer(fidelityRequestQueue);
         // Step 4. send a CSV Text Data on user transactions 
         beosbankFidelityRequestProducer.send(session.createTextMessage(csvData));
         System.out.println("\nmessage sent:"+ csvData+" \n");
      } finally {
         if (connection != null) {
            // Step 9. close the connection
            connection.close();
         }
      }
   }
}
