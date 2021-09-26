package com.sinovatio.fishing.net;

/**
 * @author zjp1002038
 */
public class Resource<T> {

    public Resource(T data,int code,String message) {

    }

    private T data;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
