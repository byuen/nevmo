package com.capitalized.model;

import com.capitalized.model.request.TransactionRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    String senderId;
    String receiverId;
    BigDecimal amount;
    LocalDateTime timeStamp;


    public Transaction(TransactionRequest transactionRequest) {
        this.senderId = transactionRequest.getSenderId();
        this.receiverId = transactionRequest.getReceiverId();
        this.amount = transactionRequest.getAmount();
        this.timeStamp = LocalDateTime.now();
    }
}
