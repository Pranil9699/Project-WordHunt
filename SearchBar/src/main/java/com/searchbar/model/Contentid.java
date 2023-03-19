package com.searchbar.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
@Embeddable
@Data
public class Contentid implements Serializable {

	private static final long serialVersionUID = 1L;
	private int contentid;
    private int id;
	public int getContentid() {
		return contentid;
	}
	public void setContentid(int contentid) {
		this.contentid = contentid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Contentid(int contentid, int id) {
		super();
		this.contentid = contentid;
		this.id = id;
	}
	public Contentid() {
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
    

}
