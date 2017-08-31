package com.beosbank.jbdevg.jbossas.beans;

import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.beosbank.jbdevg.jbossas.dao.ifc.IMoneyTransfertEjb;
import com.beosbank.jbdevg.jbossas.domain.MoneyTransfert;

@Stateful
@Named("mtcStatefullEjb")
public class MoneyTransferClusteredStatefullBean implements IMoneyTransfertEjb {

	
	@PersistenceContext(unitName = "beosbank-mt-unit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

	
	public long addMoneyTransfer(MoneyTransfert mt) {
		
		entityManager.persist(mt);
		return mt.getId();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
