package com.BankingApp.Resources;

import com.BankingApp.Model.DTOs.CreateStockDTO;
import com.BankingApp.Services.StockService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;

import java.net.URI;
import java.net.URISyntaxException;

@Path("/api/stocks")
public class StockResource {

    @Inject
    StockService stockService;

    @POST
    public Response goPublic(CreateStockDTO dto) throws URISyntaxException {
        stockService.createStock(dto);
        return Response.created(new URI("")).build();
    }

    @Path("/{stockName}")
    @GET
    public Response getByStockName(@RestPath String stockName) {
        return Response.ok(stockService.getStockByName(stockName)).build();
    }

}
