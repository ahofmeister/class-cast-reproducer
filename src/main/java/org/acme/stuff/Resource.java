package org.acme.stuff;

import com.blazebit.persistence.view.EntityViewManager;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/records")
public class Resource {

    @Inject
    protected EntityViewManager entityViewManager;

    @Inject
    protected EntityManager entityManager;

    @POST
    @Transactional
    public Response post(RecordCreate payload) {
        this.entityViewManager.save(entityManager, payload);
        return Response.ok().entity(this.entityManager.find(Record.class, payload.getId())).build();
    }


}
