package com.gxust.edu.rental_room.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;
}
