package com.alfazid.siasd.utilities;

/**
 * Created by cigist on 05/08/19.
 */
public class RestError {
    private boolean status;
    private int code;
    private String message;

    public RestError() {
    }

    public RestError(boolean status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

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
}
