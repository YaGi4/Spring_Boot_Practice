package com.example.Practice.Dto;

import lombok.Data;

@Data
public class TransactionReportDto {

    Boolean transactionStatus = false;
    Integer numberOfChecked = 0;
    Integer numberOfAdded = 0;
    Integer numberOfDeleted = 0;
    Integer numberOfChanges = 0;

}
