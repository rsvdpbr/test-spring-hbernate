package com.ryonishikawa.bbs.model.schema;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentSchema {

	@Id
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "article_id")
	private ArticleSchema article;

	@Column(name = "posted_at")
	private Date posted_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArticleSchema getArticle() {
		return article;
	}

	public void setArticle(ArticleSchema article) {
		this.article = article;
	}

	public Date getPosted_at() {
		return posted_at;
	}

	public void setPosted_at(Date posted_at) {
		this.posted_at = posted_at;
	}

}
