package com.chimemoo.whatsappcloneui.model;

public class ChatModel {
    private String name, time, lastMessage;
    private int picture, id;

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public int getPicture() {
        return picture;
    }

    public int getId() {
        return id;
    }
}
