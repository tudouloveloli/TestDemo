package me.microcool.testdemo.bean;

/**
 * 实体类 Fruit
 * fruit_image + fruit_name
 * Created by gaoshiwei on 2017/9/20.
 */

public class Fruit {

    private int imageID;
    private String imagename;

    public Fruit(int imageID, String imagename) {
        this.imageID = imageID;
        this.imagename = imagename;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }
}
