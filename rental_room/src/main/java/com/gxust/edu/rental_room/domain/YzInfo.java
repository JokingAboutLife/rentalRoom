package com.gxust.edu.rental_room.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class YzInfo extends BaseDomain implements Serializable {

    /**
    * 租客id
    */
    private Integer userid;

    /**
    * 房主id
    */
    private Integer lessorid;

    /**
    * 房屋id
    */
    private Integer houseid;

    /**
    * 租期
    */
    private Integer period;

    /**
    * 预租日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date yztime;

    private static final long serialVersionUID = 1L;
}