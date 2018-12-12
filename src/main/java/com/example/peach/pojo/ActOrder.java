package com.example.peach.pojo;


import java.util.List;

/**
<<<<<<< HEAD
 * Created by Administrator on 2018/11/17.
 */
public class ActOrder {
    private Integer id;
    private Integer activityId;
    private List<Activity> activityList;
    private Integer userId;
    private  List<User> userList;
    private String orderNumber;
    private Integer status;
    private  Integer signIn;
=======
 * 活动单
 * Created by Administrator on 2018/11/17.
 */
public class ActOrder {
    private Integer id;//主键
    private Integer activityId;//活动id
    private Integer userId;//用户id
    private String orderNumber;//单号
    private Integer status;//状态
    private List<Activity> activityList;//活动表集合
    private  List<User> userList;//用户集合
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
<<<<<<< HEAD

    public Integer getSignIn() {
        return signIn;
    }

    public void setSignIn(Integer signIn) {
        this.signIn = signIn;
    }
=======
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259
}