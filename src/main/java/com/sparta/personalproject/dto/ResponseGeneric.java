package com.sparta.personalproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseGeneric <T>{

    private  T data;
    private  Integer statuscode;
    private  String message;

}
