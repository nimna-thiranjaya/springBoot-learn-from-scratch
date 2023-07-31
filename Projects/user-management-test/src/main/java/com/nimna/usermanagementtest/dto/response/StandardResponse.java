package com.nimna.usermanagementtest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StandardResponse {
    private boolean isSuccess;
    private int code;
    private String message;
    private Instant timestamp;
    private Object dataSet;
}