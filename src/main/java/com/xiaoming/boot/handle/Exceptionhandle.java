package com.xiaoming.boot.handle;

import com.xiaoming.boot.domain.Result;
import com.xiaoming.boot.exceprion.GirlExceprion;
import com.xiaoming.boot.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 异常捕获
 */
@ControllerAdvice
public class Exceptionhandle {
    private final static Logger logger = LoggerFactory.getLogger(Exceptionhandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlExceprion){
            GirlExceprion girlExceprion = (GirlExceprion)e;
            return ResultUtil.error(girlExceprion.getCode(),girlExceprion.getMessage());
        }else{
            logger.error("[系统异常]{}",e);
            return ResultUtil.error(-1,"未知错误，请联系管理员");
        }
    }
}
