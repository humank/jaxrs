 
package serverlinkpoc.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("KimService")
@Consumes("*/*")
@Produces("*/*")
public class KimService {
	/**
     * Default constructor. 
     */
    public KimService() {
        // TODO Auto-generated constructor stub
    }


    /**
     * Retrieves representation of an instance of KimService
     * @return an instance of String
     */
	@GET
	@Produces("*/*")
	public String resourceMethodGET() { 
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
     * PUT method for updating or creating an instance of KimService
     * @content content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
	@PUT
	@Consumes("*/*")
	@Produces("*/*")
	public void resourceMethodPUT(String content) { 
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}