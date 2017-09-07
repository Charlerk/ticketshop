package comlwh.ticketshop.service.impl;

import org.json.JSONObject;

import comlwh.ticketshop.dao.TrainDao;
import comlwh.ticketshop.service.TrainService;


public class TrainServiceImpl  implements TrainService{

	TrainDao  trainDao;
	

	public void setTrainDao(TrainDao trainDao) {
		this.trainDao = trainDao;
	}


	@Override
	public JSONObject[] gettrain(String start, String mid, String end, String startdate) throws Exception {
		// TODO Auto-generated method stub
		return trainDao.gettrain(start, mid, end, startdate);
	}

}
