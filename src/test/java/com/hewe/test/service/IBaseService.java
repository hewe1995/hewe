package com.hewe.test.service;

import java.io.Serializable;

import com.hewe.test.model.IBaseModel;

public interface IBaseService<T extends IBaseModel, PK extends Serializable> {
	public void add(T t);

	public T find(PK p);

	public Boolean isExit(String name);

	public void update(T t);

	public void delete(T t);
}
