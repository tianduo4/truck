package com.td.truck.enums;

/**
 * Created by babyant on 17/4/12.
 */
public enum MetaType {

    TAGS("tags", 1), CATEGORY("category", 2), LINKS("links", 3);


    private String name ;
    private int index ;

    private MetaType(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

}
