package endpoints; /**
 * Created by mortenlaursen on 09/10/2016.
 */

import com.google.gson.Gson;
import com.sun.corba.se.spi.activation.Repository;
import controllers.BookController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

// The Java class will be hosted at the URI path "/Book"

@Path("/book")
public class BookEndpoint {
    BookController controller = new BookController();

    public BookEndpoint() {
    }

    // The Java method will process HTTP GET requests

    @GET
    @Produces("application/json")
    public Response get() throws Exception {
        if (controller.getBooks()!=null) {
            return Response
                    .status(200)
                    .entity(new Gson().toJson(controller.getBooks()))
                    .build();
        }
        else {
            return Response
                    .status(400)
                    .entity("{\"message\":\"failed\"}")
                    .build();
        }
    }


    @Path("/{id}")
    @Produces("application/json")
    @GET
    public Response get(@PathParam("id") int bookId) throws Exception {
        if (controller.getBook(bookId)!=null) {
            return Response
                    .status(200)
                    .entity(new Gson().toJson(controller.getBook(bookId)))
                    .build();
        }
        else {
            return Response
                    .status(400)
                    .entity("{\"message\":\"failed\"}")
                    .build();
        }
    }

    @PUT
    @Path("/{bookId}")
    @Produces("application/json")
    public Response edit(@PathParam("bookId") int id, String data) throws Exception {
        if (controller.getBook(id) != null) {
            if (controller.editBook(id, data)) {
                return Response
                        .status(200)
                        .entity("{\"message\":\"Success! Book edited\"}")
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
                    .entity("{\"message\":\"failed. Book not found\"}")
                    .build();
        }
    }

 /*  @POST
    @Produces("application/json")
    public Response create(String data) throws Exception {
        if (controller.addCurriculumBook(data)) {
            return Response
                    .status(200)
                    .entity("{\"message\":\"Success! Book created\"}")
                    .build();
        }
        else {
            return Response
                    .status(400)
                    .entity("{\"message\":\"failed\"}")
                    .build();
        }
    }
*/

    @Path("/{id}")
    @DELETE
    @Produces("application/json")
    public Response delete (@PathParam("id") int bookId) throws Exception {
        if(controller.deleteBook(bookId)) {
            return Response.status(200).entity("{\"message\":\"Success! Book deleted\"}").build();
        }
        else return Response.status(400).entity("{\"message\":\"failed\"}").build();
    }
}

