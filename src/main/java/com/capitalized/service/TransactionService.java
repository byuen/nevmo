package com.capitalized.service;

import com.capitalized.model.Transaction;
import com.capitalized.model.User;
import com.capitalized.model.request.TransactionRequest;
import com.capitalized.repository.TransactionRepository;
import com.capitalized.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public Transaction createTransaction(TransactionRequest transactionRequest) {
        try {
            User sender = userService.getUser(UUID.fromString(transactionRequest.getSenderId())).get();
            User receiver = userService.getUser(UUID.fromString(transactionRequest.getReceiverId())).get();

            sender.getAccounts().get(0).setBalance(sender.getAccounts().get(0).getBalance().subtract(transactionRequest.getAmount()));
            receiver.getAccounts().get(0).setBalance(receiver.getAccounts().get(0).getBalance().add(transactionRequest.getAmount()));

            userRepository.save(sender);
            userRepository.save(receiver);
            Transaction transaction = new Transaction(transactionRequest);

            return transactionRepository.save(transaction);
        } catch (Exception e) {
            //TODO: ROLLBACK,LOG AND CREATE GLOBAL ERROR HANDLER
            return null;
        }
    }
}
