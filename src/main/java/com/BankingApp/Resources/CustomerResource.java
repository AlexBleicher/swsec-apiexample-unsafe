package com.BankingApp.Resources;

import com.BankingApp.Model.Customer;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

@Path("/api/customers")
public class CustomerResource {

    @Path("/getCustomer/{id}")
    @GET
    public Response getCustomer(@RestPath String id){
        return Response.ok(new Customer("1", "McTestface", "Testy", LocalDate.now(), 0.0)).build();
    }

    @POST
    public Response createCustomer() throws URISyntaxException {
        return Response.created(new URI("")).build();
    }
}
