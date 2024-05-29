package com.sparta.personalproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseGeneric <T>{ // 진보적인 방법, 대신 이름을 제네릭보단 commonResponse 이런식으로 변경하기

    private  T data;
    private  Integer statuscode;
    private  String message;

}
