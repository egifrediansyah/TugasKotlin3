package com.android.tugaskotlin3.Model;

public class Menu {

    final private int NO_IMAGE = -1;

    private String homeName;
    public void setType(String type){
        this.type = type;
    }

    private String type;
    private int mImageResouce = NO_IMAGE;
    private int homePrice;
    private String homeDescription;
    public Menu (String homeName, int mImageResouce, int homePrice, String type){
        this.homeName = homeName;
        this.mImageResouce = mImageResouce;
        this.homePrice = homePrice;
        this.type = type;}

    public String getHomeName(){
        return homeName; }

    public String getType(){
        return type; }

    public int getmImageResouce(){
        return mImageResouce; }

    public int getHomePrice(){
        return homePrice; }

    public String getHomeDescription(){
        return homeDescription; }
}
