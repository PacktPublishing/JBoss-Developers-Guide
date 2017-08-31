package com.beosbank.jbdevg.jdbeploy.undertow;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
public class UndertowHelloWorldServer  {
 public static void main(String[]args){
Undertow server = Undertow.builder()
     .addHttpListener(7070, "localhost")
     .setHandler(new HttpHandler() 
{
      public void handleRequest(HttpServerExchange exchange) throws Exception {
   exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
   exchange.getResponseSender().send("Beos Bank !");
      }
     }).build();
  server.start();
 };
}