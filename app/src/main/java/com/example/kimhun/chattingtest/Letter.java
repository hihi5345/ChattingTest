package com.example.kimhun.chattingtest;

/**
 * Created by kimhun on 2017-08-19.
 */

public class Letter implements Message {
    private String userName;
    private String message;
    private String type;

    public Letter(String userName, String message){
        this.userName = userName;
        this.message = message;
        this.type = "Letter";
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
