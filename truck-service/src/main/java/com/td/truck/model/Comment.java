package com.td.truck.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
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
@TableName("t_comment")
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    @TableId("fid")
	private Integer id;
	@TableField("fcid")
	private Integer cid;
	@TableField("fcreated")
	private Integer created;
	@TableField("fauthor")
	private String author;
	@TableField("fauthor_id")
	private Integer authorId;
	@TableField("fowner_id")
	private Integer ownerId;
	@TableField("fmail")
	private String mail;
	@TableField("furl")
	private String url;
	@TableField("fip")
	private String ip;
	@TableField("fagent")
	private String agent;
	@TableField("fcontent")
	private String content;
	@TableField("ftype")
	private String type;
	@TableField("fstatus")
	private String status;
	@TableField("fparent")
	private Integer parent;


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

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "Comment{" +
			", id=" + id +
			", cid=" + cid +
			", created=" + created +
			", author=" + author +
			", authorId=" + authorId +
			", ownerId=" + ownerId +
			", mail=" + mail +
			", url=" + url +
			", ip=" + ip +
			", agent=" + agent +
			", content=" + content +
			", type=" + type +
			", status=" + status +
			", parent=" + parent +
			"}";
	}
}
