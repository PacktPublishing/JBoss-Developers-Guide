package com.beosbank.jbdevg.jbdatagrid;

import java.io.IOException;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.context.Flag;
import org.infinispan.eviction.EvictionStrategy;
import org.infinispan.eviction.EvictionType;
import org.infinispan.manager.DefaultCacheManager;

import com.beosbank.jbdevg.jbdatagrid.domain.MoneyTransfert;
import com.beosbank.jbdevg.jbdatagrid.listener.DatagridListener;

public class EvictionDemo {

	private static String[] inputFileNames = { "data1.xml", "data2.xml", "data3.xml", "data4.xml", "data5.xml" };


	public static void main(String[] args) throws IOException, InterruptedException {
		
	      //Configuration
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder
			.eviction()
			.strategy(EvictionStrategy.LRU)
			.type(EvictionType.COUNT)
			.size(3)
			;
	      // Initialize the cache manager
		DefaultCacheManager cacheManager = new DefaultCacheManager(builder.build());
	    // Obtain the default cache
	    Cache<Long, MoneyTransfert> cache = cacheManager.getCache("beosbank-dist");
	      
		// Obtain the remote cache
		cache.addListener(new DatagridListener());
		// Create a Money Transfer Object from XML Message using BeaoIO API
		try {
			BeosBankCacheUtils.loadEntries(cache,inputFileNames);

			// Inspect the cache .
			System.out.println(cache.size());
			System.out.println(cache.get(3l));
			
			//Current node content
			cache.getAdvancedCache().withFlags(Flag.SKIP_REMOTE_LOOKUP)
	        .entrySet().forEach(entry -> System.out.printf("%s = %s\n", entry.getKey(), entry.getValue().getDescription()));
			
			// Stop the cache
			cache.stop();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	
	
	
	

}
