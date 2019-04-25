package com.jack.testphoto.bean;

import java.io.Serializable;
import java.util.List;

public class ImageListBean implements Serializable {
    private int id;
    private String title;
    private List<String> img_urls;

    public ImageListBean(int id, String title, List<String> img_urls) {
        this.id = id;
        this.title = title;
        this.img_urls = img_urls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImg_urls() {
        return img_urls;
    }

    public void setImg_urls(List<String> img_urls) {
        this.img_urls = img_urls;
    }
}