package com.BankingApp.Model.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCustomerDTO {

    private String lastName;
    private String firstName;
    private LocalDate birthDay;

    private String username;
    private String password;
}
