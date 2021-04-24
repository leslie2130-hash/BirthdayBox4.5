package com.example.bottomnavigationdemo;

public class Gift {
    private String name;
    private String title;
    private String info;
    private int pictureId;

    public Gift(String name, String title, String info, int pictureId) {
        this.name = name;
        this.title = title;
        this.info = info;
        this.pictureId = pictureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public int getPictureId() {
        return pictureId;
    }
}
