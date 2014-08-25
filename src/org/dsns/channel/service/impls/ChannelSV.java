package org.dsns.channel.service.impls;

import java.util.List;
import java.util.Set;

import org.dsns.channel.dao.interfaces.IChannelDao;
import org.dsns.channel.entity.Channel;
import org.dsns.channel.service.interfaces.IChannelSV;
import org.dsns.common.service.impls.BaseSVImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChannelSV extends BaseSVImpl<Channel> implements IChannelSV {
	
	
	
	
	
	
	
	
	@Override
	public void test() {
		List<Channel> brands = findAll();
		
		if (brands != null) {
			for (Channel brand : brands) {
				System.out.println("===parent===" + brand.getName());
				Set<Channel> childs = brand.getChilds();
				if (childs != null) {
					for (Channel child : childs) {
						System.out.println("===child===" + child.getName());
					}
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	@Autowired
	protected void setDao(IChannelDao channelDao) {
		super.setBaseDao(channelDao);
	}
	protected IChannelDao getDao() {
		return (IChannelDao)super.getBaseDao();
	}
}
