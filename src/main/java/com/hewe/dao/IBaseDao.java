package com.hewe.dao;

import java.io.Serializable;
import java.util.Map;

import com.hewe.domain.IBaseModel;

public interface IBaseDao<T extends IBaseModel, PK extends Serializable> {
	public void add(T t);

	public T find(PK p);

	public Boolean isExit(String name);

	public void update(T t);

	public void delete(T t);

	public int getTotalRecord(Map<String, Object> map);
}
