package com.raneem.javapro;

import android.net.Uri;

public class slide {
String title;
    String fipath;

    public slide(){}

    public slide(String title, String fipath) {
        this.title = title;
        this.fipath = fipath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFipath() {
        return fipath;
    }

    public void setFipath(String fipath) {
        this.fipath = fipath;
    }
}
