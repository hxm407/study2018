package com.xiaoming.boot.contoller;

import com.xiaoming.boot.domain.Girl;
import com.xiaoming.boot.domain.Result;
import com.xiaoming.boot.repository.GirlRepository;
import com.xiaoming.boot.service.GirlService;
import com.xiaoming.boot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 女孩控制器
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        System.out.println("===>girlList");
        return girlRepository.findAll();
    }

    //增加一个女生
    @PostMapping(value = "/addgirl")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        //bindingResult 返回错误值  @Valid 进行对象校验
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
       return ResultUtil.success(girlRepository.save(girl));
    }

    //查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id")Integer id){
        System.out.println("===>girlFindOne");
        return girlRepository.findOne(id);
    }

    //更新一个女生
    @PostMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable(value = "id")Integer id,
                           @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age){
            Girl girl = new Girl();
            girl.setId(id);
            girl.setAge(age);
            girl.setCupSize(cupSize);

            return girlRepository.save(girl);
    }
    //删除一个女生
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable(value = "id")Integer id){
        girlRepository.delete(id);
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable(value = "age")Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws  Exception
    {
        girlService.getAge(id);
    }
}
