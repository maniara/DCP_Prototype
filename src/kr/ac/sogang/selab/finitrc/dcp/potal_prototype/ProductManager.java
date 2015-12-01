package kr.ac.sogang.selab.finitrc.dcp.potal_prototype;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Product") 
public class ProductManager {
	
private static PersistenceManagerFactory PMF;
	
	public ProductManager()
	{
		PMF = JDOHelper.getPersistenceManagerFactory("transactions-optional");
	}
	
	@POST						
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(Product product)
	{
		Result result =new Result();
		PersistenceManager pm = PMF.getPersistenceManager();
		 javax.jdo.Transaction tx = pm.currentTransaction();
		 
		 tx.begin();
		 Product retProduct = pm.makePersistent(product);
		 tx.commit();
		 
		 pm.close();
	
		 if(retProduct == null)
		 {
			 result.setMessage("InputFail");
			 result.setFail();
		 }
		 
		 else
		 {
			 result.setSuccess();
			 result.setMessage(retProduct.getKey().toString());
		 }
		 
		 Response response = Response.ok().entity(result).build();
		 //Response response = Response.ok().build();
		 
		 return response;
	}
	
	@GET
	@Path("/{merchantKey}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveProduct(@PathParam("merchantKey")String merchantKey)
	{
		PersistenceManager p  = PMF.getPersistenceManager();
		Query q = p.newQuery(Product.class);
		q.setFilter("merchantKey==merchantKeyParam");
		q.declareParameters("String merchantKeyParam");
		List<Product> productList = (List<Product>) q.execute(Long.parseLong(merchantKey));
		
		Response response =Response.ok().entity(productList).build();
		return response;
	}

}
