package com.ma.service;

import com.ma.domain.SMSCode;

public interface SMSCodeService {
    //
    String sendCodeToSMS(String tele);
    boolean checkCode(SMSCode smsCode);
}
