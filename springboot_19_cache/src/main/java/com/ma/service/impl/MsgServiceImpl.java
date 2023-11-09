package com.ma.service.impl;

import com.ma.service.MsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MsgServiceImpl implements MsgService {
    private HashMap<String ,String> MsgCache = new HashMap<>();

    @Override
    public String get(String tele) {
        // 后六位作为验证码
        String code = tele.substring(tele.length() - 6);

        MsgCache .put(tele,code);
        return code;
    }

    @Override
    public boolean check(String tele, String code) {
        // 取缓存中数据
        String queryCode = MsgCache.get(tele);
        return code.equals(queryCode);
    }
}
