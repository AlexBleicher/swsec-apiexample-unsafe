package com.BankingApp.Model.DTOs;

import lombok.Data;

@Data
public class TransactDTO {
    private String receiverId;
    private double amount;
}
