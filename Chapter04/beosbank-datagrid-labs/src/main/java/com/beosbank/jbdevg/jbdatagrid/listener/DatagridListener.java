package com.beosbank.jbdevg.jbdatagrid.listener;

import org.infinispan.notifications.Listener;
import org.infinispan.notifications.cachelistener.annotation.*;
import org.infinispan.notifications.cachelistener.event.*;

@Listener
public  class DatagridListener {

   @CacheEntryCreated
   public void onCreated(CacheEntryCreatedEvent<String, String> event) {
	   if(!event.isPre())
         System.out.printf("Created %s\n", event.getKey());
   }

   @CacheEntryModified
   public void onModified(CacheEntryModifiedEvent<String, String> event) {
	   if(event.isPre())
         System.out.printf("About to modify %s\n", event.getKey());
   }
   
}