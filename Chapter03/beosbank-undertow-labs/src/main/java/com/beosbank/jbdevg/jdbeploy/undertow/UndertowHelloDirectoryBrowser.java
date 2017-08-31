package com.beosbank.jbdevg.jdbeploy.undertow;

import java.nio.file.Paths;

import io.undertow.Undertow;
import io.undertow.server.handlers.resource.PathResourceManager;


public class UndertowHelloDirectoryBrowser  {
 public static void main(String[]args){
Undertow server = Undertow.builder()
     .addHttpListener(7071, "localhost")
     .setHandler(io.undertow.Handlers.resource(
    		 new PathResourceManager(Paths.get("/Users/enonowog/books/jbdevg/code/jbdevg"),10))
                     .setDirectoryListingEnabled(true)
    		 ).build();
  server.start();
 };
}