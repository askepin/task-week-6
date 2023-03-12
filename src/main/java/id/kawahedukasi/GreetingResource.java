package id.kawahedukasi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Selamat Datang di Program Saya: GET";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String post() {
        return "Selamat Datang di Program Saya: POST";
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String put() {
        return "Selamat Datang di Program Saya: PUT";
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String delete() {
        return "Selamat Datang di Program Saya: DELETE";
    }
}