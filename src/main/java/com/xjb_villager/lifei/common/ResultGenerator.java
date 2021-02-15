package com.xjb_villager.lifei.common;

import com.xjb_villager.lifei.enums.ResultCode;

/**
 * <pre>
 *   返回结果的封装数据
 * </pre>
 *
 * @param
 * @return
 * @author xjs
 * created by  2021年月02日14:12:06
 */
public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "操作成功！";
    private static final String DEFAULT_ERROR_MESSAGE = "操作失败";

    public static ResultLV genSuccessResult() {
        ResultLV result = new ResultLV();
        result.setData("");
        result.setCode(ResultCode.SUCCESS.code);
        result.setMsg(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static ResultLV genSuccessResult(Object data) {
        ResultLV result = new ResultLV();
        result.setCode(ResultCode.SUCCESS.code);
        result.setMsg(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data == null ? "" : data);
        return result;
    }

    public static ResultLV genFailResult(String message) {
        ResultLV result = new ResultLV();
        result.setCode(ResultCode.FAIL.code);
        result.setData("");
        result.setMsg(message);
        return result;
    }

    public static ResultLV genFailMessageResult(String message) {
        ResultLV result = new ResultLV();
        result.setCode(ResultCode.FAIL.code);
        result.setData("");
        result.setMsg(message);
        return result;
    }

    public static ResultLV genFailResult(Object data) {
        ResultLV result = new ResultLV();
        result.setCode(ResultCode.FAIL.code);
        result.setData(data == null ? "" : data);
        result.setMsg(DEFAULT_ERROR_MESSAGE);
        return result;
    }

    public static ResultLV genSuccessResult(String message) {
        ResultLV result = new ResultLV();
        result.setData("");
        result.setCode(ResultCode.SUCCESS.code);
        result.setMsg(message);
        return result;
    }

    public static ResultLV genResult(int code, String message, Object data) {
        ResultLV result = new ResultLV();
        result.setData(data == null ? "" : data);
        result.setMsg(message);
        result.setCode(code);
        return result;
    }

    public static ResultLV genResult(int code, String message) {
        ResultLV result = new ResultLV();
        result.setData("");
        result.setMsg(message);
        result.setCode(code);
        return result;
    }

    public static ResultLV gen401Result() {
        ResultLV result = new ResultLV();
        result.setData("");
        result.setMsg("登陆失效，请重新登陆");
        result.setCode(ResultCode.UNAUTHORIZED.getCode());
        return result;
    }

}
