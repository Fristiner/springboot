package com.ma.controller;


import com.ma.domain.SMSCode;
import com.ma.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SMSController {

    @Autowired
    private SMSCodeService service;

    @GetMapping("{tele}")
    public String  getCode(@PathVariable String tele){
        return service.sendCodeToSMS(tele);
    }

    @PostMapping
    public boolean checkCode(SMSCode smsCode){
        return service.checkCode(smsCode);
    }

}
