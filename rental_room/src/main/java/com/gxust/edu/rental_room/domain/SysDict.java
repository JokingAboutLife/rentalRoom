package com.gxust.edu.rental_room.domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SysDict extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 5218122430499462548L;
    /**
    * 字典类型
    */
    private String type;

    /**
    * 字典代码
    */
    private String code;

    /**
    * 字典代码对应名称
    */
    private String name;

    /**
    * 选用标志 (0:未选用 1:选用 )
    */
    private Byte xyBj;

}