package com.solienlac.khoaluan.web.service.impl;

import com.solienlac.khoaluan.web.common.dto.SmsRequest;
import com.solienlac.khoaluan.web.config.TwilioConfig;
import com.solienlac.khoaluan.web.service.SmsSenderService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SmsSenderServiceImpl implements SmsSenderService {
    private final TwilioConfig twilioConfig ;

    public SmsSenderServiceImpl(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    @Override
    public void senderSms(SmsRequest smsRequest) throws IllegalAccessException {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())){
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getPhone_nummber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to,from,message);
            creator.create();
        }else{
            throw new IllegalAccessException("Phone number error! ");
        }

    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.equalsIgnoreCase("")){
            return false;
        }
        return true;
    }
}
