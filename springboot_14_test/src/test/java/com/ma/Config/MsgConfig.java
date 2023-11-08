package com.ma.Config;


import org.springframework.context.annotation.Bean;

public class MsgConfig {

    @Bean
    public String msg(){
        return "bean msg";
    }

}
