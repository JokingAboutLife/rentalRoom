package com.gxust.edu.rental_room.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


@Getter
@Setter
public class YzInfo extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -4455366365941398935L;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date yztime;

}