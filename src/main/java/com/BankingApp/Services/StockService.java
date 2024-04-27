package com.BankingApp.Services;

import com.BankingApp.Model.DTOs.CreateStockDTO;
import com.BankingApp.Model.Stock;
import com.BankingApp.Repositories.StockRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class StockService {
    @Inject
    StockRepository stockRepository;

    public void createStock(CreateStockDTO dto){
        Stock newStock = new Stock();
        newStock.setStockName(dto.getStockName());
        newStock.setCurrentValue(0.0);
        stockRepository.persist(newStock);
    }

    public Stock getStockByName(String stockName){
        return stockRepository.findByName(stockName).orElseThrow();
    }
}
