package com.beosbank.jbdevg.jbfuse.cacheloader.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MoneyTransfer  implements Serializable{

	public  static final String FIELD_ID="ID";
	public  static final String FIELD_KEYCODE="KEYCODE";
	public  static final String FIELD_AMOUNT_HF_SENDER_CUR="AMOUNT_HF_SENDER_CUR";
	public  static final String FIELD_PAYMENT_METHOD="MOBILEMONEY";
	public  static final String FIELD_STATUS="STATUS";

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//ID=6, 
	private long id;
	
	//KEYCODE
	private String keycode;
	
	//AMOUNT_HF_SENDER_CUR=1500.00
	private BigDecimal amount_hf_sender_currency;
	
	//AMOUNT_HF_RECEIVER_CUR
	private BigDecimal amount_hf_receiver_currency;
	
	
	//AMOUNT_TFC
	private BigDecimal amountTtc;
	
	//MOBILEMONEY
	private String paymentMethod;
	
    //FEES
	private BigDecimal fees;
    				
    //RECEIVER_CURRENCY=ETB
	private String receiverCurrency;
	
	//SENDER_CURRENCY=ZAR
	private String senderCurrency;
	
	//SENDING_DATE=2017-04-16
	private Date sendingDate;
	
	//status=DRAFT
	private String status;
	
	//SENDER_ID=9,
	private long senderId;
	
	//RECEIVER_ID=10
	private long receiverId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKeycode() {
		return keycode;
	}

	public void setKeycode(String keycode) {
		this.keycode = keycode;
	}

	public BigDecimal getAmount_hf_sender_currency() {
		return amount_hf_sender_currency;
	}

	public void setAmount_hf_sender_currency(BigDecimal amount_hf_sender_currency) {
		this.amount_hf_sender_currency = amount_hf_sender_currency;
	}

	public BigDecimal getAmount_hf_receiver_currency() {
		return amount_hf_receiver_currency;
	}

	public void setAmount_hf_receiver_currency(BigDecimal amount_hf_receiver_currency) {
		this.amount_hf_receiver_currency = amount_hf_receiver_currency;
	}

	public BigDecimal getAmountTtc() {
		return amountTtc;
	}

	public void setAmountTtc(BigDecimal amountTtc) {
		this.amountTtc = amountTtc;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BigDecimal getFees() {
		return fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}

	public String getReceiverCurrency() {
		return receiverCurrency;
	}

	public void setReceiverCurrency(String receiverCurrency) {
		this.receiverCurrency = receiverCurrency;
	}

	public String getSenderCurrency() {
		return senderCurrency;
	}

	public void setSenderCurrency(String senderCurrency) {
		this.senderCurrency = senderCurrency;
	}

	public Date getSendingDate() {
		return sendingDate;
	}

	public void setSendingDate(Date sendingDate) {
		this.sendingDate = sendingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MoneyTransfer [id=" + id + ";" + keycode + ";"
				+ amount_hf_sender_currency + ";"+senderCurrency+";" + paymentMethod 
				+ ";" + sendingDate + ";" + status + "]";
	}

	
	

}
