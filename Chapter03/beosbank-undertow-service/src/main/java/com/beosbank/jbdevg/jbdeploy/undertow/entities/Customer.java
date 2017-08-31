package com.beosbank.jbdevg.jbdeploy.undertow.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="T_CUSTOMER")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTHDATE")
	private Date birthDate;
	
	@Embedded
	private  Address address;
	
	
	@OneToMany(mappedBy="sender")
	private List<MoneyTransfert> sentTransferts;
	
	
	@OneToMany(mappedBy="receiver")
	private List<MoneyTransfert> receivedTransferts;
	
	public Customer(){
		address= new Address();
	}
	
	
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", address=" + address + "]";
	}


	@XmlTransient
	public List<MoneyTransfert> getSentTransferts() {
		return sentTransferts;
	}


	@XmlTransient
	public List<MoneyTransfert> getReceivedTransferts() {
		return receivedTransferts;
	}



	public void setSentTransferts(List<MoneyTransfert> sentTransferts) {
		this.sentTransferts = sentTransferts;
	}



	public void setReceivedTransferts(List<MoneyTransfert> receivedTransferts) {
		this.receivedTransferts = receivedTransferts;
	}


}
