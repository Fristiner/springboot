package com.ma.controller.utils;

/* *
 * @packing com.ma.controller.utils
 * @author mtc
 * @date 16:20 10 31 16:20
 *
 */

import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private  Object data;

    private String msg;

    public R(Boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag,String msg){
        this.flag = flag;
        this.msg = msg;
    }

    public R(Boolean flag){
        this.flag = flag;
    }
    public  R(){}


}
