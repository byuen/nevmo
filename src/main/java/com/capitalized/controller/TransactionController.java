package com.capitalized.controller;

import com.capitalized.model.Transaction;
import com.capitalized.model.User;
import com.capitalized.model.request.TransactionRequest;
import com.capitalized.model.request.UserRequest;
import com.capitalized.service.TransactionService;
import com.capitalized.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    @Operation(summary = "Create Transaction", description = "API to create transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created Transaction", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Transaction.class))}),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error")
    })
    public ResponseEntity<?> createTransaction(@RequestBody TransactionRequest transactionRequest) {
        Transaction transaction = transactionService.createTransaction(transactionRequest);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
}
