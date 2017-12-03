package com.td.truck.model;

import java.io.Serializable;

import java.util.Date;
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
 * @since 2017-12-03
 */
@TableName("persistent_logins")
public class PersistentLogins extends Model<PersistentLogins> {

    private static final long serialVersionUID = 1L;

	private String series;
	@TableField("last_used")
	private Date lastUsed;
	private String token;
	private String username;


	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public Date getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	protected Serializable pkVal() {
		return this.series;
	}

	@Override
	public String toString() {
		return "PersistentLogins{" +
			"series=" + series +
			", lastUsed=" + lastUsed +
			", token=" + token +
			", username=" + username +
			"}";
	}
}
