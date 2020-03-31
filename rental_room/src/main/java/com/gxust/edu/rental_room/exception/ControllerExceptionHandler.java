package com.gxust.edu.rental_room.exception;

import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.utils.ResultUtil;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 登录认证异常
     */
    @ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
    @ResponseBody
    public Result authenticationException(Exception e) {
        logger.info("登录认证异常【"+e.getMessage()+"】");
        return ResultUtil.error(ResultEnum.COMMENT_ERROR.getCode(),((AuthenticationException)e).getMessage());
    }

    /**
     * 权限异常
     */
    @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
    @ResponseBody
    public Result authorizationException(Exception e) {
        logger.info("权限不足【"+e.getMessage()+"】");
        return ResultUtil.error(ResultEnum.UNAUTHORIZED);
    }

    /**
     * 校验异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result parameterTypeException(Exception e){
        //打印校验住的所有的错误信息
        StringBuilder sb = new StringBuilder();
        List<ObjectError> list = ((BindException) e).getAllErrors();
        for (ObjectError item : list) {
            sb.append("【").append(item.getDefaultMessage()).append(";】").append("<br/>");
        }
        sb.deleteCharAt(sb.length() - 1);
        String msg = sb.toString();
        System.out.println(msg);
        return ResultUtil.error(ResultEnum.TYPE_TRANSFORM_ERROR.getCode(),msg);
    }


    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        logger.info(e.getCause().getMessage());
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR);
    }

}
