package com.beosbank.jbdevg.jbossas.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.FlowEvent;

import com.beosbank.jbdevg.jbossas.dao.ifc.IMoneyTransfertEjb;
import com.beosbank.jbdevg.jbossas.domain.MoneyTransfert;

@RequestScoped
@ManagedBean(name="mtvcBean")
public class MoneyTransferViewController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(MoneyTransferViewController.class);
	private Map<String,String> countries;
	private Map<String,String> currencies;
	
	private MoneyTransfert transfert;
	
	//JPA- Inject the DAO EJB service
	@EJB
	IMoneyTransfertEjb mtDaoService;
	  
	@PostConstruct
    public void init() {
        //Initialize countries and currencies list
		initCountries();
        initCountriesCurrencies();
        
        //Load Money Transfer data from session if any
        getMoneyTransfertDataFromSessionOrCreateNew();
        
	}

	
	
	public void onSenderCountryChanged(){
		String senderCountry=transfert.getSender().getAddress().getCountry();
		String currency= currencies.get(senderCountry);
		if(currency!=null){
			transfert.setSenderCurrencyCode(currency);
		}
		System.out.println("MoneyTransferViewController.onReceipientCountryChanged()" +senderCountry);
		getSession().setAttribute("transfert", transfert);
		
	}
	
	
	public void onReceipientCountryChanged(){
		String destinationCountry=transfert.getReceiver().getAddress().getCountry();
		String currency= currencies.get(destinationCountry);
		if(currency!=null){
			transfert.setReceiverCurrencyCode(currency);
		}
		System.out.println("MoneyTransferViewController.onReceipientCountryChanged()" +destinationCountry);
		getSession().setAttribute("transfert", transfert);
		
	}
	
	
	
	private HttpSession getSession(){
		HttpServletRequest request= ( HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return request.getSession();
	}
	
	
	
	public String onFlowProcess(FlowEvent event) {
			System.out.println("MoneyTransferViewController.onFlowProcess() "+transfert);
            return event.getNewStep();
    }
	
	
	
	/**
	 * Method Called when the user send a money transfer.
	 */
	public void sendMoney(){
		System.out.println(".sendMoney() ") ;
		//--JPA lab
		transfert.setSendingDate(new Date());
		long ref=mtDaoService.addMoneyTransfer(transfert);
		System.out.println("Transfert inserted with reference = "+ref);
		logger.trace("Log4j is working and return"+ref);
		//Handle result
		if(ref>0){  //SUCCESS
			
			//clear the transaction object so user can send a new one
			BigDecimal sentAmount = transfert.getAmountExcludingFees();
			MoneyTransfert newRequest= new MoneyTransfert();
			
			//Remove the transaction from session
			setTransfert(newRequest);
			
			//Build return message.
			//display a message to user to confirm transaction
			FacesContext context = FacesContext.getCurrentInstance();
	         
			context.addMessage(null, new FacesMessage("Successful",  "MoneyTransfert Request Completed with Reference: #" + ref +" Amount="+sentAmount +" "+transfert.getSenderCurrencyCode()) );
			
		}
		else{
			
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Error",  "Error while sending your money transfert") );
			
			//display an error message to user if any error 

		}
		
		
		
		
		
		
		
	}
	
	public MoneyTransfert getMoneyTransfertDataFromSessionOrCreateNew() {
		    HttpSession session = getSession();
		    transfert = (MoneyTransfert)session.getAttribute("transfert");
		    if(transfert==null){
		    	transfert=new MoneyTransfert();
		    	session.setAttribute("transfert",this.transfert);
		    }
		return transfert;
	}
	
	
	public void setTransfert(MoneyTransfert transfert) {
		this.transfert = transfert;
	    HttpSession session = getSession();
	    session.setAttribute("transfert",this.transfert);
	}
	

	public MoneyTransfert getTransfert() {
		return transfert;
	}

	
	
	private void initCountriesCurrencies() {
		currencies  = new HashMap<String, String>();
        currencies.put("USA", "USD");
        currencies.put("France", "EUR");
        currencies.put("UK", "GBP");
        currencies.put("Brazil", "BRL");
        currencies.put("Cameroon", "XAF");
        currencies.put("India", "INR");
	}

	private void initCountries() {
		countries  = new HashMap<String, String>();
        countries.put("USA", "USA");
        countries.put("France", "France");
        countries.put("UK", "UK");
        countries.put("Brazil", "Brazil");
        countries.put("Cameroon", "Cameroon");
        countries.put("India", "India");
	}
	
	
	public Map<String, String> getCountries() {
		return countries;
	}


	public void setCountries(Map<String, String> countries) {
		this.countries = countries;
	}


	public Map<String,String> getCurrencies() {
		return currencies;
	}


	public void setCurrencies(Map<String,String> currencies) {
		this.currencies = currencies;
	}



	public IMoneyTransfertEjb getMtDaoService() {
		return mtDaoService;
	}



	public void setMtDaoService(IMoneyTransfertEjb mtDaoService) {
		this.mtDaoService = mtDaoService;
	}

	
}
