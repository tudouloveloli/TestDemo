package me.microcool.baseadapterdemo;

/**
 * Created by gaoshiwei on 2017/9/27.
 */

public class ItemBean {
    private int imageResourceID; //图片资源id
    private String title;   //标题
    private String content; //内容

    public ItemBean(int imageResourceID, String title, String content) {
        this.imageResourceID = imageResourceID;
        this.title = title;
        this.content = content;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public String getTitle() {
        return title;
    }


    public String getContent() {
        return content;
    }


}
