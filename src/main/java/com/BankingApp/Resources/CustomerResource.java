package com.BankingApp.Resources;

import com.BankingApp.Model.Customer;
import com.BankingApp.Model.DTOs.CreateCustomerDTO;
import com.BankingApp.Services.CustomerService;
import jakarta.inject.Inject;
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

    @Inject
    CustomerService customerService;
    @Path("/getCustomer/{id}")
    @GET
    public Response getCustomer(@RestPath String id){
        return Response.ok(customerService.getCustomerById(id)).build();
    }

    @POST
    public Response createCustomer(CreateCustomerDTO dto) throws URISyntaxException {
        customerService.createNewCustomer(dto);
        return Response.created(new URI("")).build();
    }
}
