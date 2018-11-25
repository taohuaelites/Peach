package com.example.peach.pojo;

/**
 * 心仪表
 * Created by Administrator on 2018/11/17.
 */

public class Favorite {

    private int id;//主键
    private int myid;//我的id
    private int youid;//喜欢的人id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMyid() {
        return myid;
    }

    public void setMyid(int myid) {
        this.myid = myid;
    }

    public int getYouid() {
        return youid;
    }

    public void setYouid(int youid) {
        this.youid = youid;
    }
}
