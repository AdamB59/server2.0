package endpoints;

import com.google.gson.Gson;
import controllers.CurriculumController;
import model.Book;
import model.Curriculum;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


/**
 * Created by magnusrasmussen on 17/10/2016.
 */
@Path("/curriculum")
public class CurriculumEndpoint implements IEndpoints{

    Gson gson = new Gson();


    CurriculumController curriculumController;


    public CurriculumEndpoint(){

        curriculumController = new CurriculumController();
    }

    @GET
    @Path("/curriculum/{curriculumId}/books")
    @Produces("application/json")
    public Response getCurriculum(@PathParam("curriculumId") int curriculumID){

        Curriculum curriculum = curriculumController.getCurriculum(curriculumID);


        return Response
                .status(200)
                .entity(new Gson().toJson(curriculum))
                .header("Access-Control-Allow-Origin", "*") //Skal måske være der
                .build(); //kør
    }

    @Override
    @GET
    @Path("/curriculum/")
    @Produces("application/json")
    public Response get() {
        return null;
    }

    @Override
    @GET
    @Path("/curriculum/{curriculumId}")
    @Produces("application/json")
    public Response get(@PathParam("curriculumId") int id) {
        return null;
    }

    @Override
    @POST
    @Path("/curriculum")
    @Produces("application/json")
    public Response create(String data) {
        return null;
    }

    @Override
    @PUT
    @Path("/curriculum/{curriculumId}")
    @Produces("application/json")
    public Response edit(@PathParam("curriculumId") int id) {
        return null;
    }

    @Override
    @DELETE
    @Path("/curriculum/{curriculumId}")
    @Produces("application/json")
    public Response delete(@PathParam("curriculumId") int id) {
        return null;
    }
}
