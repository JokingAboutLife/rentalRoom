package com.gxust.edu.rental_room.exception;

import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = KPException.class)
    @ResponseBody
    public Result exceptionHandler(KPException e) {
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
    }
}
