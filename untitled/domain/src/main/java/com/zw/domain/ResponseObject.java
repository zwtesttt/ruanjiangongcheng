package com.zw.domain;

import lombok.Data;

@Data
public class ResponseObject {
    private Integer code;
    private String message;
    private Object data;
}
