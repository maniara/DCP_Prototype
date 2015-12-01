package kr.ac.sogang.selab.finitrc.dcp.potal_prototype;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Wallet") 
public class WalletManager {
	
private static PersistenceManagerFactory PMF;
	
	public WalletManager()
	{
		PMF = JDOHelper.getPersistenceManagerFactory("transactions-optional");
	}
	
	@POST						
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createWallet(Wallet wallet)
	{
		Result result =new Result();
		PersistenceManager pm = PMF.getPersistenceManager();
		 javax.jdo.Transaction tx = pm.currentTransaction();
		 
		 tx.begin();
		 Wallet retWallet = pm.makePersistent(wallet);
		 tx.commit();
		 
		 pm.close();
	
		 if(retWallet == null)
		 {
			 result.setMessage("InputFail");
			 result.setFail();
		 }
		 
		 else
		 {
			 result.setSuccess();
			 result.setMessage(retWallet.getKey().toString());
		 }
		 
		 Response response = Response.ok().entity(result).build();
		 //Response response = Response.ok().build();
		 
		 return response;
	}

}
