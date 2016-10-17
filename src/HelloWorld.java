/**
 * Created by mortenlaursen on 09/10/2016.
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloWorld {

    public ConnectionDB connectionDB;





    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() throws Exception {
        // Return some cliched textual content

        connectionDB = new ConnectionDB();





        try {
            return connectionDB.getSchools().get(0);
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }








    }
}
