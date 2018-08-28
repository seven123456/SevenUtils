package com.seven.java_module.info;

/**
 * Created  on 2018/8/21 0021.
 * author:seven
 * email:seven2016s@163.com
 */
public class JavaHomeInfos {
    public JavaHomeInfos(String itemName,int type) {
        this.itemName = itemName;
        this.type = type;
    }

    private int type;
    private String itemName;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
