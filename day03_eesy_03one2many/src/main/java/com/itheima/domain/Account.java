package com.itheima.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Account implements Serializable {

    private Integer id;
    private Integer uid;
    private Double money;
    // 一对一关系映射：从表实体应包含一个主表实体的对象引用
    private User user;
}
