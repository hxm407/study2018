package com.xiaoming.boot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 实体类
 */
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;
    private String cupSize;

    @Min(value = 18,message = "未成年少女")
    private Integer age;
    @NotNull(message = "金额不能为空")
    private Integer monery;

    public Girl(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", monery=" + monery +
                '}';
    }

    public Integer getMonery() {
        return monery;
    }

    public void setMonery(Integer monery) {
        this.monery = monery;
    }
}
