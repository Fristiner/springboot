package com.ma.config;

/* *
 * @packing com.ma.config
 * @author mtc
 * @date 19:13 11 07 19:13
 *
 */


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
@Data
@ConfigurationProperties(prefix = "servers")
// 2.开启对当前bean的属性进行注入校验
@Validated
public class ServletConfig {


    private String ipAddress;

    @Max(value = 222, message = "最大值不能超过222")
    private int port;
    @Min(value = 1, message = "最小值为1")
    private Long timeout;

    // 设置的时间单位
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeout;
    // 设置容量单位
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;

}
