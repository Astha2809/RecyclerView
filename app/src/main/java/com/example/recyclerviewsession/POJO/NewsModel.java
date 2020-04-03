package com.example.recyclerviewsession.POJO;

public class NewsModel {
    public static final int IMAGE_ONLY=0;
    public static final int IMAGE_TEXT=1;
    public static final int TEXT_ONLY=2;
    public int type;
    int images;
    String heading;
    String subheading;
    String time;


    public NewsModel(int type, int images, String heading, String subheading, String time) {
        this.type = type;
        this.images = images;
        this.heading = heading;
        this.subheading = subheading;
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSubheading() {
        return subheading;
    }

    public void setSubheading(String subheading) {
        this.subheading = subheading;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
