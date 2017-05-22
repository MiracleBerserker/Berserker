package mh.cherry.core.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {

	void save(T entity);
	void update(T entity);
	void delete(Serializable id);
	List<T> getAll();
	T findObjectById(Serializable id);
	
}
