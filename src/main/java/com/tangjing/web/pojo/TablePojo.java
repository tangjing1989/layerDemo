package com.tangjing.web.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * Describe:
 * User:tangjing
 * Date:2017/4/20
 * Time:下午4:44
 */
@Data
public class TablePojo {
    private String       rowNumber;
    private String       tableName;
    private String       tableComment;
    private String       tableType;
    private Long         tableRow;
    private Timestamp    crtDate;
    private Timestamp    uptDate;
    private List<RowDef> rowList;

}


