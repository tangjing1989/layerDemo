package com.tangjing.web.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Describe:
 * User:tangjing
 * Date:17/1/10
 * Time:下午4:19
 */
@Data
public class UserPojo {

    private String    rowNumber;        //行号
    private int       userId;
    private String    userName;
    private String    userCode;
    private String    password;
    private Timestamp crtDate;
    private Timestamp uptDate;
}

