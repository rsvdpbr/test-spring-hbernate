package com.ryonishikawa.bbs.model.schema;

//import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "articles")
// public class ArticleSchema implements Serializable {
public class ArticleSchema {

	public ArticleSchema() {
	}

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "body")
	private String body;

	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "article")
	private List<CommentSchema> comments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public List<CommentSchema> getComments() {
		return comments;
	}

	public void setComments(List<CommentSchema> comments) {
		this.comments = comments;
	}

}
