package com.gxust.edu.rental_room.domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author With Me
 * @description 
 * @date 2020/3/28
 * 方欣科技/社保事业部
 * 修改记录
 * 修改人：     修改日期:        版本：         修改内容:
 * With Me  2020/3/28 0:15    1.0             
 */
@Getter
@Setter
public class SysDict extends BaseDomain implements Serializable {

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

    private static final long serialVersionUID = 1L;
}