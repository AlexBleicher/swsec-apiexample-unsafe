package com.BankingApp.Services;

import com.BankingApp.Model.Customer;
import com.BankingApp.Model.DTOs.CreateStockDTO;
import com.BankingApp.Model.DTOs.TradeDTO;
import com.BankingApp.Model.ShareHold;
import com.BankingApp.Model.Stock;
import com.BankingApp.Model.Trade;
import com.BankingApp.Repositories.CustomerRepository;
import com.BankingApp.Repositories.StockRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class StockService {
    @Inject
    StockRepository stockRepository;

    @Inject
    CustomerRepository customerRepository;

    public void createStock(CreateStockDTO dto){
        Stock newStock = new Stock();
        newStock.setStockName(dto.getStockName());
        newStock.setCurrentValue(0.0);
        stockRepository.persist(newStock);
    }

    public Stock getStockByName(String stockName){
        return stockRepository.findByName(stockName).orElseThrow();
    }

    public void tradeStock(String stockName, TradeDTO dto){
        Stock stock = stockRepository.findByName(stockName).orElseThrow();
        Customer customer = customerRepository.findByBankId(dto.getBankIdOfCustomer()).orElseThrow();
        double amountBought = dto.getAmountBought();
        if(amountBought>(customer.getAccountBalance()+100)){
            throw new RuntimeException("Customer can't afford this transaction");
        }
        stock.setCurrentValue(stock.getCurrentValue()+amountBought);
        Trade trade = new Trade(amountBought, LocalDateTime.now());
        stock.addToTrades(trade);
        List<ShareHold> shareHoldList = customer.getShareHoldList();
        boolean shareHoldChanged = false;
        for (ShareHold shareHold : shareHoldList) {
            if(shareHold.getStockName().equals(stockName)){
                shareHold.setAmount(shareHold.getAmount()+amountBought);
                shareHoldChanged=true;
            }
        }
        if(!shareHoldChanged){
            shareHoldList.add(new ShareHold(stockName, amountBought));
        }
        customer.setShareHoldList(shareHoldList);
        customer.setAccountBalance(customer.getAccountBalance()-amountBought);
        customerRepository.persistOrUpdate(customer);
        stockRepository.persistOrUpdate(stock);
    }
}
