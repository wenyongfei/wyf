package com.wyf.po;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ApiModel(value = "用户实体类")
@Data
@ToString
public class User  implements Serializable {
    private Integer id;
    private String name;
    private String pass;
}
