package com.BankingApp.Services;

import com.BankingApp.Model.Customer;
import com.BankingApp.Model.DTOs.CreateCustomerDTO;
import com.BankingApp.Model.DTOs.GetCustomerDTO;
import com.BankingApp.Model.DTOs.TransactDTO;
import com.BankingApp.Repositories.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    public void createNewCustomer(CreateCustomerDTO dto) {
        Customer newCustomer = new Customer();
        newCustomer.setLastName(dto.getLastName());
        newCustomer.setFirstName(dto.getFirstName());
        newCustomer.setBirthday(dto.getBirthDay());
        newCustomer.setAccountBalance(0.0);
        newCustomer.setBankId(createBankId());
        customerRepository.persist(newCustomer);
    }

    public Customer getCustomerById(String id) {
        return customerRepository.findByBankId(id).orElseThrow();
    }

    public List<GetCustomerDTO> getAllCustomers() {
        List<Customer> list = customerRepository.findAll().stream().toList();
        List<GetCustomerDTO> resultList = new ArrayList<>();
        for (Customer customer : list) {
            GetCustomerDTO listObject = new GetCustomerDTO();
            listObject.setBankId(customer.getBankId());
            listObject.setLastName(customer.getLastName());
            listObject.setFirstName(customer.getFirstName());
            resultList.add(listObject);
        }
        return resultList;
    }

    public void transaction(String id, TransactDTO dto) {
        Customer sender = customerRepository.findByBankId(id).orElseThrow();
        Customer receiver = customerRepository.findByBankId(dto.getReceiverId()).orElseThrow();
        double amount = dto.getAmount();
        if (amount > (sender.getAccountBalance() + 100)) {
            throw new RuntimeException("Sender can not afford this transaction.");
        }
        sender.setAccountBalance(sender.getAccountBalance() - amount);
        receiver.setAccountBalance(receiver.getAccountBalance() + amount);
        customerRepository.persistOrUpdate(sender);
        customerRepository.persistOrUpdate(receiver);
    }

    private String createBankId() {
        StringBuilder id = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 8; i++) {
            id.append(rand.nextInt(10));
        }
        return id.toString();
    }
}
