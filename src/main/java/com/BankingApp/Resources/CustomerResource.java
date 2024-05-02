package com.BankingApp.Resources;

import com.BankingApp.Model.DTOs.CreateCustomerDTO;
import com.BankingApp.Model.DTOs.TransactDTO;
import com.BankingApp.Services.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.reactive.RestPath;

import java.net.URI;
import java.net.URISyntaxException;

@Path("/api/customers")
public class CustomerResource {

    @Inject
    CustomerService customerService;
    @Path("/getCustomer/{id}")
    @GET
    public Response getCustomer(@RestPath String id){
        return Response.ok(customerService.getCustomerById(id)).build();
    }

    @Path("/getAllCustomers")
    @GET
    public Response getAllCustomers(){
        return Response.ok(customerService.getAllCustomers()).build();
    }
    @POST
    public Response createCustomer(@RequestBody CreateCustomerDTO dto) throws URISyntaxException {
        customerService.createNewCustomer(dto);
        return Response.created(new URI("")).build();
    }

    @Path("/transact/{id}")
    @PATCH
    public Response transactTo(@RestPath String id, @RequestBody TransactDTO transactDTO){
        customerService.transaction(id, transactDTO);
        return Response.ok().build();
    }
}
