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
@TableName("t_option")
public class Option extends Model<Option> {

    private static final long serialVersionUID = 1L;

	@TableId(value="fid", type= IdType.AUTO)
	private Integer id;
	@TableField("fname")
	private String name;
	@TableField("fvalue")
	private String value;
	@TableField("fdescription")
	private String description;


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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Option{" +
			", id=" + id +
			", name=" + name +
			", value=" + value +
			", description=" + description +
			"}";
	}
}
