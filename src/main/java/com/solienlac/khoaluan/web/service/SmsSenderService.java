package com.solienlac.khoaluan.web.service;


import com.solienlac.khoaluan.web.common.dto.SmsRequest;

public interface SmsSenderService {
    void senderSms(SmsRequest smsRequest) throws IllegalAccessException;
}
