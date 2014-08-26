package org.dsns.common.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import org.dsns.common.model.page.Page;
import org.hibernate.criterion.Criterion;

public interface IBaseDao<T extends Serializable> {
	public T save(T entity);
	public T saveOrUpdate(T entity);
	public T update(T entity);
	public T merge(T entity);
	public T refresh(T entity);
	public T delete(T entity);
	public T deleteById(Serializable id);
	public T loadById(Serializable id);
	public T loadById(Serializable id, boolean lock);
	public T getById(Serializable id);
	public List<T> findByProp(String propName, Object propValue);
	public List<T> findByCriteria(Criterion... criterions);
	public Page<T> findByCriteriaPaging(int curPageNo, int pageSize, Criterion... criterions);
	public Page<T> findByPropPaging(String propName, Object propValue, int curPageNo, int pageSize);
	public T findUniqueByProp(String propName, Object propValue);
	public List<T> findAll();
	public Page<T> findAllPaging(int curPageNo, int pageSize);
	public List<T> findByHql(String hql, Object... paramValues);
	public Page<T> findByHqlPaging(int curPageNo, int pageSize, String countHql, String qryHql, Object... paramValues);
	public T findUniqueByHql(String hql, Object... paramValues);
}
