package com.example.kimhun.chattingtest;

/**
 * Created by kimhun on 2017-08-25.
 */

public class Image implements Message {

    private String userName;
    private String imageURL;
    private String type;

    public Image(String userName, String imageURL){
        this.userName = userName;
        this.imageURL = imageURL;
        this.type = "image";
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getMessage() {
        return imageURL;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void setMessage(String imageURL) {
        this.imageURL = imageURL;
    }
}
