package com.BankingApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@ Data
@AllArgsConstructor
public class Customer {

    private String id;
    private String lastName;
    private String firstName;
    private LocalDate birthday;
    private double accountBalance;

}
