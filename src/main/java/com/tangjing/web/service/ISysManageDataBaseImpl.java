package com.tangjing.web.service;

import com.tangjing.util.CustomException;
import com.tangjing.util.page.PagePojo;
import com.tangjing.web.pojo.TablePojo;

/**
 * Describe:
 * User:tangjing
 * Date:2017/4/20
 * Time:下午4:43
 */

public interface ISysManageDataBaseImpl {
    PagePojo query(PagePojo pojo);

    void save(TablePojo tablePojo) throws CustomException;
}
