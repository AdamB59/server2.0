package endpoints; /**
 * Created by mortenlaursen on 09/10/2016.
 */

import com.google.gson.Gson;
import controllers.UserController;
import database.DBConnector;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

// implements IEndpoints The Java class will be hosted at the URI path "/users"
@Path("/user")
public class UsersEndpoint  {
    UserController controller = new UserController();

    public UsersEndpoint() {
    }

    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response get() {
        if (controller.getUsers() != null) {
            return Response
                    .status(200)
                    .entity(new Gson().toJson(controller.getUsers()))
                    .build();
        }
        else {
            return Response
                    //error response
                    .status(400)
                    .entity("{\"message\":\"failed\"}")
                    .build();
        }
    }

    @Path("/{id}")
    @Produces("application/json")
    @GET
    public Response get(@PathParam("id") int userId) {
        if (controller.getUser(userId)!=null) {
            return Response
                    .status(200)
                    .entity(new Gson().toJson(controller.getUser(userId)))
                    .build();
        }
        return Response
                .status(400)
                .entity("{\"message\":\"failed\"}")
                .build();
    }

    @PUT
    @Path("/{Id}")
    @Produces("application/json")
    public Response edit(@PathParam("Id") int id, String data) throws SQLException {
        if (controller.getUser(id) != null) {
            if (controller.editUser(id, data)) {
                return Response
                        .status(200)
                        .entity("{\"message\":\"Success! User edited\"}")
                        .build();
            } else {
                return Response
                        .status(400)
                        .entity("{\"message\":\"failed\"}")
                        .build();
            }
        } else {
            return Response
                    .status(400)
                    .entity("{\"message\":\"failed. No such user\"}")
                    .build();
        }
    }

    @POST
    @Produces("application/json")
    public Response create(String data) throws Exception {
        if (controller.addUser(data)) {
            //demo to check if it returns this on post.
            return Response
                    .status(200)
                    .entity(new Gson().toJson(controller.getUsers()))
                    .build();
        }
        else return Response.status(400).entity("{\"message\":\"failed\"}").build();
    }

    @Path("/{id}")
    @DELETE
    public Response delete (@PathParam("id") int userId) throws SQLException {
        if(controller.deleteUser(userId)) {
            return Response.status(200).entity("{\"message\":\"Success! User deleted\"}").build();
        }
        else return Response.status(400).entity("{\"message\":\"failed\"}").build();
    }
}

