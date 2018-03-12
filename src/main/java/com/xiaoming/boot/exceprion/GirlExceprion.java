package com.xiaoming.boot.exceprion;

import com.xiaoming.boot.enms.ResultEnum;

/**
 * 自定义异常
 */
public class GirlExceprion extends RuntimeException{
    //注意spring只对RuntimeException进行事物回滚
    private Integer code;

//    public GirlExceprion(Integer code,String message){
//        super(message);
//        this.code = code;
//    }
    public GirlExceprion(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
