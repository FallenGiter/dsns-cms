package org.dsns.common.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

public class EhCacheClient {
	
	public void set(Object key, Object value) {
		cache.put(new Element(key, value));
	}
	
	public void set(Object key, Object value, long version) {
		cache.put(new Element(key, value, version));
	}
	
	public Object get(Object key) {
		Element e = cache.get(key);
		return e == null ? null : e.getObjectValue();
	}
	
	
	
	
	
	
	
	private Cache cache;
	public void setCache(Cache cache) {
		this.cache = cache;
	}
}
