package com.solienlac.khoaluan.web.service;


import com.solienlac.khoaluan.web.common.dto.param.PostSmsCanhBao;

public interface SmsSenderService {
    Integer senderSms(PostSmsCanhBao postSmsCanhBao) throws IllegalAccessException;
}
