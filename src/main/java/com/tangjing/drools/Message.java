package com.tangjing.drools;

/**
 * Describe:
 * User:tangjing
 * Date:2017/3/31
 * Time:下午4:16
 */

public class Message {
    public static final int HELLO = 0;
    public static final int GOODBYE = 1;

    private String message;
    private String Msg;

    private int status;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static int getHELLO() {
        return HELLO;
    }

    public static int getGOODBYE() {
        return GOODBYE;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
}
