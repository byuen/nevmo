package com.capitalized.controller;

import com.capitalized.model.Account;
import com.capitalized.model.User;
import com.capitalized.model.request.AccountRequest;
import com.capitalized.model.request.DepositRequest;
import com.capitalized.model.request.UserRequest;
import com.capitalized.model.request.WithdrawRequest;
import com.capitalized.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    @Operation(summary = "Create User", description = "API to create user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created User", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error")
    })
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) {
        User user = userService.createUser(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    @Operation(summary = "get User", description = "API to get user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get user by ID", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error")
    })
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        Optional<User> user = userService.getUser(UUID.fromString(id));
        return user.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(path = "/{id}/account" ,method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    @Operation(summary = "Create External Account", description = "API to Create External Account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create External Account", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error")
    })
    public ResponseEntity<?> createAndAddAccount(@PathVariable("id") String id, @RequestBody AccountRequest accountRequest) {

        Optional<User> user = userService.addAccount(id, accountRequest);
        return user.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @RequestMapping(path = "/{id}/withdraw" ,method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    @Operation(summary = "withraw from Account", description = "API to withraw from Account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "withraw from Account", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error")
    })
    public ResponseEntity<?> withdrawFromAccount(@PathVariable("id") String id, @RequestBody WithdrawRequest withdrawRequest) {
        //TODO: WITHDRAW
        return null;

    }

    @RequestMapping(path = "/{id}/deposit" ,method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    @Operation(summary = "deposit from Account", description = "API to deposit from Account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "deposit from Account", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error")
    })
    public ResponseEntity<?> withdrawFromAccount(@PathVariable("id") String id, @RequestBody DepositRequest depositRequest) {
        //TODO: deposit
        return null;

    }

    @RequestMapping(path = "/{id}/receivedRequests", method = RequestMethod.GET, produces = {"application/json"})
    @Operation(summary = "get User Requests", description = "API to get user requests")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get user requests", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error")
    })
    public ResponseEntity<User> getReceivedRequests(@PathVariable("id") String id) {
        //TODO: GET USER RECEIVED REQUESTS
        return null;
    }

    @RequestMapping(path = "/{id}/sentRequests", method = RequestMethod.GET, produces = {"application/json"})
    @Operation(summary = "get Sent Requests", description = "API to get user Sent requests")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get user requests", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error")
    })
    public ResponseEntity<User> getSentRequests(@PathVariable("id") String id) {
        //TODO: GET USER SENT REQUESTS
        return null;
    }



    @RequestMapping(path = "/{id}/transactions", method = RequestMethod.GET, produces = {"application/json"})
    @Operation(summary = "get User transactions", description = "API to get user transactions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get user transactions", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error")
    })
    public ResponseEntity<User> getTransactions(@PathVariable("id") String id) {
        //TODO: GET USER TRANSACTIONS
        return null;
    }

}
