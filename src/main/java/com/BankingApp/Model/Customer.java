package com.BankingApp.Model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity
public class Customer {

    private ObjectId id;
    private String bankId;
    private String lastName;
    private String firstName;
    private LocalDate birthday;
    private double accountBalance;
    private List<ShareHold> shareHoldList = new ArrayList<>();
}
