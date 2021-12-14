package com.example.rabbitcheckouttest.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class EmailMessage {
    private String to;
    private String subject;
    private String body;
}
