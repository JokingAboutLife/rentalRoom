package com.gxust.edu.rental_room.exception;

import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * 登录认证异常
     */
    @ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
    @ResponseBody
    public Result authenticationException(Exception e) {
        log.info("【登录认证异常："+e.getMessage()+"】");
        return ResultUtil.error(ResultEnum.COMMENT_ERROR.getCode(),((AuthenticationException)e).getMessage());
    }

    /**
     * 访问权限异常
     */
    @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
    @ResponseBody
    public Result authorizationException(Exception e) {
        log.info("【权限不足："+e.getMessage()+"】");
        return ResultUtil.error(ResultEnum.UNAUTHORIZED);
    }

    /**
     * 字段校验异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result parameterTypeException(Exception e){
        //打印校验的所有的错误信息
        StringBuilder sb = new StringBuilder();
        List<ObjectError> list = ((BindException) e).getAllErrors();
        for (ObjectError item : list) {
            sb.append("【").append(item.getDefaultMessage()).append(";】").append("<br/>");
        }
        sb.deleteCharAt(sb.length() - 1);
        String msg = sb.toString();
        log.info("【字段校验出错："+msg+"】");
        return ResultUtil.error(ResultEnum.TYPE_TRANSFORM_ERROR.getCode(),msg);
    }


    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        log.error("【其他异常："+e.getCause().getMessage()+"】");
        return ResultUtil.error(ResultEnum.SERVE_ERROR);
    }

}
