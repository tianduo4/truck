package com.td.truck.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("user_role")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

	@TableField("user_id")
	private Long userId;
	@TableField("roles_id")
	private Long rolesId;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRolesId() {
		return rolesId;
	}

	public void setRolesId(Long rolesId) {
		this.rolesId = rolesId;
	}

	@Override
	protected Serializable pkVal() {
		return this.userId+""+this.getRolesId();
	}

	@Override
	public String toString() {
		return "UserRole{" +
			"userId=" + userId +
			", rolesId=" + rolesId +
			"}";
	}
}
