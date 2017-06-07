package com.tangjing.util.interceptor;

import java.util.Date;

/**
 * Describe:
 * User:tangjing
 * Date:2017/3/21
 * Time:下午5:22
 */

public class UserlogModel {
    public int    userLogID;
    public int    userId;
    public String userName;
    public String userIp;
    public String url;
    public String channel;
    public String action;
    public String title;
    public String errorMessage;
    public Date   logCrt;
    public String requestParam;

    public int getUserLogID() {
        return userLogID;
    }

    public void setUserLogID(int userLogID) {
        this.userLogID = userLogID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getLogCrt() {
        return logCrt;
    }

    public void setLogCrt(Date logCrt) {
        this.logCrt = logCrt;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }


    @Override
    public String toString() {
        return "UserlogModel{" +
                "userLogID=" + userLogID +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userIp='" + userIp + '\'' +
                ", url='" + url + '\'' +
                ", channel='" + channel + '\'' +
                ", action='" + action + '\'' +
                ", title='" + title + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", logCrt=" + logCrt +
                ", requestParam='" + requestParam + '\'' +
                '}';
    }
}
