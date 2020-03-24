package com.gxust.edu.rental_room.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonModel implements Serializable {

    private static final long serialVersionUID = -1018840442104519080L;

    private boolean success;
    private String msg;
    private Object data;
}
