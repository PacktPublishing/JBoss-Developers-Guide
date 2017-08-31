package com.beosbank.jbdevg.jbdatagrid;

import java.io.File;
import java.io.IOException;

import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.infinispan.Cache;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.commons.api.BasicCache;

import com.beosbank.jbdevg.jbdatagrid.domain.MoneyTransfert;
import com.mchange.io.FileUtils;

public class BeosBankCacheUtils {
	private static final String INPUT_DIR = "src/main/resources/input/";

	public static void loadEntries(BasicCache<Long, MoneyTransfert> cache,String[] inputFileNames) throws IOException {
		StreamFactory factory = StreamFactory.newInstance();
		factory.loadResource("mapping.xml");
		Unmarshaller unmarshaller = factory.createUnmarshaller("MoneyTransferStream");

		String record;

		// Read Transactions and put in cache
		for (String inputFile : inputFileNames) {
			record = FileUtils.getContentsAsString(new File(INPUT_DIR + inputFile));
			MoneyTransfert mt = (MoneyTransfert) unmarshaller.unmarshal(record);
			
			cache.put(mt.getId(), mt);
		}
	}
	
	
	/*
	public static void loadEntries(RemoteCache<Long, MoneyTransfert> cache,String[] inputFileNames) throws IOException {
		StreamFactory factory = StreamFactory.newInstance();
		factory.loadResource("mapping.xml");
		Unmarshaller unmarshaller = factory.createUnmarshaller("MoneyTransferStream");
		String record;
		// Read Transactions and put in cache
		for (String inputFile : inputFileNames) {
			record = FileUtils.getContentsAsString(new File(INPUT_DIR + inputFile));
			MoneyTransfert mt = (MoneyTransfert) unmarshaller.unmarshal(record);
			
			cache.put(mt.getId(), mt);
		}
	}*/
}
