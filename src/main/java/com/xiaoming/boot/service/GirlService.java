package com.xiaoming.boot.service;

import com.xiaoming.boot.domain.Girl;
import com.xiaoming.boot.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("BBB");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age <10){
            //返回“你还在上小学吧”
            throw new Exception("你还在上小学吧");
        }else if(age >10 && age <16){
            //返回 “你可能在上初中”
            throw new Exception("你可能在上初中");
        }
    }
}
