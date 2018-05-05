package com.gsw.databasedemo.bo;

import org.litepal.crud.DataSupport;

/**
 *
 * @author gaoshiwei
 * @date 2017/12/8
 */

public class Book extends DataSupport {

    private int id;
    private String name;
    private String author;
    private double price;
    private int page;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
