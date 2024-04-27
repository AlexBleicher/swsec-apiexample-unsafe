package com.BankingApp.Services;

import com.BankingApp.Model.Customer;
import com.BankingApp.Model.DTOs.CreateCustomerDTO;
import com.BankingApp.Repositories.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.Random;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    public void createNewCustomer(CreateCustomerDTO dto){
        Customer newCustomer = new Customer();
        newCustomer.setLastName(dto.getLastName());
        newCustomer.setFirstName(dto.getFirstName());
        newCustomer.setBirthday(dto.getBirthDay());
        newCustomer.setAccountBalance(0.0);
        newCustomer.setBankId(createBankId());
        customerRepository.persist(newCustomer);
    }

    public Customer getCustomerById(String id){
        return customerRepository.findByBankId(id).orElseThrow();
    }

    private String createBankId(){
        StringBuilder id = new StringBuilder();
        Random rand = new Random();
        for(int i=0; i<8; i++){
            id.append(rand.nextInt(10));
        }
        return id.toString();
    }
}
