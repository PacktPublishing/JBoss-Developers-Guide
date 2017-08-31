package com.beosbank.jbdevg.jbossas.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MONEYTRANSFER")
public class MoneyTransfert implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="SENDER_ID")
	private Customer sender;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="RECEIVER_ID")
	private Customer receiver;

	@Enumerated(EnumType.STRING)
	private MoneyTransferStatus status= MoneyTransferStatus.DRAFT;
	
	@Temporal(TemporalType.DATE)
	@Column(name="SENDING_DATE")
	private Date sendingDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="WITHDRAWAL_GDATE")
	private Date withdrawalDate;
	
	@Column(name="CREDITCARD")
	private String creditCardNumber;
	
	//Key password sender will communicate to the receiver
	@Column(name="KEYCODE")
	private String keyCode;
	

	//amount excluding fees in sender currency
	@Column(name="AMOUNT_HF_SENDER_CUR")
	private BigDecimal amountExcludingFees;
	
	//  fees in sender currency
	@Column(name="FEES")
	private BigDecimal fees;
	
	//  amount including fees in sender currency
	@Column(name="AMOUNT_TFC")
	private BigDecimal amountIncludingFees;
	
	//vat is applied on fees
	@Column(name="VAT")
	private BigDecimal vatRate;
	
	//total amount excluding vat in sender currency
	@Column(name="TOTAL_HT")
	private BigDecimal totalAmountExcludingVat;
	
	//total amount including vat in sender currency, total amount the sender will pay to complete the transfer
	@Column(name="TOTAL_TTC")
	private BigDecimal totalAmountIncludingVat;
	
	@Column(name="SENDER_CURRENCY")
	private String senderCurrencyCode="USD";
	
	@Column(name="RECEIVER_CURRENCY")
	private String receiverCurrencyCode;
	
	//total amount the receive will have in his pocket
	@Column(name="AMOUNT_HF_RECEIVER_CUR")
	private BigDecimal amountExcludingFeesInReceiverCurrency;

	
	
	public MoneyTransfert(){
		sender=new Customer();
		receiver = new Customer();
		
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
		return "MoneyTransfertBean [sender=" + sender + ", receiver=" + receiver + ", status=" + status
				+ ", sendingDate=" + sendingDate + ", withdrawalDate=" + withdrawalDate + ", creditCardNumber="
				+ creditCardNumber + ", amountExcludingFees=" + amountExcludingFees + ", fees=" + fees
				+ ", amountIncludingFees=" + amountIncludingFees + ", vatRate=" + vatRate + ", totalAmountExcludingVat="
				+ totalAmountExcludingVat + ", totalAmountIncludingVat=" + totalAmountIncludingVat
				+ ", senderCurrencyCode=" + senderCurrencyCode + ", receiverCurrencyCode=" + receiverCurrencyCode
				+ ", amountExcludingFeesInReceiverCurrency=" + amountExcludingFeesInReceiverCurrency + "]";
	}






	
}
