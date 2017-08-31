package com.beosbank.jbdevg.jbdatagrid;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.infinispan.Cache;
import org.infinispan.context.Flag;
import org.infinispan.manager.DefaultCacheManager;

import com.beosbank.jbdevg.jbdatagrid.domain.MoneyTransfert;
import com.beosbank.jbdevg.jbdatagrid.listener.DatagridListener;
import com.mchange.io.FileUtils;

public class DistributedCacheStreamDemo {

	private static final String INPUT_DIR = "src/main/resources/input/";
	private static String[] inputFileNames = { "data1.xml", "data2.xml", "data3.xml", "data4.xml", "data5.xml" };


	public static void main(String[] args) throws IOException {
		/*
		GlobalConfigurationBuilder global = GlobalConfigurationBuilder.defaultClusteredBuilder();
	      ConfigurationBuilder builder = new ConfigurationBuilder();
	      builder.clustering().cacheMode(CacheMode.DIST_SYNC);
	      global.clusteredDefault();*/
	      
	      // Initialize the cache manager
	      DefaultCacheManager cacheManager = new DefaultCacheManager();
	      // Obtain the default cache
	      Cache<Long, MoneyTransfert> cache = cacheManager.getCache("beosbank-dist");
	      
	      
		// Obtain the remote cache
		cache.addListener(new DatagridListener());
		// Create a Money Transfer Object from XML Message using BeaoIO API
		try {
			StreamFactory factory = StreamFactory.newInstance();
			factory.loadResource("mapping.xml");
			Unmarshaller unmarshaller = factory.createUnmarshaller("MoneyTransferStream");

			String record;

			// Read Transactions and put in cache
			for (String inputFile : inputFileNames) {
				record = FileUtils.getContentsAsString(new File(INPUT_DIR + inputFile));
				MoneyTransfert mt = (MoneyTransfert) unmarshaller.unmarshal(record);
				
				/*MoneyTransfertKey key = new  MoneyTransfertKey();
				key.setId(mt.getId());
				key.setCountryTo(mt.getReceiver().getAddress().getCountry());*/
				
				cache.put(mt.getId(), mt);
			}

			// Inspect the cache .
			System.out.println(cache.size());
			
			System.out.println(cache.get(3l));
			
			//Current node content
			cache.getAdvancedCache().withFlags(Flag.SKIP_REMOTE_LOOKUP)
	         .entrySet().forEach(entry -> System.out.printf("%s = %s\n", entry.getKey(), entry.getValue().getDescription()));
			
			
			
			
			//get all transactions from US to Cameroon
			double result = cache.entrySet().stream().filter(
					mt-> 
					"USA".equalsIgnoreCase(mt.getValue().getSender().getAddress().getCountry())  &&
					"Cameroon".equalsIgnoreCase(mt.getValue().getReceiver().getAddress().getCountry())
					
					).collect
					(Collectors.summarizingDouble(e->e.getValue().getAmountExcludingFees().doubleValue()))
					.getSum();
			
			System.out.println("TRX from US to Cameroon USD "+result);

			
			// Stop the cache
			//cache.stop();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	

}
