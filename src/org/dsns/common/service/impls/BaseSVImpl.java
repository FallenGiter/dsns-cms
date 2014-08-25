package org.dsns.common.service.impls;

import java.io.Serializable;
import java.util.List;

import org.dsns.common.beans.page.Page;
import org.dsns.common.dao.interfaces.IBaseDao;
import org.dsns.common.service.interfaces.IBaseSV;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseSVImpl<T extends Serializable> implements IBaseSV<T> {
	protected IBaseDao<T> baseDao;

	
	public T save(T entity) {
		return (T) this.baseDao.save(entity);
	}

	public T saveOrUpdate(T entity) {
		return (T) this.baseDao.saveOrUpdate(entity);
	}

	public T update(T entity) {
		return (T) this.baseDao.update(entity);
	}

	public T merge(T entity) {
		return (T) this.baseDao.merge(entity);
	}

	public T refresh(T entity) {
		return (T) this.baseDao.refresh(entity);
	}

	public T delete(T entity) {
		return (T) this.baseDao.delete(entity);
	}

	public T deleteById(Serializable id) {
		return (T) this.baseDao.deleteById(id);
	}

	public T loadById(Serializable id) {
		return (T) this.baseDao.loadById(id);
	}

	public T loadById(Serializable id, boolean lock) {
		return (T) this.baseDao.loadById(id, lock);
	}

	public T getById(Serializable id) {
		return (T) this.baseDao.getById(id);
	}

	public List<T> findByProp(String propName, Object propValue) {
		return (List<T>) this.baseDao.findByProp(propName, propValue);
	}

	public T findUniqueByProp(String propName, Object propValue) {
		return (T) this.baseDao.findUniqueByProp(propName, propValue);
	}

	public List<T> findAll() {
		return (List<T>) this.baseDao.findAll();
	}
	
	@Override
	public Page<T> findByPropPaging(String propName, Object propValue, int curPageNo, int pageSize) {
		return this.baseDao.findByPropPaging(propName, propValue, curPageNo, pageSize);
	}

	@Override
	public Page<T> findAllPaging(int curPageNo, int pageSize) {
		return this.baseDao.findAllPaging(curPageNo, pageSize);
	}

	protected void setBaseDao(IBaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	
	protected IBaseDao<T> getBaseDao() {
		return this.baseDao;
	}
}
