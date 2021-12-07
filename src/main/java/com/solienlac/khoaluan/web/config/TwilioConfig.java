package com.solienlac.khoaluan.web.config;

import com.twilio.Twilio;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfig {
    private String account_sid;
    private String auth_token;
    private String phone_nummber;

    public String getAccount_sid() {
        return account_sid;
    }

    public void setAccount_sid(String account_sid) {
        this.account_sid = account_sid;
    }

    public String getAuth_token() {
        return auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public String getPhone_nummber() {
        return phone_nummber;
    }

    public void setPhone_nummber(String phone_nummber) {
        this.phone_nummber = phone_nummber;
    }

    public TwilioConfig() {
    }

    public TwilioConfig(String account_sid, String auth_token, String phone_nummber) {

        this.account_sid = account_sid;
        this.auth_token = auth_token;
        this.phone_nummber = phone_nummber;
    }
}
