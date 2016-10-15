package com.hewe.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_test_contect")
public class TestContect {
	@Id
	private Integer id;
	private Name name;
	private Boolean isOk;
	@Column(name = "timetamp")
	@Temporal(TemporalType.TIME)
	private Date showTime;
}
