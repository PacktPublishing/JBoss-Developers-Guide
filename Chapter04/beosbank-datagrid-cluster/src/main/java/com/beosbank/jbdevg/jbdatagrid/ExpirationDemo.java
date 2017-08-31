package com.beosbank.jbdevg.jbdatagrid;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.context.Flag;
import org.infinispan.manager.DefaultCacheManager;

import com.beosbank.jbdevg.jbdatagrid.domain.MoneyTransfert;
import com.beosbank.jbdevg.jbdatagrid.listener.DatagridListener;

public class ExpirationDemo {

	private static String[] inputFileNames = { "data1.xml", "data2.xml", "data3.xml", "data4.xml", "data5.xml" };


	public static void main(String[] args) throws IOException, InterruptedException {
		
	      //Configuration
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder
		   .expiration()
		   .maxIdle(3l, TimeUnit.SECONDS)
		   .lifespan(5l, TimeUnit.SECONDS);
		
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
			Thread.sleep(2000);
			cache.get(5l);
			System.out.println("Cache content after 2 sec");
			//Current node content
			printCacheContent(cache);
			
			Thread.sleep(1000);
			System.out.println("Cache content after 3 sec");
			printCacheContent(cache);
			
			Thread.sleep(3000);
			System.out.println("Cache content after 6 sec");
			printCacheContent(cache);
			
			// Stop the cache
			cache.stop();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private static void printCacheContent(Cache<Long, MoneyTransfert> cache) {
		cache.getAdvancedCache().withFlags(Flag.SKIP_REMOTE_LOOKUP)
		.entrySet().forEach(entry -> System.out.printf("%s = %s\n", entry.getKey(), entry.getValue().getDescription()));
	}


	
	
	
	

}
