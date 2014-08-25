package org.dsns.engine.service.impls;

import org.dsns.common.cache.EhCacheClient;
import org.dsns.engine.service.interfaces.ICollectorSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectorSV implements ICollectorSV {
	@Autowired
	private EhCacheClient ehcacheClient;
	
	@Override
	public void collect() throws Exception {
		ehcacheClient.set("testme", "yeah");
		System.out.println(ehcacheClient.get("testme"));
	}
	
}
