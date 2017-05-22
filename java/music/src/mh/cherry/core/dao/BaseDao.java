package mh.cherry.core.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
  List<T> getAll();
  T findObjectById(Serializable id);
  void save(T entity);
  void update(T entity);
  void delete(Serializable id);
}
