package com.td.truck.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
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
@TableName("t_links")
public class Links extends Model<Links> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	private String linklogo;
	private String linkurl;
	private String name;
	private Integer sort;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLinklogo() {
		return linklogo;
	}

	public void setLinklogo(String linklogo) {
		this.linklogo = linklogo;
	}

	public String getLinkurl() {
		return linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Links{" +
			"id=" + id +
			", linklogo=" + linklogo +
			", linkurl=" + linkurl +
			", name=" + name +
			", sort=" + sort +
			"}";
	}
}
