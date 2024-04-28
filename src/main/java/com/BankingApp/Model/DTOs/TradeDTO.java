package com.BankingApp.Model.DTOs;

import lombok.Data;

@Data
public class TradeDTO {

    private String bankIdOfCustomer;
    private double amountBought;
}
