package com.beosbank.jbdevg.jbdatagrid.listener;

import org.infinispan.client.hotrod.annotation.*;
import org.infinispan.client.hotrod.event.*;

@ClientListener()
public  class DatagridClientListener {

   @ClientCacheEntryCreated
   public void onCreated(ClientCacheEntryCreatedEvent<String> event) {
         System.out.printf("Remote# entity created  %s\n", event.getKey());
   }

   @ClientCacheEntryModified
   public void onModified(ClientCacheEntryModifiedEvent<String> event) {
         System.out.printf("Remote# entity updated %s\n", event.getKey());
   }
   
}