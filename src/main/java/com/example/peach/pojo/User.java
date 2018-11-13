package com.example.peach.pojo;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "nickname")
    private String nickname;//昵称
    @Column(name = "user_phone")
    private String userphone;//昵称
    @Column(name = "user_realname")
    private String userRealname;//真实姓名
    @Column(name = "user_Birthday")
    private Date userBirthday;//生日
    @Column(name = "sex")
    private Boolean sex;
    @Column(name = "country")
    private String country;
    @Column(name = "province")
    private String province;//省份
    @Column(name = "city")
    private String city;
    @Column(name = "user_address")
    private String userAddress;//地址
    @Column(name = "uset_autograph")
    private String userAutograph;//签名
    @Column(name = "user_occupation")
    private String userOccupation;//职业
    @Column(name = "is_marriage")
    private Boolean isMarriage;//是否
    @Column(name = "user_height")
    private Integer userHeight;
    @Column(name = "user_education")
    private String userEducation;//学历
    @Column(name = "user_salary")
    private String userSalary;//年薪
    @Column(name = "user_interest")
    private String userInterest;//兴趣爱好
    @Column(name = "user_jurisdiction")
    private Boolean userJurisdiction;//会员等级
    @Column(name = "user_idcard")
    private String userIdcard;//身份证
    @Column(name = "headimgurl")
    private String headimgurl;//头像
    @Column(name = "user_integral")
    private Integer userIntegral;//积分
    @Column(name = "openid")
    private String openid;//用户唯一标识


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
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

    public Boolean getUserJurisdiction() {
        return userJurisdiction;
    }

    public void setUserJurisdiction(Boolean userJurisdiction) {
        this.userJurisdiction = userJurisdiction;
    }

    public String getUserIdcard() {
        return userIdcard;
    }

    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard == null ? null : userIdcard.trim();
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
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

    public String getUserphone() {

        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

}