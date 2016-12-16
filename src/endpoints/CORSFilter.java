package endpoints;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public void filter(final ContainerRequestContext request,
                       final ContainerResponseContext cres) throws IOException {
        // Denne styre "hvem" der kan kontakte mit API fx. localhost eller et domæne fx. facebook.com og pt. tillader den at alle kan kontakte API'et
        cres.getHeaders().add("Access-Control-Allow-Origin", "*");
        // API = Applikation Programming Interface
        // Nedenstående styrer hvilke metoder API'et tillader at håndtere når det bliver kontaktet.
        cres.getHeaders().add("Access-Control-Allow-Methods", "POST, PUT, DELETE, GET, OPTIONS");
        cres.getHeaders().add("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, authorization, X-Requested-With");
    }
}