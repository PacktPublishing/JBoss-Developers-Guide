package com.beosbank.jbdevg.jbdeploy.undertow.server;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
public class MoneyTransferServer  {
 public static void main(String[]args){
	 
	 //Get Port
	 String host="0.0.0.0";
	 int port = Integer.parseInt(System.getProperty("port"));
	 //Create the JAXRS Server
	  UndertowJaxrsServer server = new UndertowJaxrsServer();
      Undertow.Builder serverBuilder = Undertow.builder().addHttpListener(port, host);
      server.start(serverBuilder);
      
      //Create the deployment
      ResteasyDeployment deployment = new ResteasyDeployment();
      deployment.setApplicationClass(MoneyTransfertApp.class.getName());
      deployment.setInjectorFactoryClass(org.jboss.resteasy.cdi.CdiInjectorFactory.class.getName());
      
      
      //Configure the deployment info
      DeploymentInfo di = server.undertowDeployment(deployment, "/api");
       di.setClassLoader(MoneyTransferServer.class.getClassLoader())
      .setContextPath("/beosbank-undertow-service")
      .setDeploymentName("BeosBank Services");
       
       //Add CDI listener
       di.addListeners(Servlets.listener(org.jboss.weld.environment.servlet.Listener.class));
       
       //Deploy the API 
       server.deploy(di);
  	  System.out.println("Undertow MoneyTransfert started on "+host+":"+port);

 };
}