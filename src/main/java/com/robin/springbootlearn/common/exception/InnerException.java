package com.robin.springbootlearn.common.exception;

import com.robin.springbootlearn.common.enums.ResponseCodeEnum;

/**
 * @author silkNets
 * @program springboot-learn
 * @description 内部异常类，异常信息不展示给用户。会在全局异常中进行脱敏处理
 * @createDate 2020-03-03 08:14
 */
public class InnerException extends RuntimeException {

    private ResponseCodeEnum responseCode;

    public InnerException() {
    }

    public InnerException(String message) {
        super(message);
    }

    public InnerException(ResponseCodeEnum resultCode, String message) {
        super(message);
        this.responseCode = resultCode;
    }

    public InnerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InnerException(Throwable cause) {
        super(cause);
    }

    public InnerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ResponseCodeEnum getResultCode() {
        return responseCode;
    }
}