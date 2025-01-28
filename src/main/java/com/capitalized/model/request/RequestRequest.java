package com.capitalized.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestRequest {
    String senderId;
    String receiverId;
    BigDecimal amount;
    LocalDateTime timeStamp;
}
