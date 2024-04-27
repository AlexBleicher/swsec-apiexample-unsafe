package com.BankingApp.Repositories;

import com.BankingApp.Model.Stock;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class StockRepository implements PanacheMongoRepository<Stock> {

    public Optional<Stock> findByName(String name){
        return find("stockName", name).firstResultOptional();
    }
}
