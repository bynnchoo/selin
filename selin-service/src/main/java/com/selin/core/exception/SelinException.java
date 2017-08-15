package com.selin.core.exception;

/**
 * Created by zhenglt on 2017/8/15.
 */
public class SelinException extends RuntimeException {

    private String errorCode;

    public SelinException(String message){
        super(message);
    }

    public SelinException(String message,String errorCode){
        super(message);
        this.errorCode = errorCode;
    }

}
