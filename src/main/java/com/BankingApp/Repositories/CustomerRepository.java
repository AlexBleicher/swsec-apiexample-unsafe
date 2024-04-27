package com.BankingApp.Repositories;

import com.BankingApp.Model.Customer;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class CustomerRepository implements PanacheMongoRepository<Customer> {

    public Optional<Customer> findByBankId(String bankId){
        return find("bankId", bankId).firstResultOptional();
    }
}
