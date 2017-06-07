package com.tangjing.web.service.impl;

import com.tangjing.web.pojo.UserTest;
import com.tangjing.web.dao.UserTestMapper;
import com.tangjing.web.service.IUserTestService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yanghu
 * @since 2017-05-25
 */
@Service
public class UserTestServiceImpl extends ServiceImpl<UserTestMapper, UserTest> implements IUserTestService {
	
}
