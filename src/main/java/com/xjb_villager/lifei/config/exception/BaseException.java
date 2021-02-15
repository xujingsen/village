package com.xjb_villager.lifei.config.exception;
/**
 * <pre>
 *   自定义异常类
 * </pre>
 *
 * @param
 * @return
 * @author xjs
 * created by  2021年02月04日09:12:06
 */
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BaseException extends RuntimeException{
/**
 * 异常代码
 */
private  int code;
    /**
     * 异常消息
     */
    private String message;
    /**
     * 错误返回数据
     */
    private Object data;
    /**
     *
     */
    private static final long serialVersionUID = 7859712770754900356L;

    public BaseException(String msg){
        super(msg);

    }
    public BaseException(Exception e){
        this(e.getMessage());
    }
    public BaseException(String message,Throwable cause){
        super(message,cause);
    }
    public BaseException(int code,String message,Throwable cause){
        super(message,cause);
        this.code = code;
        this.message = message;
    }
    public BaseException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException(int code, String message,Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
