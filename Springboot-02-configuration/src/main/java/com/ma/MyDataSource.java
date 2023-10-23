package com.ma;

/* *
 * @packing com.ma
 * @author mtc
 * @date 13:43 10 21 13:43
 *
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/*
* 1.定义数据模型封装yaml文件中的数据
* 2.定义为spring管控的bean
* 3.指定加载的数据 @ConfigurationProperties
* 4.使用在程序中注入使用
* */

@ConfigurationProperties(prefix = "datasource")
@Component
@Data
public class MyDataSource {
    // 变量名必须和属性名一致
    private String dirver;
    private String url;
    private String username;
    private String password;
}
