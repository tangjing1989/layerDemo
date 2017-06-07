package com.tangjing.web.mp.pojo;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author test
 * @since 2017-06-02
 */
public class TemplateFunction extends Model<TemplateFunction> {

    private static final long serialVersionUID = 1L;

    @TableId("TEMPLATEID")
	private Integer templateid;
	@TableField("TEMPLATENAME")
	private String templatename;
	@TableField("TEMPLATEDESC")
	private String templatedesc;
	@TableField("CRTDATE")
	private Date crtdate;
	@TableField("UPDDATE")
	private Date upddate;


	public Integer getTemplateid() {
		return templateid;
	}

	public TemplateFunction setTemplateid(Integer templateid) {
		this.templateid = templateid;
		return this;
	}

	public String getTemplatename() {
		return templatename;
	}

	public TemplateFunction setTemplatename(String templatename) {
		this.templatename = templatename;
		return this;
	}

	public String getTemplatedesc() {
		return templatedesc;
	}

	public TemplateFunction setTemplatedesc(String templatedesc) {
		this.templatedesc = templatedesc;
		return this;
	}

	public Date getCrtdate() {
		return crtdate;
	}

	public TemplateFunction setCrtdate(Date crtdate) {
		this.crtdate = crtdate;
		return this;
	}

	public Date getUpddate() {
		return upddate;
	}

	public TemplateFunction setUpddate(Date upddate) {
		this.upddate = upddate;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.templateid;
	}

}
