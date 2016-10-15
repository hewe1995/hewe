package com.hewe.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ����ʹ�ùؼ�����Ϊ�ֶ���
 * 
 * @author HEWE 2016��10��14��
 */
@Entity
@Table(name = "t_global")
public class GlobalModel {
	@Id
	private String id;
	@Column(name = "\"update\"")
	private String update;
	@Column(name = "\"insert\"")
	private String insert;
	@Column(name = "\"select\"")
	private String select;
}
