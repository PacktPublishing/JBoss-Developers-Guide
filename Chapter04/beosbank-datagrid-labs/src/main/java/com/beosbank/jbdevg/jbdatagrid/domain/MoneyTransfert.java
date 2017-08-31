package com.beosbank.jbdevg.jbdatagrid.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MoneyTransfert implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private Customer sender;
	
	private Customer receiver;

	private MoneyTransferStatus status;
	
	private Date sendingDate;
	
	private Date withdrawalDate;
	
	private String creditCardNumber;
	
	//Key password sender will communicate to the receiver
	private String keyCode;
	

	//amount excluding fees in sender currency
	private BigDecimal amountExcludingFees;
	
	//  fees in sender currency
	private BigDecimal fees;
	
	//  amount including fees in sender currency
	private BigDecimal amountIncludingFees;
	
	//vat is applied on fees
	private BigDecimal vatRate;
	
	//total amount excluding vat in sender currency
	private BigDecimal totalAmountExcludingVat;
	
	//total amount including vat in sender currency, total amount the sender will pay to complete the transfer
	private BigDecimal totalAmountIncludingVat;
	
	private String senderCurrencyCode="USD";
	
	private String receiverCurrencyCode;
	
	//total amount the receive will have in his pocket
	private BigDecimal amountExcludingFeesInReceiverCurrency;

	
	
	public MoneyTransfert(){
		
	}
	
	
	
	public String getSenderCurrencyCode() {
		return senderCurrencyCode;
	}
	public void setSenderCurrencyCode(String senderCurrencyCode) {
		this.senderCurrencyCode = senderCurrencyCode;
	}
	public String getReceiverCurrencyCode() {
		return receiverCurrencyCode;
	}
	public void setReceiverCurrencyCode(String receiverCurrencyCode) {
		this.receiverCurrencyCode = receiverCurrencyCode;
	}
	public BigDecimal getAmountExcludingFeesInReceiverCurrency() {
		return amountExcludingFeesInReceiverCurrency;
	}
	public void setAmountExcludingFeesInReceiverCurrency(BigDecimal amountExcludingFeesInReceiverCurrency) {
		this.amountExcludingFeesInReceiverCurrency = amountExcludingFeesInReceiverCurrency;
	}
	
	public Customer getSender() {
		return sender;
	}
	public void setSender(Customer sender) {
		this.sender = sender;
	}
	public Customer getReceiver() {
		return receiver;
	}
	public void setReceiver(Customer receiver) {
		this.receiver = receiver;
	}
	public Date getSendingDate() {
		return sendingDate;
	}
	public void setSendingDate(Date sendingDate) {
		this.sendingDate = sendingDate;
	}
	public Date getWithdrawalDate() {
		return withdrawalDate;
	}
	public void setWithdrawalDate(Date withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}
	
	public BigDecimal getAmountExcludingFees() {
		return amountExcludingFees;
	}
	public void setAmountExcludingFees(BigDecimal amountExcludingFees) {
		this.amountExcludingFees = amountExcludingFees;
	}
	public BigDecimal getAmountIncludingFees() {
		return amountIncludingFees;
	}
	public void setAmountIncludingFees(BigDecimal amountIncludingFees) {
		this.amountIncludingFees = amountIncludingFees;
	}
	public BigDecimal getFees() {
		return fees;
	}
	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}
	public BigDecimal getVatRate() {
		return vatRate;
	}
	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}
	public BigDecimal getTotalAmountExcludingVat() {
		return totalAmountExcludingVat;
	}
	public void setTotalAmountExcludingVat(BigDecimal totalAmountExcludingVat) {
		this.totalAmountExcludingVat = totalAmountExcludingVat;
	}
	public BigDecimal getTotalAmountIncludingVat() {
		return totalAmountIncludingVat;
	}
	public void setTotalAmountIncludingVat(BigDecimal totalAmountIncludingVat) {
		this.totalAmountIncludingVat = totalAmountIncludingVat;
	}
	public MoneyTransferStatus getStatus() {
		return status;
	}
	public void setStatus(MoneyTransferStatus status) {
		this.status = status;
	}



	public String getCreditCardNumber() {
		return creditCardNumber;
	}



	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}

	
	public String getKeyCode() {
		return keyCode;
	}



	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}



	@Override
	public String toString() {
		return "MoneyTransfert [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", status=" + status
				+ ", sendingDate=" + sendingDate + ", withdrawalDate=" + withdrawalDate + ", creditCardNumber="
				+ creditCardNumber + ", keyCode=" + keyCode + ", amountExcludingFees=" + amountExcludingFees + ", fees="
				+ fees + ", amountIncludingFees=" + amountIncludingFees + ", vatRate=" + vatRate
				+ ", totalAmountExcludingVat=" + totalAmountExcludingVat + ", totalAmountIncludingVat="
				+ totalAmountIncludingVat + ", senderCurrencyCode=" + senderCurrencyCode + ", receiverCurrencyCode="
				+ receiverCurrencyCode + ", amountExcludingFeesInReceiverCurrency="
				+ amountExcludingFeesInReceiverCurrency + "]";
	}

	






	
}
