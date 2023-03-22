package com.searchbar.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table
@Data
public class Content {

	@EmbeddedId
	private Contentid contentid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;
	@Column(length = 10)
	private String category;
	@Column(length = 30)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date date;

	@Column
	private String title;
	@Column
	private String link;
	@Column(length = 750)
	private String description;

	@Column(length = 10000)
	private String infomation;

	public Content(Contentid contentid, User user, String category, String name, Date date, String title, String link,
			String description, String infomation) {
		super();
		this.contentid = contentid;
		this.user = user;
		this.category = category;
		this.name = name;
		this.date = date;
		this.title = title;
		this.link = link;
		this.description = description;
		this.infomation = infomation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Contentid getContentid() {
		return contentid;
	}

	public void setContentid(Contentid contentid) {
		this.contentid = contentid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCategory() {
	    return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfomation() {
		return infomation;
	}

	public void setInfomation(String infomation) {
		this.infomation = infomation;
	}

	public Content() {
	}

}
