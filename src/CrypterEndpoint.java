/**
 * Created by madsgade on 17/10/2016.
 */

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/crypter")
public class CrypterEndpoint {
    
    Gson gson;
    Crypter crypter;

    public CrypterEndpoint() {

        // instantierer  gson og crypter objekter
        gson = new Gson();
        crypter = new Crypter();
    }

    // Denne metode The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")

    public String xor() {
        return Crypter.xor();
    }


    @Path("/getit")
    @GET
    @Produces("text/plain")
    public String getit() {
        return "Got it!";
    }
}