package com.td.truck.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author King
 * @since 2017-12-14
 */
@TableName("t_log")
public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

    @TableId("fid")
	private Integer id;
	@TableField("faction")
	private String action;
	@TableField("fdata")
	private String data;
	@TableField("fuser_id")
	private Integer userId;
	@TableField("fip")
	private String ip;
	@TableField("fcreate_time")
	private Date createTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Log{" +
			", id=" + id +
			", action=" + action +
			", data=" + data +
			", userId=" + userId +
			", ip=" + ip +
			", createTime=" + createTime +
			"}";
	}
}
