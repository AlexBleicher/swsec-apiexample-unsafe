package com.BankingApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Trade {

    private double amountTraded;
    private LocalDateTime timeOfTrade;
}
