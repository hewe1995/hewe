package com.hewe.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_file")
public class FileModel extends BaseModel {
	private String id;
	private String name;
	private String path;
	private Date upTime;
	private int downtimes;
	private UserModel user;
	private String saveName;

	public FileModel() {
	}

	public FileModel(String id, String name, String path, Date upTime, int downtimes, UserModel user, String saveName) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.upTime = upTime;
		this.downtimes = downtimes;
		this.user = user;
		this.saveName = saveName;
	}

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

	@Column(nullable = false)
	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
}
