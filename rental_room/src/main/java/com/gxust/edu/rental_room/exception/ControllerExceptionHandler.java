package com.gxust.edu.rental_room.exception;

import com.gxust.edu.rental_room.utils.JsonModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = KPException.class)
    @ResponseBody
    public JsonModel exceptionHandler(KPException e) {
        System.out.println("未知异常！原因是:" + e.getMessage());
        return new JsonModel();
    }
}
