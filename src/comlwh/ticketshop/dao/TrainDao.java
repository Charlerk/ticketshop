package comlwh.ticketshop.dao;

import net.sf.json.JSONObject;

public interface TrainDao {
	
	org.json.JSONObject[]  gettrain(String start,String mid,String end,String startdate) throws Exception;



}
