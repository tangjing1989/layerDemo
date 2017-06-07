package com.tangjing.web.service;

import com.tangjing.util.CustomException;
import com.tangjing.util.page.PagePojo;
import com.tangjing.web.dao.SysManageDataBaseMapper;
import com.tangjing.web.pojo.RowDef;
import com.tangjing.web.pojo.TablePojo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Describe:
 * User:tangjing
 * Date:2017/4/20
 * Time:下午4:43
 */
@Service
public class SysManageDataBaseImpl implements ISysManageDataBaseImpl {

    @Autowired
    private Environment env;
    @Autowired
    private
    SysManageDataBaseMapper mapper;

    @Autowired
    SysManageDataBaseMapper sysManageDataBaseMapper;

    public PagePojo query(PagePojo pojo) {
        pojo.init(sysManageDataBaseMapper.queryListCount(pojo, env.getProperty("spring.datasource.name")));
        pojo.setDatas(sysManageDataBaseMapper.queryListPage(pojo, env.getProperty("spring.datasource.name")));
        return pojo;
    }

    /**
     * 创建数据库表
     *
     * @param tablePojo
     * @throws CustomException
     */
    public void save(TablePojo tablePojo) throws CustomException {

        if (StringUtils.isEmpty(tablePojo.getTableName()))
            throw new CustomException("表名不能为空");

        List<RowDef> rowDefList = tablePojo.getRowList();
        String[]     sqls       = new String[rowDefList.size()];

        int i = 0;
        for (RowDef row : rowDefList) {
            String temp = null;
            if (StringUtils.isEmpty(row.getRowName()))
                throw new CustomException("字段名称不能为空");
            temp = "`" + row.getRowName() + "` ";
            if (StringUtils.isEmpty(row.getRowType()))
                throw new CustomException("字段类型不能为空");
            temp = temp + row.getRowType() + '(';
            if (row.getRowLength() != 0)
                temp = temp + row.getRowLength();
            temp = temp + ") ";
            if (row.getRowNull().equals(true))
                temp = temp + "not null";
            if (!StringUtils.isEmpty(row.getRowDesc()))
//                temp = temp + "COMMENT \"" + row.getRowDesc()+"\"";

                sqls[i++] = temp;
        }
        String keySql = ",PRIMARY KEY (";
        for (RowDef row : rowDefList) {

        }

        for(int num=0; num<rowDefList.size();num++)
        {
            if (rowDefList.get(num).getRowKey() != null && rowDefList.get(num).getRowKey().equals(true))
                keySql = keySql + "`"+rowDefList.get(num).getRowName()+ "`";
            if(num!=rowDefList.size()-1)
                keySql = keySql + ",";
        }

        keySql = keySql + ")";
        sqls[i-1]=sqls[i-1]+keySql;

        mapper.createTable(tablePojo.getTableName(), sqls, keySql, tablePojo.getTableComment());
    }


}
