package com.BankingApp.Model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@MongoEntity
public class Stock {

    private ObjectId id;
    private String stockName;
    private double currentValue;
}
