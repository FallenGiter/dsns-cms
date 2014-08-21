package org.dsns.common.dao.impls;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.dsns.common.beans.page.Page;
import org.dsns.common.dao.interfaces.IBaseDao;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class BaseDaoImpl<T extends Serializable> implements IBaseDao<T> {
	@Autowired
	protected SessionFactory sessionFactory;
	
	public T save(T entity) {
		Assert.notNull(entity);
		Session s = this.getSession();
		s.save(entity);
		s.flush();
		
		return entity;
	}
	
	@Override
	public T saveOrUpdate(T entity) {
		Assert.notNull(entity);
		this.getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		Assert.notNull(entity);
		this.getSession().update(entity);
		return entity;
	}

	@Override
	public T merge(T entity) {
		Assert.notNull(entity);
		this.getSession().merge(entity);
		return entity;
	}

	@Override
	public T refresh(T entity) {
		Assert.notNull(entity);
		this.getSession().refresh(entity);
		return entity;
	}

	@Override
	public T delete(T entity) {
		Assert.notNull(entity);
		this.getSession().delete(entity);
		return entity;
	}

	@Override
	public T deleteById(Serializable id) {
		Assert.notNull(id);
		T o = this.loadById(id);
		this.getSession().delete(o);
		return o;
	}

	@Override
	public T loadById(Serializable id) {
		Assert.notNull(id);
		return this.loadById(id, false);
	}

	@Override
	public T loadById(Serializable id, boolean lock) {
		Assert.notNull(id);
		T entity = null;
		if (lock) {
			entity = (T) getSession().load(this.getPersistentClass(), id, LockMode.UPGRADE);
		} else {
			entity = (T) getSession().load(this.getPersistentClass(), id);
		}
		return entity;
	}

	@Override
	public T getById(Serializable id) {
		Assert.notNull(id);
		return (T) this.getSession().get(this.getPersistentClass(), id);
	}

	@Override
	public List<T> findByProp(String propName, Object propValue) {
		Assert.hasText(propName);
		return this.createCriteria(Restrictions.eq(propName, propValue)).list();
	}
	
	@Override
	public Page<T> findByPropPaging(String propName, Object propValue, int curPageNo, int pageSize) {
		Assert.hasText(propName);
		
		if (curPageNo <= 0 || pageSize <= 0) {
			return new Page(0, 0, 0);
		} else {
			Criteria ctr = this.createCriteria(Restrictions.eq(propName, propValue));
			long totalRowCount = (Integer) ctr.setProjection(Projections.rowCount()).uniqueResult();
			Page<T> page = new Page<T>(curPageNo, pageSize, totalRowCount);
			
			ctr.setProjection(null);
			ctr.setResultTransformer(Criteria.ROOT_ENTITY);
			
			if (totalRowCount > 0) {
				page.setCurPageRows(
					ctr.setFirstResult(page.getFirstResult())
					.setMaxResults(page.getPageSize())
					.list()
				);
			}
			
			return page;
		}
	}

	@Override
	public T findUniqueByProp(String propName, Object propValue) {
		Assert.hasText(propName);
		return (T) createCriteria(Restrictions.eq(propName, propValue)).setMaxResults(1).uniqueResult();
	}

	@Override
	public List<T> findAll() {
		return this.createCriteria().list();
	}
	
	@Override
	public Page<T> findAllPaging(int curPageNo, int pageSize) {
		if (curPageNo <= 0 || pageSize <= 0) {
			return new Page(0, 0, 0);
		} else {
			Criteria ctr = this.createCriteria();
			long totalRowCount = (Integer) ctr.setProjection(Projections.rowCount()).uniqueResult();
			Page<T> page = new Page<T>(curPageNo, pageSize, totalRowCount);
			
			ctr.setProjection(null);
			ctr.setResultTransformer(Criteria.ROOT_ENTITY);
			
			if (totalRowCount > 0) {
				page.setCurPageRows(
					ctr.setFirstResult(page.getFirstResult())
					.setMaxResults(page.getPageSize())
					.list()
				);
			}
			
			return page;
		}
	}
	
	@Override
	public List<T> findByHql(String hql, Object... paramValues) {
		Assert.hasText(hql);
		return this.createQuery(hql, paramValues).list();
	}
	
	@Override
	public T findUniqueByHql(String hql, Object... paramValues) {
		Assert.hasText(hql);
		return (T) this.createQuery(hql, paramValues).setMaxResults(1).uniqueResult();
	}
	
	@Override
	public Page<T> findByHqlPaging(int curPageNo, int pageSize, String countHql, String qryHql, Object... paramValues) {
		Assert.hasText(countHql);
		Assert.hasText(qryHql);
		if (curPageNo <= 0 || pageSize <= 0) {
			return new Page(0, 0, 0);
		} else {
			Query count = this.createQuery(countHql, paramValues);
			long totalRowCount = (Long) count.uniqueResult();
			Page<T> page = new Page<T>(curPageNo, pageSize, totalRowCount);

			if (totalRowCount > 0) {
				Query qry = this.createQuery(qryHql, paramValues);
				
				qry.setFirstResult((curPageNo - 1) * pageSize);
				qry.setMaxResults(pageSize);
				
				page.setCurPageRows(qry.list());
			}
			
			return page;
		}
	}
	
	@Override
	public List<T> findByCriteria(Criterion... criterions) {
		return this.createCriteria(criterions).list();
	}

	@Override
	public Page<T> findByCriteriaPaging(int curPageNo, int pageSize, Criterion... criterions) {
		if (curPageNo <= 0 || pageSize <= 0) {
			return new Page(0, 0, 0);
		} else {
			Criteria ctr = this.createCriteria(criterions);
			long totalRowCount = (Integer) ctr.setProjection(Projections.rowCount()).uniqueResult();
			Page<T> page = new Page<T>(curPageNo, pageSize, totalRowCount);
			
			ctr.setProjection(null);
			ctr.setResultTransformer(Criteria.ROOT_ENTITY);
			
			if (totalRowCount > 0) {
				page.setCurPageRows(
					ctr.setFirstResult(page.getFirstResult())
					.setMaxResults(page.getPageSize())
					.list()
				);
			}
			
			return page;
		}
	}

	protected Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(this.getPersistentClass());
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		criteria.setCacheable(true);
		return criteria;
	}
	
	protected Query createQuery(String qryStr, Object... values) {
		Query qryO = getSession().createQuery(qryStr);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				qryO.setParameter(i, values[i]);
			}
		}
		qryO.setCacheable(true);
		return qryO;
	}

	protected Class<T> persistentClass;
	public BaseDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
}
