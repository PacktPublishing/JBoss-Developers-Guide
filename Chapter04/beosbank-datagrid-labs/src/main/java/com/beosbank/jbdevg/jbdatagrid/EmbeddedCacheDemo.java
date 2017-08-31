package com.beosbank.jbdevg.jbdatagrid;

import java.io.File;
import java.io.IOException;

import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;

import com.beosbank.jbdevg.jbdatagrid.domain.MoneyTransfert;
import com.mchange.io.FileUtils;

public class EmbeddedCacheDemo {

	private static final String INPUT_DIR = "src/main/resources/input/";

	public static void main(String[] args) {

		String[] inputFileNames = { "data1.xml", "data2.xml", "data3.xml", "data4.xml", "data5.xml" };
		// Create a Money Transfer Object from XML Message using BeaoIO API
		try {
			StreamFactory factory = StreamFactory.newInstance();
			factory.loadResource("mapping.xml");
			Unmarshaller unmarshaller = factory.createUnmarshaller("MoneyTransferStream");

			String record;
			ConfigurationBuilder builder = new ConfigurationBuilder();
			Cache<String, Object> cache = new DefaultCacheManager(builder.build()).getCache();
			
			//Read Transactions and put in cache
			for (String inputFile : inputFileNames) {
				record = FileUtils.getContentsAsString(new File(INPUT_DIR + inputFile));
				MoneyTransfert mt = (MoneyTransfert) unmarshaller.unmarshal(record);
				cache.put(mt.getId() + "", mt);
			}

			//Inspect the cache .
			System.out.println(cache.size());
			System.out.println(cache.getStatus());
			System.out.println(cache.get("3"));

			//Stop the cache
			cache.stop();
			System.out.println(cache.getStatus());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
