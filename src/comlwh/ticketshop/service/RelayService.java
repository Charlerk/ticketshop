package comlwh.ticketshop.service;

import java.io.IOException;

public interface RelayService {

	Integer getGap(String start,String end) throws IOException;
	
	String getRelay(String start,String end,String[] citys) throws Exception;
}
