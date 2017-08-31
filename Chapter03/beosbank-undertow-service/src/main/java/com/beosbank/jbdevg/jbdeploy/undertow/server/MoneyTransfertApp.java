package com.beosbank.jbdevg.jbdeploy.undertow.server;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.beosbank.jbdevg.jbdeploy.undertow.rest.MoneyTransferResource;

public class MoneyTransfertApp extends Application {

	
	
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new LinkedHashSet<Class<?>>();
        //add the the money Transfer resource to the application
        resources.add(MoneyTransferResource.class);
        return resources;
    }


}
