package com.gxust.edu.rental_room.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


@Getter
@Setter
public class Order extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 4301944558958887339L;
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
    * 签订时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

}