package com.tangjing.web.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Describe:
 * User:tangjing
 * Date:2017/5/20
 * Time:上午9:22
 */
@Data
public class TemplatePojo {
    private int       templateId;
    private String    templateName;
    private String    templateDesc;
    private Timestamp crtDate;
    private Timestamp updDate;
}
