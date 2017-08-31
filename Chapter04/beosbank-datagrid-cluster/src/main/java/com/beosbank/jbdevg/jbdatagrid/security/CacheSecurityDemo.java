package com.beosbank.jbdevg.jbdatagrid.security;

import java.io.IOException;
import java.security.PrivilegedAction;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

import org.infinispan.Cache;
import org.infinispan.context.Flag;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.security.Security;
import org.picketbox.exceptions.PicketBoxProcessingException;
import org.picketbox.plugins.PicketBoxProcessor;

import com.beosbank.jbdevg.jbdatagrid.BeosBankCacheUtils;
import com.beosbank.jbdevg.jbdatagrid.domain.MoneyTransfert;
import com.beosbank.jbdevg.jbdatagrid.listener.DatagridListener;

public class CacheSecurityDemo {

	private static String[] inputFileNames = { "data1.xml", "data2.xml", "data3.xml", "data4.xml", "data5.xml" };

	public static void main(String[] args)
			throws IOException, InterruptedException, LoginException, PicketBoxProcessingException {

		BeosBankAuthenticationRealm auth = new BeosBankAuthenticationRealm();

		PicketBoxProcessor processor = new PicketBoxProcessor();
		processor.setSecurityInfo("moneytransfert_admin", "admin01#");
		processor.process(auth);
		Subject adminSubject = processor.getCallerSubject();

		Cache<Long, MoneyTransfert> cache = Security.doAs(adminSubject,
				new PrivilegedAction<Cache<Long, MoneyTransfert>>() {

					@Override
					public Cache<Long, MoneyTransfert> run() {
						// Initialize the cache manager
						DefaultCacheManager cacheManager;
						try {
							cacheManager = new DefaultCacheManager("config/beosbank-infinispan-secure.xml");
							Cache<Long, MoneyTransfert> cache = cacheManager.getCache("beosbank-dist");
							cache.addListener(new DatagridListener());
							BeosBankCacheUtils.loadEntries(cache, inputFileNames);
							System.out.println("Cache created by user=" + adminSubject + " Size=" + cache.size());
							return cache;
						} catch (IOException e) {
							e.printStackTrace();
						}
						return null;
					}
				});

		processor.setSecurityInfo("moneytransfert_reader", "jb0ss!");
		processor.process(auth);
		Subject readerSubject = processor.getCallerSubject();

		Security.doAs(readerSubject, new PrivilegedAction<String>() {
			@Override
			public String run() {
				// Inspect the cache
				System.out.println("Cache content cache displayed by user=" + readerSubject);
				// Current node content
				printCacheContent(cache);
				return null;
			}

		});

		// Stop the cache
		cache.stop();

	}

	private static void printCacheContent(Cache<Long, MoneyTransfert> cache) {
		cache.getAdvancedCache().withFlags(Flag.SKIP_REMOTE_LOOKUP).entrySet()
				.forEach(entry -> System.out.printf("%s = %s\n", entry.getKey(), entry.getValue().getDescription()));
	}

}
