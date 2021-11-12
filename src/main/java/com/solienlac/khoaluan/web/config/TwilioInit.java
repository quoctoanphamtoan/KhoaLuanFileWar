package com.solienlac.khoaluan.web.config;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInit {
    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInit.class);
    @Autowired
    private final TwilioConfig twilioConfig;

    public TwilioInit(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
        Twilio.init(
                twilioConfig.getAccount_sid(),
                twilioConfig.getAuth_token()
        );
        LOGGER.info("okkkkkkkkkkkkkkkkkk! "+twilioConfig.getAccount_sid()+" and "+twilioConfig.getAuth_token());
    }

}
