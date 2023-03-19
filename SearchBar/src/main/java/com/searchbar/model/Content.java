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
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Column(length = 1500)
	private String infomation;
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
		return category;
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
	
	public Content(Contentid contentid, User user, String category, String name, Date date,
			String infomation) {
		super();
		this.contentid = contentid;
		this.user = user;
		this.category = category;
		this.name = name;
		this.date = date;
		this.infomation = infomation;
	}
	public Content() {
	}

}
