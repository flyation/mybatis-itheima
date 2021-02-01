package com.itheima.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class QueryVo implements Serializable {

    private User user;
    private List<Integer> ids;
}
