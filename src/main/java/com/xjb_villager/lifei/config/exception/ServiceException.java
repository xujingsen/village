package com.xjb_villager.lifei.config.exception;

import com.xjb_villager.lifei.common.ResultCodeInterface;

/**
 * <pre>
 *   自定义server异常类
 * </pre>
 *
 * @param
 * @return
 * @author xjs
 * created by  2021年02月04日09:20:06
 */
public class ServiceException extends  BaseException{

    /**
     *
     */
    private static final long serialVersionUID = -2437160791033393978L;

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(Exception e) {
        this(e.getMessage());
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public ServiceException(int code, String message) {
        super(code, message);
    }

    public ServiceException(int code, String message, Object data) {
        super(code, message, data);
    }


    public ServiceException(ResultCodeInterface enumService,String message){
        super(enumService.getCode(),message);
    }
    public ServiceException(ResultCodeInterface enumService,String message,Object data){
        super(enumService.getCode(),enumService.getMesg()+":"+message,data);
    }
}
