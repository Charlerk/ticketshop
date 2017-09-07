package comlwh.ticketshop.dao.impl;

import java.io.IOException;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import comlwh.ticketshop.dao.TrainDao;
import comlwh.ticketshop.util.Myutil;



public class TrainDaoImpl implements TrainDao {

	

	@Override
	public JSONObject[] gettrain(String start, String mid, String end, String startdate) throws Exception {
		
		
		
		   System.out.println(start+mid+end+startdate);
		
		   
		   
		   
		   JSONArray trainArray1=Myutil.getTrainArray(start, mid, startdate);
		   
	
		   
		   JSONArray trainArray2=Myutil.getTrainArray(mid, end, startdate);
		   
		
		   
		  int[] timeMatrix=new int[trainArray1.length()*trainArray2.length()];
		  int k=0;
		  for(int i=0;i<trainArray1.length();i++)
			  for(int j=0;j<trainArray2.length();j++)
			  {
				  JSONObject singleTrain1 = trainArray1.getJSONObject(i);     
		           String timeStr1 = singleTrain1.getString("UseTime"); 
		           String EndStationName = singleTrain1.getString("EndStationName"); 
		           int timeInt1=Integer.valueOf(timeStr1).intValue();
		           String[] endTimeStr = singleTrain1.getString("EndTime").split(":"); 
		           int endTimeInt=Integer.valueOf(endTimeStr[0]).intValue()*60+Integer.valueOf(endTimeStr[1]).intValue();
		           
		           
		           JSONObject singleTrain2 = trainArray2.getJSONObject(j);     
		           String timeStr2 = singleTrain2.getString("UseTime"); 
		           String StartStationName = singleTrain2.getString("StartStationName"); 
		           int timeInt2=Integer.valueOf(timeStr2).intValue();
		           String[] startTimeStr= singleTrain2.getString("StratTime").split(":"); 
		           int startTimeInt=Integer.valueOf(startTimeStr[0]).intValue()*60+Integer.valueOf(startTimeStr[1]).intValue();
		           
		           if(startTimeInt-endTimeInt>30  && EndStationName.equals(StartStationName))
		        	   timeMatrix[k++]=timeInt1+timeInt2+startTimeInt-endTimeInt;
		           else
		        	   if(startTimeInt-endTimeInt<0 && EndStationName.equals(StartStationName))
		        		   timeMatrix[k++]=timeInt1+timeInt2+startTimeInt+24*60-endTimeInt;	    
		        	   else
		        		   timeMatrix[k++]=0;        		   
			  }
		  
		  
				  	
		  int cols=trainArray2.length();
		  JSONObject[] ansJson=new JSONObject[trainArray1.length()*trainArray2.length()*2];
		  k=0;
		  
		  
		  for(int i=0;i<timeMatrix.length;i++)
		  {
			  int min=timeMatrix[0];
			  int minIndex=0;
			  for(int j=0;j<timeMatrix.length;j++)
			  {
				  if(( min==0 && timeMatrix[j]>0)|| (min>timeMatrix[j] && timeMatrix[j]>0))
				  {
					  min=timeMatrix[j];
					  minIndex=j;
				  }
			  }
			  int row=  minIndex/cols;
			  int col=minIndex%cols;
			
			  ansJson[k++]=trainArray1.getJSONObject(row);
			  ansJson[k++]=trainArray2.getJSONObject(col);	  
			  timeMatrix[minIndex]=0;			  			  			  			  
		  }
		  
		  
	
			  
		  
		  
		  
		  
		  
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
			/*String DepartureCityName = URLEncoder.encode(start , "utf8");  //urlencoded编码的城市名
			String ArrivalCityName = URLEncoder.encode(end , "utf8");	
		
			String DepartureCity=Myutil.toHanyuPinyin(start);  //拼音城市名
			String ArrivalCity=Myutil.toHanyuPinyin(end);
			

			
			
			String url="http://trains.ctrip.com/TrainBooking/Ajax/SearchListHandler.ashx?Action=getSearchList&value={%22IsBus%22:false,%22Filter%22:%220%22,%22Catalog%22:%22%22,%22IsGaoTie%22:false,%22IsDongChe%22:false,%22CatalogName%22:%22%22,%22DepartureCity%22:%22"+DepartureCity+"%22,%22ArrivalCity%22:%22"+ArrivalCity+"%22,%22HubCity%22:%22%22,%22DepartureCityName%22:%22"+DepartureCityName+"%22,%22ArrivalCityName%22:%22"+ArrivalCityName+"%22,%22DepartureDate%22:%22"+startdate+"%22,%22DepartureDateReturn%22:%22%22,%22ArrivalDate%22:%22%22,%22TrainNumber%22:%22%22}";
			   System.out.println(url);
			try {

		           Document document = Jsoup.connect(url).get();
		           String jsonbody = document.text();                  
		           org.json.JSONObject jsonObject = new org.json.JSONObject(jsonbody);   
		           JSONArray trainArray = jsonObject.getJSONArray("TrainItemsList"); 
		            
		           for (int i = 0; i < trainArray.length(); i++) { 
		           JSONObject singleTrain = trainArray.getJSONObject(i);     
		           String name = singleTrain.getString("TrainName");     
		           System.out.println(name);
		           } 
			 } 
			 catch (IOException e) {
		            e.printStackTrace();
		        }
			*/
			

		

		
		return ansJson;
	}
	

}
