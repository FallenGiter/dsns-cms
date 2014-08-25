package org.dsns.channel.dao.impls;

import org.dsns.channel.dao.interfaces.IChannelDao;
import org.dsns.channel.entity.Channel;
import org.dsns.common.dao.impls.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class ChannelDao extends BaseDaoImpl<Channel> implements IChannelDao {
	
}
