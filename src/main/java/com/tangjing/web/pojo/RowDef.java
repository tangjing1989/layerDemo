package com.tangjing.web.pojo;

import lombok.Data;

/**
 * Describe:
 * User:tangjing
 * Date:2017/4/24
 * Time:下午12:23
 */

@Data
public class RowDef {
    private String  rowName;
    private String  rowDesc;
    private String  rowType;
    private int     rowLength;
    private Boolean rowKey;
    private Boolean rowNull;

    public RowDef() {
        this.rowNull = false;
        this.rowKey = false;
    }
}