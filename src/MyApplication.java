/**
 * Created by mortenlaursen on 09/10/2016.
 */
import endpoints.BookEndpoint;
import endpoints.UsersEndpoint;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//Defines the base URI for all resource URIs.
@ApplicationPath("/")
//The java class declares root resource and provider classes
public class MyApplication extends Application{
    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add( UsersEndpoint.class);
        h.add( HashingEndpoint.class);
        h.add( CrypterEndpoint.class);
        return h;
    }

    //This is unnecessary and doesn't work.
    @GET
    @Produces("text/plain")
    public String demo() {
        return "This is root!";
    }
}
