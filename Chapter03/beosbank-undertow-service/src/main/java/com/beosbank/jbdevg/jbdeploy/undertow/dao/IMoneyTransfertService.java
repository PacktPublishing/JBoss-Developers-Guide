package com.beosbank.jbdevg.jbdeploy.undertow.dao;

import com.beosbank.jbdevg.jbdeploy.undertow.entities.MoneyTransfert;

public interface IMoneyTransfertService {

	/*
	 * Find Money Transfer Transaction by ID
	 */
	public MoneyTransfert getMoneyTransfertById(Long reference);
}
