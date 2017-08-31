package com.beosbank.jbdevg.jbdeploy.undertow.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beosbank.jbdevg.jbdeploy.undertow.dao.IMoneyTransfertService;
import com.beosbank.jbdevg.jbdeploy.undertow.entities.MoneyTransfert;

@Path("/MoneyTransfer")
@RequestScoped
public class MoneyTransferResource {
	
	@Inject
	IMoneyTransfertService dao;

   public MoneyTransferResource(){
   }

   /**
    * 
    * @param id: Money Transfer Identifier
    * @return MoneyTransfert JSON content
    * Example Call         
    *  //http://localhost:8080/beosbank-undertow-service/api/MoneyTransfer/2

    */
	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MoneyTransfert getMoneyTransferById(@PathParam("id") Long id){
        MoneyTransfert mt = dao.getMoneyTransfertById(id);
       return mt;
    }

    	
	 public IMoneyTransfertService getDao() {
			return dao;
		}

		public void setDao(IMoneyTransfertService dao) {
			this.dao = dao;
		}
}
