package com.xjb_villager.lifei.enums;

import com.xjb_villager.lifei.common.ResultCodeInterface;

public enum ResultCode  implements ResultCodeInterface{

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),
    IN_PROCESSING(202, "处理中"),
    LOGIN_FAIL(300, "用户名或密码错误"),
    VERIFICATION_CODE_ERROR(301, "验证码错误"),
    FAIL(400, "操作失败"),
    UNAUTHORIZED(401, "未认证或签名错误"),
    NO_PERMISSION(402, "无访问权限"),
    NOT_FOUND(404, "未找到"),
    PARAMETER_ERROR(405, "参数错误"),
    METHOD_NOT_ALLOWED(406, "请求方法不允许"),
    UNSUPPORTED_MEDIA_TYPE(415, "不支持的媒体类型"),
    EXCEEDS_LIMIT(429, "访问超限请求太多"),
    TOKEN_INVALID(405, "令牌无效"),
    SERVER_EXCEPTION(500, "服务内部异常"),
    ILLEGAL_PARAM(501, "参数错误"),
    BUSINESS_FAIL(502, "业务处理失败"),
    SYSTEM_EXCEPTION_ERROR(503, "系统异常");

    //处理结果码
    public int code;
    //结果描述
    public String msg;

    ResultCode(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getMesg() {
        return ResultCode.valueOf(this.name()).msg;
    }

    @Override
    public int getCode() {

        return ResultCode.valueOf(this.name()).code;
    }

  /*

   或者用这种方式也可以
   public int getdCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }*/


}
