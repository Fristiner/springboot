package com.ma.service.impl;

import com.ma.domain.SMSCode;
import com.ma.service.SMSCodeService;
import com.ma.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;


    @Override
    // 这里需要的是将结果放到缓存中不需要从缓存中读
//    @Cacheable(key = "#tele", value = "smsCode")
    @CachePut(key = "#tele", value = "smsCode")
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        // 取出内存中的验证码与传递过来的验证码进行比较
        String code = smsCode.getCode();
        // 这里使用要用bean来管理
        String cacheCode = codeUtils.get(smsCode.getTele());
        return code.equals(cacheCode);
    }
    // 如果放在用一个类中 是同一个类的方法调用
    // 如果要用这个Cache调用必须要使用spring bean
}
