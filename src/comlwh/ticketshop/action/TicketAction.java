package comlwh.ticketshop.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.opensymphony.xwork2.ActionSupport;
import comlwh.ticketshop.service.RelayService;
import comlwh.ticketshop.service.TrainService;
import comlwh.ticketshop.util.Myutil;

public class TicketAction   extends ActionSupport implements RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Departure;
	private String Arrival;
	private String startdate;
	  
	RelayService relayservice;
	TrainService trainservice;
	

	Map<String, Object> request;
	

	public void setRequest(Map<String, Object> request) {
		this.request=request;		
	}
	

	public void setTrainservice(TrainService trainservice) {
		this.trainservice = trainservice;
	}


	public void setRelayservice(RelayService relayservice) {
		this.relayservice = relayservice;
	}


	public String getDeparture() {
		return Departure;
	}


	public void setDeparture(String departure) {
		Departure = departure;
	}




	public String getArrival() {
		return Arrival;
	}




	public void setArrival(String arrival) {
		Arrival = arrival;
	}




	public String getStartdate() {
		return startdate;
	}




	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String selectCity() throws Exception
	{
		/*String[] citys={"����","�Ϻ�","���","����","������","����","����","�Ͼ�","����","�Ϸ�","ʯ��ׯ","֣��","�人","��ɳ",
				"�ϲ�","����","̫ԭ","�ɶ�","����","����","����","����","����","����","����","����","���ͺ���","����",
				"��³ľ��","����","����"};*/
		String[] citys={"����","�Ϻ�","���","����","������"};//�򻯵���ת����
		
		String str=relayservice.getRelay(Departure, Arrival, citys);
		request.put("relay", str);
		System.out.println("ѡ����ת���У�");
		System.out.println(str);
		
		
		return "selecttrain";
	}
	
		
	public String selectTrain() throws JSONException, Exception
	{
				
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String mid=(String) request.getAttribute("relay");			   
		System.out.println("start");
		System.out.println(Departure);
		System.out.println("mid");
		System.out.println(request.getAttribute("relay"));	
		System.out.println("end");
		System.out.println(Arrival);		
		System.out.println(startdate);			
		 JSONObject[] ansJson=trainservice.gettrain(Departure, mid, Arrival,startdate);
		 this.request.put("ansJson", ansJson);		 	
		return "showResult";
	}
	
	
	
	
}
