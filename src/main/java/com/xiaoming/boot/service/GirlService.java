package com.xiaoming.boot.service;

import com.xiaoming.boot.domain.Girl;
import com.xiaoming.boot.enms.ResultEnum;
import com.xiaoming.boot.exceprion.GirlExceprion;
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
//            throw new GirlExceprion(100,"你还在上小学吧");
            throw new GirlExceprion(ResultEnum.PRIMART_SHOOL);
        }else if(age >10 && age <16){
            //返回 “你可能在上初中”
//            throw new GirlExceprion(101,"你可能在上初中");
            throw new GirlExceprion(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过ID查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
