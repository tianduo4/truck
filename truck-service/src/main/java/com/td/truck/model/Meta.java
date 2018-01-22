package com.td.truck.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("t_meta")
public class Meta extends Model<Meta> {

    private static final long serialVersionUID = 1L;

	@TableId(value="fid", type= IdType.AUTO)
	private Integer id;
	@TableField("fname")
	private String name;
	@TableField("fslug")
	private String slug;
	@TableField("ftype")
	private String type;
	@TableField("fdescription")
	private String description;
	@TableField("fsort")
	private Integer sort;
	@TableField("fparent")
	private Integer parent;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Meta{" +
			", id=" + id +
			", name=" + name +
			", slug=" + slug +
			", type=" + type +
			", description=" + description +
			", sort=" + sort +
			", parent=" + parent +
			"}";
	}
}
