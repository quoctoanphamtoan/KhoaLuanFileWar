package com.solienlac.khoaluan.web.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorExeption extends IllegalStateException{
    public InternalServerErrorExeption(String s) {
        super(s);
    }
}