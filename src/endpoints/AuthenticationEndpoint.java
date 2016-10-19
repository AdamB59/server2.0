package endpoints;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

/**
 * Created by aleksanderkristiansen on 19/10/2016.
 */
@Path("/authentication")
public class AuthenticationEndpoint {

    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Response authenticateUser(@FormParam("username") String username,
                                     @FormParam("password") String password) {

        try {

            // Authenticate the user using the credentials provided
            authenticate(username, password);

            // Issue a token for the user
            String token = issueToken(username);

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(UNAUTHORIZED).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        //
        //Authenticate against a database, LDAP, file or whatever
        //Throw an Exception if the credentials are invalid
        //
    }

    private String issueToken(String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
    }
}