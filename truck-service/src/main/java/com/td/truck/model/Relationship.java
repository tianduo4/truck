package com.td.truck.model;

import java.io.Serializable;

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
@TableName("t_relationship")
public class Relationship extends Model<Relationship> {

    private static final long serialVersionUID = 1L;

    @TableId("fid")
	private Integer id;
	@TableField("fcid")
	private Integer cid;
	@TableField("fmid")
	private Integer mid;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Relationship{" +
			", id=" + id +
			", cid=" + cid +
			", mid=" + mid +
			"}";
	}
}
