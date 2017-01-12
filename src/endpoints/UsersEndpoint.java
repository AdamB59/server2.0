package endpoints;

import Encrypters.*;
import com.google.gson.Gson;
import controllers.TokenController;
import controllers.UserController;
import model.User;
import model.UserLogin;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

// implements IEndpoints The Java class will be hosted at the URI path "/users"
@Path("/user")
public class UsersEndpoint  {
    UserController controller = new UserController();
    TokenController tokenController = new TokenController();

    public UsersEndpoint() {
    }

    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")

    public Response get(@HeaderParam("authorization") String authToken) throws SQLException {

        User user = tokenController.getUserFromTokens(authToken);

        // hent alle brugere (users)
        if (user != null && user.getUserType() == 1){
            if (controller.getUsers() != null) {
                return Response
                        .status(200)
                        .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT")
                        .header("Access-Control-Max-Age", "3600")
                        .header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
                        .entity(new Gson().toJson(Crypter.encryptDecryptXOR(new Gson().toJson(controller.getUsers()),authToken)))
//                      .entity(new Gson().toJson(controller.getUsers()))
                        .build();
            } else {
                return Response
                        //error response
                        .status(400)
                        .entity("{\"message\":\"failed\"}")
                        .build();
            }
        }else return Response.status(400).entity("{\"message\":\"failed\"}").build();

    }
    
    @Path("/{id}")
    @Produces("application/json")
    @GET
    public Response get(@HeaderParam("authorization") String authToken, @PathParam("id") int userId) throws SQLException {

        User user = tokenController.getUserFromTokens(authToken);

        // hent én bruger (user)
        if (user != null){
            if (controller.getUser(userId)!=null) {
                return Response
                        .status(200)
                        .entity(new Gson().toJson(Crypter.encryptDecryptXOR(new Gson().toJson(controller.getUser(userId)),authToken)))
//                        .entity(new Gson().toJson(controller.getUser(userId)))
                        .build();
            }
            return Response
                    .status(400)
                    .entity("{\"message\":\"failed\"}")
                    .build();

        } else return Response
                .status(400)
                .entity("{\"message\":\"failed\"}")
                .build();
    }

    @PUT
    @Path("/{Id}")
    @Produces("application/json")

    public Response edit(@HeaderParam("authorization") String authToken, @PathParam("Id") int id, String data) throws SQLException {

        User user = tokenController.getUserFromTokens(authToken);

        // ændre én bruger (edit user)
        if (user != null){
//            String s = new Gson().fromJson(data,String.class);
//            String decrypt = Crypter.encryptDecryptXOR(s, authToken);
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

        }else return Response.status(400).entity("{\"message\":\"failed\"}").build();


    }

    @POST
    @Produces("application/json")
    public Response create(String data) throws Exception {
//        String s = new Gson().fromJson(data,String.class);
//        String decrypt = Crypter.encryptDecryptXOR(s, authToken);

        // Opret en ny bruger ( create user )
        if (controller.addUser(data)) {
            //demo to check if it returns this on post.
            return Response
                    .status(200)
                    .entity("{\"message\":\"Success! User added\"}")
                    .build();
        }
        else return Response.status(400).entity("{\"message\":\"failed\"}").build();
    }

    @Path("/{id}")
    @DELETE
    public Response delete (@HeaderParam("authorization") String authToken, @PathParam("id") int userId) throws SQLException {

        User user = tokenController.getUserFromTokens(authToken);

        // Slet en bruger ( delete user )
        if (user != null){
            if(controller.deleteUser(userId)) {
                return Response.status(200).entity("{\"message\":\"Success! User deleted\"}").build();
            }
            else return Response.status(400).entity("{\"message\":\"failed\"}").build();
        }else return Response.status(400).entity("{\"message\":\"failed\"}").build();


    }

    @POST
    @Path("/login")
    @Produces("application/json")
    public Response login(String data) throws SQLException {
        //String decrypt = Crypter.encryptDecryptXOR(data);
        String decrypt = data;

        UserLogin userLogin = new Gson().fromJson(decrypt, UserLogin.class);
        String token = tokenController.authenticate(userLogin.getUsername(), userLogin.getPassword());

        // Login med en user
        if (token != null) {
            //demo to check if it returns this on post.
            return Response
                .status(200)
                .entity(new Gson().toJson(token))
                .build();
        } else return Response
            .status(401)
            .build();
    }

    @POST
    @Path("/logout")
    public Response logout (String data) throws SQLException {
        // Logud med en bruger
        if(tokenController.deleteToken(data)) {
            return Response
                    .status(200)
                    .entity("Success!")
                    .build();

        } else return Response
                    .status(400)
                    .entity("Failure")
                    .build();
    }

}

