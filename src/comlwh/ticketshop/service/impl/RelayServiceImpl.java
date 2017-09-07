package comlwh.ticketshop.service.impl;

import java.io.IOException;

import comlwh.ticketshop.dao.RelayDao;
import comlwh.ticketshop.service.RelayService;

public class RelayServiceImpl implements RelayService{
	
	RelayDao relayDao;


	public void setRelayDao(RelayDao relayDao) {
		this.relayDao = relayDao;
	}

	@Override
	public Integer getGap(String start, String end) throws IOException {
		
		return relayDao.getGap(start, end);
	}

	@Override
	public String getRelay(String start, String end, String[] citys) throws Exception {
		return relayDao.getRelay(start, end, citys);
	}

}
