package kr.ac.sogang.selab.finitrc.dcp.potal_prototype;

import java.io.IOException;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.annotations.Persistent;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.hk2.utilities.reflection.Logger;

@Path("Merchant") 
public class MerchantManager{
	
	private static PersistenceManagerFactory PMF;
	
	public MerchantManager()
	{
		PMF = JDOHelper.getPersistenceManagerFactory("transactions-optional");
	}
	
	@POST						
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMerchant(Merchant merchant)
	{
		Result result =new Result();
		PersistenceManager pm = PMF.getPersistenceManager();
		 javax.jdo.Transaction tx = pm.currentTransaction();
		 
		 tx.begin();
		 Merchant retMerchant = pm.makePersistent(merchant);
		 tx.commit();
		 
		 pm.close();
	
		 if(retMerchant == null)
		 {
			 result.setMessage("InputFail");
			 result.setFail();
		 }
		 
		 else
		 {
			 result.setSuccess();
			 result.setMessage(retMerchant.getKey().toString());
		 }
		 
		 Response response = Response.ok().entity(result).build();
		 //Response response = Response.ok().build();
		 
		 return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveMerchant()
	{
		PersistenceManager p  = PMF.getPersistenceManager();
		Query q = p.newQuery(Merchant.class);
		List<Merchant> merchantList = (List<Merchant>) q.execute();
		
		Response response =Response.ok().entity(merchantList).build();
		return response;
	}
	@GET
	@Path("/{key}")
	public Response readMerchant(@PathParam("key")String key){
		PersistenceManager p  = PMF.getPersistenceManager();
		Query q = p.newQuery(Merchant.class);
		Merchant merchant = p.getObjectById(Merchant.class,Long.parseLong(key));	
		Response response;
		
		if(merchant == null)
			response = Response.ok().entity(new Result()).build();
		else
			response =Response.ok().entity(merchant).build();
		return response;
	}

}
