package com.gxust.edu.rental_room.exception;

import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.utils.ResultUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;


@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseBody
    public String error(AuthenticationException e) {
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++授权异常+++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println(e.getMessage());
        return "未授权";
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        System.out.println("=====================================");
        System.out.println("===============发生异常===============");
        System.out.println("=====================================");
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),e.getMessage());
    }

}
