package endpoints; /**
 * Created by mortenlaursen on 09/10/2016.
 */

import controllers.UserController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

// The Java class will be hosted at the URI path "/Book"
@Path("/Book")
public class BookEndpoint implements IEndpoints {
    UserController controller = new UserController();

    public BookEndpoint() {
    }

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getAll() {
        return null;
    }

    @Override
    public Response get() {
        return null;
    }

    @Path("/Book/{id}")
    @Produces("application/json")
    @GET
    public Response get(@PathParam("id") int userId) {
        return null;
    }

    @Path("/Book/{id}")
    @PUT
    public Response edit(@PathParam("id") int userId) {
        if(controller.editUser(userId)) {
            return null;
        }
        else return null;
    }

    @POST
    @Produces("application/json")
    public Response create(String data) {
        if (controller.addUser(data)) {
            return null;
        }
        else return null;
    }

    @Path("/Book/{id}")
    @DELETE
    public Response delete (@PathParam("id") int userId) {
        if(controller.deleteUser(userId)) {
            return null;
        }
        else return null;
    }
}

