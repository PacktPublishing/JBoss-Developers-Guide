package com.beosbank.jbdevg.jbdatagrid.listener;

import org.infinispan.client.hotrod.annotation.ClientCacheEntryRemoved;
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
   
   @CacheEntryExpired
   public void onExpired(CacheEntryExpiredEvent<String, String> event) {
         System.out.printf("Entry Expired %s\n", event.getKey());
   }
   
   @ClientCacheEntryRemoved
   public void onRemove(CacheEntryRemovedEvent<String, String> event) {
         System.out.printf("Entry Removed %s\n", event.getKey());
   }
   
}