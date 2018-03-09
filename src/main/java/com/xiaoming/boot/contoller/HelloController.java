package com.xiaoming.boot.contoller;

import com.xiaoming.boot.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //1.在配置文件中的内容可以直接获取——注解Value
//    @Value("${cupSize}")
//    private String cupSize;
//    @Value("${age}")
//    private int age;
//    @Value("${content}")
//    private String content;

    //2.通过实体类自动加载所有属性——Autowwired
    @Autowired
    private GirlProperties girlProperties ;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        //1.
//        return "Hello Spring Boot"+cupSize+":"+age+"==>"+content;
        System.out.println(girlProperties.getCupSize());
        return girlProperties.getCupSize();
    }
}
