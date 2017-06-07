package com.tangjing.web.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yanghu
 * @since 2017-05-25
 */
public class UserTest extends Model<UserTest> {

    private static final long serialVersionUID = 1L;

	private Integer userId;
	private String userName;
	private String userText;


	public Integer getUserId() {
		return userId;
	}

	public UserTest setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public UserTest setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getUserText() {
		return userText;
	}

	public UserTest setUserText(String userText) {
		this.userText = userText;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

}
