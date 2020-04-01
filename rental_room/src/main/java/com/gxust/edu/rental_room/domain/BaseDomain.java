package com.gxust.edu.rental_room.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = -649458384901323179L;

    private Integer id;

}
