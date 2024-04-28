package com.BankingApp.Model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Data
@MongoEntity
public class Stock {

    private ObjectId id;
    private String stockName;
    private double currentValue;
    private List<Trade> trades = new ArrayList<>();

    public void addToTrades(Trade t){
        trades.add(t);
    }
}
