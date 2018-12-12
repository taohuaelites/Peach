package com.example.peach.pojo;

import java.sql.Date;

public class User {
    private Integer id;//主键id
    private String nickName;//昵称
    private String userRealname;//真实姓名
    private Date userBirthday;//生日
    private String userphone;//手机号
    private Integer userage;//年龄
    private Boolean sex; //性别
    private String country;//国家
    private String province;//省份
    private String city;//市
    private String userAddress;//地址
    private String userAutograph;//个性签名
    private String userOccupation;//职业
    private Boolean isMarriage;//婚否
    private Integer userHeight;//身高
    private String userEducation;//学历
    private String userSalary;//薪资
    private String userInterest;//兴趣爱好
    private Integer userJurisdiction;//会员等级
    private String userIdcard;//身份证
    private String avatarUrl;//头像
    private Integer userIntegral;//积分
    private String openid;//用户唯一标识
    private  Boolean isrealname;//是否实名验证
    private String usernative;//籍贯
    private String unionid;
    private  String userMarrytime;//期望结婚时间
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname == null ? null : userRealname.trim();
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserAutograph() {
        return userAutograph;
    }

    public void setUserAutograph(String userAutograph) {
        this.userAutograph = userAutograph == null ? null : userAutograph.trim();
    }

    public String getUserOccupation() {
        return userOccupation;
    }

    public void setUserOccupation(String userOccupation) {
        this.userOccupation = userOccupation == null ? null : userOccupation.trim();
    }

    public Boolean getIsMarriage() {
        return isMarriage;
    }

    public void setIsMarriage(Boolean isMarriage) {
        this.isMarriage = isMarriage;
    }

    public Integer getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(Integer userHeight) {
        this.userHeight = userHeight;
    }

    public String getUserEducation() {
        return userEducation;
    }

    public void setUserEducation(String userEducation) {
        this.userEducation = userEducation == null ? null : userEducation.trim();
    }

    public String getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(String userSalary) {
        this.userSalary = userSalary == null ? null : userSalary.trim();
    }

    public String getUserInterest() {
        return userInterest;
    }

    public void setUserInterest(String userInterest) {
        this.userInterest = userInterest == null ? null : userInterest.trim();
    }

    public Integer getUserJurisdiction() {
        return userJurisdiction;
    }

    public void setUserJurisdiction(Integer userJurisdiction) {
        this.userJurisdiction = userJurisdiction;
    }

    public String getUserIdcard() {
        return userIdcard;
    }

    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard == null ? null : userIdcard.trim();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public Integer getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(Integer userIntegral) {
        this.userIntegral = userIntegral;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Boolean getMarriage() {
        return isMarriage;
    }

    public void setMarriage(Boolean marriage) {
        isMarriage = marriage;
    }

    public Boolean getIsrealname() {
        return isrealname;
    }

    public void setIsrealname(Boolean isrealname) {
        this.isrealname = isrealname;
    }

    public String getUsernative() {
        return usernative;
    }

    public void setUsernative(String usernative) {
        this.usernative = usernative;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getUserMarrytime() {
        return userMarrytime;
    }

    public void setUserMarrytime(String userMarrytime) {
        this.userMarrytime = userMarrytime;
    }
}