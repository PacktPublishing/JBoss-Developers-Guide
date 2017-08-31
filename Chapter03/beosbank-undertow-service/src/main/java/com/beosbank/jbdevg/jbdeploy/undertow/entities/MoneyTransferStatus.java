package com.beosbank.jbdevg.jbdeploy.undertow.entities;

public enum MoneyTransferStatus {
	
	DRAFT,      //the money transfer is created in the system but not yet finalized
	PAID,  	   //the money transfer is created and user paid the total amount required, not yet available for withdraw 
	PENDING,   //the money transfer is available for withdraw
	WITHDRAWN, //the received took his money
	CANCELED,  //the money transfer was canceled

}
