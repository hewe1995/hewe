package com.hewe.web.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class RegisterForm {

	private static final Logger log = Logger.getLogger(RegisterForm.class);

	@NotNull(message = "must not null")
	@Size(min = 4, max = 10, message = "length illegal")
	private String username;
	@Email
	@NotEmpty
	private String email;

	@Past
	@NotNull
	private Date birth;

	@NotEmpty
	private String sex;
	@NotEmpty(message = "password must not null")
	private String password;
	private Map<String, String> sexes;

	public Date getBirth() {
		return birth;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getSex() {
		return sex;
	}

	public Map<String, String> getSexes() {
		if (this.sexes == null) {
			sexes = new HashMap<String, String>();
			sexes.put("man", "男");
			sexes.put("woman", "女");
		}
		log.debug("get sexes");
		return sexes;
	}

	public String getUsername() {
		return username;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setSexes(Map<String, String> sexes) {
		log.debug("set sexes");
		this.sexes = sexes;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
