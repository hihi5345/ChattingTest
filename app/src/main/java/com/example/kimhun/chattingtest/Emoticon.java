package com.example.kimhun.chattingtest;

/**
 * Created by kimhun on 2017-08-26.
 */

public class Emoticon implements Message {

    private String userName;
    private String emoticonURL;
    private String type;

    public Emoticon(String userName, String emotionURL){
        this.userName = userName;
        this.emoticonURL = emotionURL;
        type = "emoticon";
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getMessage() {
        return emoticonURL;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void setMessage(String emoticonURL) {
        this.emoticonURL = emoticonURL;
    }
}
