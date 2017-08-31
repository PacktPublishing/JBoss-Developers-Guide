package com.beosbank.jbdevg.jbdatagrid.distexec;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.infinispan.Cache;
import org.infinispan.distexec.DistributedCallable;

import com.beosbank.jbdevg.jbdatagrid.domain.MoneyTransferStatus;
import com.beosbank.jbdevg.jbdatagrid.domain.MoneyTransfert;
import com.google.common.collect.Lists;

public class StatusUpdateDistributedCallable implements DistributedCallable<Long,MoneyTransfert,List<MoneyTransfert>>, Serializable {

	private static final long serialVersionUID = 1L;
	Cache<Long, MoneyTransfert> cache;
	Set<Long> inputKeys;
	
	@Override
	public List<MoneyTransfert> call() throws Exception {
		
		List<MoneyTransfert> mts = Lists.newArrayList();
		
		for (Long key : inputKeys) {
			MoneyTransfert mt = cache.get(key);
			 if(mt!=null &&  MoneyTransferStatus.DRAFT.equals(mt.getStatus())){
				 mt.setStatus(MoneyTransferStatus.PAID);
				 mts.add(mt);
			 }
		}
		
		return mts;
	}

	@Override
	public void setEnvironment(Cache<Long, MoneyTransfert> cache, Set<Long> inputKeys) {
		this.cache=cache;
		this.inputKeys=inputKeys;
		System.out.println("StatusUpdateDistributedCallable.setEnvironment()");
		
	}

	

}
