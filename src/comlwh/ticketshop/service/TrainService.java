package comlwh.ticketshop.service;

import org.json.JSONObject;

public interface TrainService {

	
	JSONObject[]  gettrain(String start,String mid,String end, String startdate) throws Exception;
	
}
