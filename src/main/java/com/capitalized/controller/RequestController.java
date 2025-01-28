package com.capitalized.controller;

import com.capitalized.model.Request;
import com.capitalized.model.Transaction;
import com.capitalized.model.request.RequestRequest;
import com.capitalized.model.request.TransactionRequest;
import com.capitalized.service.RequestService;
import com.capitalized.service.TransactionService;
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
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    @Operation(summary = "Create Request", description = "API to create Request")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created Request", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Request.class))}),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error")
    })
    public ResponseEntity<?> createRequest(@RequestBody RequestRequest requestRequest) {
        //TODO: CREATE REQUEST
        return null;
    }


    @RequestMapping(method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
    @Operation(summary = "Respond to  Request", description = "API to Respond Request")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respond Request", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Request.class))}),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error")
    })
    public ResponseEntity<?> respondRequest(@RequestBody RequestRequest requestRequest) {
        //TODO: CREATE RESPOND REQUEST - APPROVE/DENY/CANCEL REQUEST
        return null;
    }
}
