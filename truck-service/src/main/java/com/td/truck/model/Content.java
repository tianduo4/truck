package com.td.truck.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
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
 * @since 2017-12-03
 */
@TableName("t_content")
public class Content extends Model<Content> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("allow_comment")
	private Boolean allowComment;
	@TableField("allow_feed")
	private Boolean allowFeed;
	@TableField("allow_ping")
	private Boolean allowPing;
	@TableField("author_id")
	private Long authorId;
	private String categories;
	@TableField("comments_num")
	private Integer commentsNum;
	private String content;
	private Date createdate;
	@TableField("fmt_type")
	private String fmtType;
	private Integer hits;
	private Date modifydate;
	private String slug;
	private String status;
	private String tags;
	@TableField("thumb_img")
	private String thumbImg;
	private String title;
	private String type;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAllowComment() {
		return allowComment;
	}

	public void setAllowComment(Boolean allowComment) {
		this.allowComment = allowComment;
	}

	public Boolean getAllowFeed() {
		return allowFeed;
	}

	public void setAllowFeed(Boolean allowFeed) {
		this.allowFeed = allowFeed;
	}

	public Boolean getAllowPing() {
		return allowPing;
	}

	public void setAllowPing(Boolean allowPing) {
		this.allowPing = allowPing;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public Integer getCommentsNum() {
		return commentsNum;
	}

	public void setCommentsNum(Integer commentsNum) {
		this.commentsNum = commentsNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getFmtType() {
		return fmtType;
	}

	public void setFmtType(String fmtType) {
		this.fmtType = fmtType;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getThumbImg() {
		return thumbImg;
	}

	public void setThumbImg(String thumbImg) {
		this.thumbImg = thumbImg;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Content{" +
			"id=" + id +
			", allowComment=" + allowComment +
			", allowFeed=" + allowFeed +
			", allowPing=" + allowPing +
			", authorId=" + authorId +
			", categories=" + categories +
			", commentsNum=" + commentsNum +
			", content=" + content +
			", createdate=" + createdate +
			", fmtType=" + fmtType +
			", hits=" + hits +
			", modifydate=" + modifydate +
			", slug=" + slug +
			", status=" + status +
			", tags=" + tags +
			", thumbImg=" + thumbImg +
			", title=" + title +
			", type=" + type +
			"}";
	}
}
