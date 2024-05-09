package com.BankingApp.Model.DTOs;

import lombok.Data;

@Data
public class GetStockDTO {
    private String stockName;
    private double currentValue;
}
