package com.gsw.widgetsdemos.widget;

/**
 * @author gaoshiwei
 * @date 2017/11/22
 * PersonBO类，为Spinner服务
 */

public class Person {
    private int imageId;
    private String personName;
    private String personAddress;

    public Person(int imageId, String personName, String personAddress) {
        this.imageId = imageId;
        this.personName = personName;
        this.personAddress = personAddress;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
