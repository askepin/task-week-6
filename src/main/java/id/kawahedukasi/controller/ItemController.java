package id.kawahedukasi.controller;

import id.kawahedukasi.model.Item;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;

@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemController {
    @GET
    public List<Item> getAll(){
        return Item.listAll();
    }

    @GET
    @Path("/{id}")
    public Item getOne(@PathParam("id") Long id){
        return Item.findById(id);
    }

    @POST
    @Transactional
    public Response create(Item item) {
        item.createdAt = LocalDateTime.now();
        item.updatedAt = LocalDateTime.now();
        item.persist();
        return Response.status(Response.Status.CREATED).entity(item).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Item update(@PathParam("id") Long id, Item item) {
        Item entity = Item.findById(id);
        if (entity != null) {
            entity.name = item.name;
            entity.count = item.count;
            entity.price = item.price;
            entity.type = item.type;
            entity.description = item.description;
            entity.updatedAt = LocalDateTime.now();
        }
        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Item entity = Item.findById(id);
        if (entity != null) {
            entity.delete();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
