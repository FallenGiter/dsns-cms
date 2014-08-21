package org.dsns.common.service.interfaces;

import java.io.Serializable;
import java.util.List;

import org.dsns.common.beans.page.Page;

public interface IBaseSV<T extends Serializable> {
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
	public Page<T> findByPropPaging(String propName, Object propValue, int curPageNo, int pageSize);
	public T findUniqueByProp(String propName, Object propValue);
	public List<T> findAll();
	public Page<T> findAllPaging(int curPageNo, int pageSize);
}
