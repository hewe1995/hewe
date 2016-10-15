package com.hewe.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_file")
public class FileModel extends BaseModel {
	private String id;
	private String name;
	private String path;
	private Date upTime;
	private int downtimes;
	private UserModel user;

	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Id
	public String getId() {
		return id;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	@Column(nullable = false)
	public String getPath() {
		return path;
	}

	@Column(nullable = false)
	public Date getUpTime() {
		return upTime;
	}

	@Column(nullable = false)
	public int getDowntimes() {
		return downtimes;
	}

	@ManyToOne
	@JoinColumn(nullable = false)
	public UserModel getUser() {
		return user;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}

	public void setDowntimes(int downtimes) {
		this.downtimes = downtimes;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
}
