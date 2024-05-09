package com.BankingApp.Model.DTOs;

import lombok.Data;

@Data
public class GetCustomerDTO {
    private String bankId;
    private String firstName;
    private String lastName;
}
