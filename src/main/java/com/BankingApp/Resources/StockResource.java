package com.BankingApp.Resources;

import com.BankingApp.Model.DTOs.CreateStockDTO;
import com.BankingApp.Model.DTOs.TradeDTO;
import com.BankingApp.Services.StockService;
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

    @Path("/prediction/{stockName}")
    @GET
    public Response getPredictionForStock(@RestPath String stockName){
        return Response.ok(stockService.getPredictionForStock(stockName)).build();
    }

    @Path("/trade/{stockName}")
    @PATCH
    public Response tradeStock(@RestPath String stockName, @RequestBody TradeDTO tradeDTO){
        stockService.tradeStock(stockName, tradeDTO);
        return Response.ok().build();
    }

    @Path("/shareDividends/{stockName}")
    @PATCH
    public Response shareDividends(@RestPath String stockName){
        stockService.shareDividends(stockName);
        return Response.ok().build();
    }
}
