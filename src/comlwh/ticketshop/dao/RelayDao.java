package comlwh.ticketshop.dao;

import java.io.IOException;

public interface RelayDao {

	Integer getGap(String start,String end) throws IOException;
	
	String getRelay(String start,String end,String[] citys) throws Exception;
}
