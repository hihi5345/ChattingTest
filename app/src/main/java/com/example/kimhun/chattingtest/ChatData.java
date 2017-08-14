package com.example.kimhun.chattingtest;

/**
 * Created by kimhun on 2017-08-14.
 */

public class ChatData {
    private String userName;
    private String message;

    public ChatData(){}
    public ChatData(String userName, String message){
        this.userName = userName;
        this.message = message;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
