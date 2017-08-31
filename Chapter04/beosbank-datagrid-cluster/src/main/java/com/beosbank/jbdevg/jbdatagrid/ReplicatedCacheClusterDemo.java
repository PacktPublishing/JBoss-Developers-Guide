package com.beosbank.jbdevg.jbdatagrid;

import java.io.File;
import java.io.IOException;

import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

import com.beosbank.jbdevg.jbdatagrid.domain.MoneyTransfert;
import com.beosbank.jbdevg.jbdatagrid.listener.DatagridClientListener;
import com.mchange.io.FileUtils;

public class ReplicatedCacheClusterDemo {

	private static final String INPUT_DIR = "src/main/resources/input/";
	private static String[] inputFileNames = { "data1.xml", "data2.xml", "data3.xml", "data4.xml", "data5.xml" };


	public static void main(String[] args) {
		// Create a configuration for a locally-running server
		ConfigurationBuilder builder = new ConfigurationBuilder();
	
		
		int BeosBankCacheAfricaPort = 11322;
		builder.addServer().host("127.0.0.1").port(BeosBankCacheAfricaPort);
		// Connect to the server
		RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build());
		// Obtain the remote cache
		RemoteCache<String, Object> cache = cacheManager.getCache("beosbank-repl");
		cache.addClientListener(new DatagridClientListener());
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
				cache.put(mt.getId() + "", mt);
			}

			// Inspect the cache .
			System.out.println(cache.size());
			System.out.println(cache.get("3"));

			// Stop the cache
			cache.stop();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
