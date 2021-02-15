package com.xjb_villager.lifei.config.exception;

import com.xjb_villager.lifei.common.ResultGenerator;
import com.xjb_villager.lifei.common.ResultLV;
import com.xjb_villager.lifei.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@ControllerAdvice(basePackages = "com.xjb_villager")
public class HandlerExceptionAspect {
    /**
     * 统一处理JSON响应结果的错误结果 例如：{"code":201,message:"入参异常",data:null}
     *
     * @param cause   {@link Throwable} 异常
     * @param request {@link HttpServletRequest} 请求
     * @return {@link ResultLV} 响应结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultLV process(Throwable cause, HttpServletRequest request, HttpServletResponse response) {
        ResultLV resultLV;
        if (cause instanceof MethodArgumentNotValidException) {
            String errorMessage = this.methodArgumentMessage((MethodArgumentNotValidException) cause);
            resultLV = ResultGenerator.genResult(ResultCode.PARAMETER_ERROR.code, errorMessage, "");
            log.error("MethodArgumentNotValidException");
        } else if (cause instanceof HttpMessageNotReadableException) {
            log.error("HttpMessageNotReadableException");
            resultLV = ResultGenerator.genResult(ResultCode.PARAMETER_ERROR.code, cause.getMessage(), "");
        } else if (cause instanceof MissingServletRequestParameterException) {
            log.error("MissingServletRequestParameterException");
            resultLV = ResultGenerator.genResult(ResultCode.PARAMETER_ERROR.code, cause.getMessage(), "");
        } else {
            log.error("else other cause :{}",cause);
            resultLV = ResultGenerator.genResult(ResultCode.SERVER_EXCEPTION.code, ResultCode.SERVER_EXCEPTION.msg,"");
        }

        log.error("error:{}", cause);
        return resultLV;
    }


    /**
     * 参数异常消息获取
     *
     * @param cause 参数异常
     * @return 异常原因
     */
    private String methodArgumentMessage(MethodArgumentNotValidException cause) {
        MethodArgumentNotValidException validException = cause;
        BindingResult bindingResult = validException.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuilder builder = new StringBuilder();
        for (ObjectError objectError : allErrors) {
            if (StringUtils.isNotBlank(objectError.getDefaultMessage())) {
                if (StringUtils.isNotBlank(builder)) {
                    builder.append(";");
                }
                builder.append(objectError.getDefaultMessage());
            }

        }
        if (StringUtils.isBlank(builder)) {
            builder.append("参数错误");
        }
        return builder.toString();
    }

    /**
     * 拦截自定义异常
     * @param ex
     * @return
     */
    @ExceptionHandler({BaseException.class})
    @ResponseBody
    public ResultLV exceptionHandler(BaseException ex){
        //ex.printStackTrace();
        log.error("common BaseException:{}",ex.toString());
        return ResultGenerator.genResult(ex.getCode(),ex.getMessage(),ex.getData());
    }



    @ExceptionHandler({ServiceException.class})
    @ResponseBody
    public ResultLV exceptionHandler(ServiceException ex){
        //ex.printStackTrace();
        log.error("common ServiceException:{}",ex.toString());
        return ResultGenerator.genResult(ex.getCode(),ex.getMessage(),ex.getData());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public ResultLV exceptionHandler(HttpMessageNotReadableException ex){
        //ex.printStackTrace();
        log.error("common HttpMessageNotReadableException:{}",ex.toString());
        return ResultGenerator.genResult(ResultCode.SERVER_EXCEPTION.code,ResultCode.SERVER_EXCEPTION.msg);
    }



    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    @ResponseBody
    public ResultLV exceptionHandler(HttpMediaTypeNotSupportedException ex){
        //ex.printStackTrace();
        log.error("common HttpMediaTypeNotSupportedException:{}",ex.toString());
        return ResultGenerator.genResult(ResultCode.UNSUPPORTED_MEDIA_TYPE.code,ResultCode.UNSUPPORTED_MEDIA_TYPE.msg);
    }

    @ExceptionHandler({Throwable.class})
    @ResponseBody
    public ResultLV exceptionHandler(Throwable ex){
        //ex.printStackTrace();
        log.error("common Throwable:{}",ex.toString());
        return ResultGenerator.genResult(ResultCode.SERVER_EXCEPTION.code,ResultCode.SERVER_EXCEPTION.msg);
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public ResultLV exceptionHandler(MissingServletRequestParameterException ex){
        //ex.printStackTrace();
        log.error("common MissingServletRequestParameterException:{}",ex.toString());
        return ResultGenerator.genResult(ResultCode.PARAMETER_ERROR.code,ResultCode.PARAMETER_ERROR.msg);
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ResultLV exceptionHandler(MethodArgumentNotValidException ex){
        //ex.printStackTrace();
        log.error("common MethodArgumentNotValidException:{}",ex.toString());
        return ResultGenerator.genResult(ResultCode.PARAMETER_ERROR.code,ResultCode.PARAMETER_ERROR.msg);
    }


}
