package com.bock.parameterizedTests;

public class Magazine {

    public Magazine(String title){
        setTitle(title);
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
