package acc.br;


import acc.br.model.Fruta;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.sql.DataSource;
import java.util.List;

@Path("/frutas")
public class FrutasResource {


    @Inject
    DataSource datasource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruta> list() {

        return Fruta.listAll();

    }

    @POST
    @Transactional
    public Response novaFruta(List<Fruta> frutas) {
        for (Fruta fruta : frutas) {
            fruta.persist();
        }
        return Response.status(Response.Status.CREATED).entity(frutas).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteFruta(@PathParam("id") Long id) {
        Fruta fruta = Fruta.findById(id);
        fruta.delete();
        return Response.status(Response.Status.CREATED).build();
    }

}
