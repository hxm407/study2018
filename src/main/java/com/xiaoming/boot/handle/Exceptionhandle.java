package com.xiaoming.boot.handle;

import com.xiaoming.boot.domain.Result;
import com.xiaoming.boot.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获
 */
@ControllerAdvice
public class Exceptionhandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        return ResultUtil.error(100,e.getMessage());
    }
}
