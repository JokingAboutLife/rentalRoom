package com.gxust.edu.rental_room.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = -649458384901323179L;

    private Integer id;

}
