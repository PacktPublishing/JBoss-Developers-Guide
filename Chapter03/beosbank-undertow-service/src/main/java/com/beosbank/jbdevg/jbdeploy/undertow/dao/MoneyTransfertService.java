package com.beosbank.jbdevg.jbdeploy.undertow.dao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.beosbank.jbdevg.jbdeploy.undertow.entities.MoneyTransfert;


@SessionScoped
public class MoneyTransfertService implements IMoneyTransfertService,Serializable {
	private static final long serialVersionUID = 1L;
	static  EntityManagerFactory emf= null;
    EntityManager em;
    
	
	public MoneyTransfert getMoneyTransfertById(Long reference) {
		return  em.find(MoneyTransfert.class, reference);
	}
	
	@PostConstruct
	public void init(){
		System.out.println("MoneyTransfertService.init()");
		if(emf== null || !emf.isOpen()){
			emf=Persistence.createEntityManagerFactory("beosbank-mt-unit");
		}
		em=emf.createEntityManager();
	}
	

	@PreDestroy
	public void destroy(){
		System.out.println("MoneyTransfertService.close()");
		emf.close();
	}
	
}
