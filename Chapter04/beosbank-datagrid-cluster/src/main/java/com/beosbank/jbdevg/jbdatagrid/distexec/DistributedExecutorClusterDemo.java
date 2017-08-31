package com.beosbank.jbdevg.jbdatagrid.distexec;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.infinispan.Cache;
import org.infinispan.distexec.DefaultExecutorService;
import org.infinispan.distexec.DistributedExecutorService;
import org.infinispan.distexec.DistributedTask;
import org.infinispan.distexec.DistributedTaskBuilder;
import org.infinispan.manager.DefaultCacheManager;

import com.beosbank.jbdevg.jbdatagrid.BeosBankCacheUtils;
import com.beosbank.jbdevg.jbdatagrid.domain.MoneyTransfert;
import com.beosbank.jbdevg.jbdatagrid.listener.DatagridListener;


public class DistributedExecutorClusterDemo {

	private static String[] inputFileNames = { "data1.xml", "data2.xml", "data3.xml", "data4.xml", "data5.xml" };


	public static void main(String[] args) {
		
		
		DefaultCacheManager cacheManager = new DefaultCacheManager();
		Cache<Long, MoneyTransfert> cache = cacheManager.getCache("beosbank-dist");
		cache.addListener(new DatagridListener());
		
		try {
			BeosBankCacheUtils.loadEntries( cache, inputFileNames);
			
			
			//cache inspection
			System.out.println("Cache inspection to check status before task");
			System.out.println(cache.get(1l).getDescription());
			System.out.println(cache.get(2l).getDescription());
			
			
			DistributedExecutorService des = new DefaultExecutorService((Cache<?, ?>) cache);
			DistributedTaskBuilder<List<MoneyTransfert>> taskBuilder = des.createDistributedTaskBuilder(new StatusUpdateDistributedCallable());
			taskBuilder.timeout(5,TimeUnit.SECONDS);
			
			DistributedTask<List<MoneyTransfert>> distributedTask = taskBuilder.build();
			 List<CompletableFuture<List<MoneyTransfert>>> futures = des.submitEverywhere(distributedTask,1l,2l);
			 List<MoneyTransfert> paidMts = futures.get(0).get();
		
			
			//cache inspection
			System.out.println("Cache inspection to check Task status updates");
			System.out.println(cache.get(1l).getDescription());
			System.out.println(cache.get(2l).getDescription());


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
