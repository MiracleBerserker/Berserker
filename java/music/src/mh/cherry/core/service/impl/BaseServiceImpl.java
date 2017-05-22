package mh.cherry.core.service.impl;

import java.io.Serializable;
import java.util.List;

import mh.cherry.core.dao.BaseDao;
import mh.cherry.core.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T>{
	private BaseDao<T> baseDao;
    
	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void save(T entity) {
           baseDao.save(entity);		
	}

	@Override
	public void update(T entity) {
		baseDao.update(entity);
	}

	@Override
	public void delete(Serializable id) {
		baseDao.delete(id);
	}

	@Override
	public List<T> getAll() {
		
		return baseDao.getAll();
	}

	@Override
	public T findObjectById(Serializable id) {
		return baseDao.findObjectById(id);
	}

}
