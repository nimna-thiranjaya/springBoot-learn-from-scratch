package com.nimna.securitywithjwt.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
