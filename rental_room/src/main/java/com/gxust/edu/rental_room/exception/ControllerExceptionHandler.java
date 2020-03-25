package com.gxust.edu.rental_room.exception;

import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.utils.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.bind.ValidationException;


@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({ValidationException.class,KPException.class})
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),e.getMessage());
    }
}
