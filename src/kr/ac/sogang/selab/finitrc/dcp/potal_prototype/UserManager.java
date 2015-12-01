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

@Path("User") 
public class UserManager {
	
private static PersistenceManagerFactory PMF;
	
	public UserManager()
	{
		PMF = JDOHelper.getPersistenceManagerFactory("transactions-optional");
	}
	
	@POST						
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(User user)
	{
		Result result =new Result();
		PersistenceManager pm = PMF.getPersistenceManager();
		 javax.jdo.Transaction tx = pm.currentTransaction();
		 
		 tx.begin();
		 User retUser = pm.makePersistent(user);
		 tx.commit();
		 
		 pm.close();
	
		 if(retUser == null)
		 {
			 result.setMessage("InputFail");
			 result.setFail();
		 }
		 
		 else
		 {
			 result.setSuccess();
			 result.setMessage(retUser.getKey().toString());
		 }
		 
		 Response response = Response.ok().entity(result).build();
		 //Response response = Response.ok().build();
		 
		 return response;
	}

}
