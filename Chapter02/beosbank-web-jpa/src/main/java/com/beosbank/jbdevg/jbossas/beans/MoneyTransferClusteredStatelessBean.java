package com.beosbank.jbdevg.jbossas.beans;

import javax.ejb.Stateless;
import javax.inject.Named;
import org.jboss.ejb3.annotation.Clustered;

@Clustered
@Stateless
@Named("mtcStatelessEjb")
public class MoneyTransferClusteredStatelessBean {

	public String getJbossInstanceName(){
		String nodeName= System.getProperty("jboss.node.name");
		return nodeName;
	}
}
