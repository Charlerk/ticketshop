package comlwh.ticketshop.util;

import java.util.Arrays;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.aspectj.apache.bcel.classfile.Constant;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;



import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Myutil {

	
	 public static String toHanyuPinyin(String ChineseLanguage){
	        char[] cl_chars = ChineseLanguage.trim().toCharArray();
	        String hanyupinyin = "";
	        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
	        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 输出拼音全部小写
	        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调
	        defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V) ;
	        try {
	            for (int i=0; i<cl_chars.length; i++){
	                if (String.valueOf(cl_chars[i]).matches("[\u4e00-\u9fa5]+")){// 如果字符是中文,则将中文转为汉语拼音
	                    hanyupinyin += PinyinHelper.toHanyuPinyinStringArray(cl_chars[i], defaultFormat)[0];
	                } else {// 如果字符不是中文,则不转换
	                    hanyupinyin += cl_chars[i];
	                }
	            }
	        } catch (BadHanyuPinyinOutputFormatCombination e) {
	            System.out.println("字符不能转成汉语拼音");
	        }
	        return hanyupinyin;
	    }
	 
	  public static int findmost(int[] array){
		   Arrays.sort(array);
		   int lastEle=array[0];
		   int maxTime=0;
		   int presentTime=1;
		   int maxEle=array[0];
		   
		   for(int i=1;i<array.length;i++)
		   {
			   if(array[i]==lastEle)
				   presentTime++;
			   else
			   {
				   if(presentTime>maxTime)
				   {
					   maxTime=presentTime;
					   maxEle=lastEle;
				   }
				   lastEle=array[i];
				   presentTime=1;
			   }
			   
			   if(i==array.length-1 && presentTime>maxTime)//  考虑到比较到最大的元素（排在最后的元素），需要在循环推出前比较一次
			   {
				   maxTime=presentTime;
				   maxEle=lastEle;
			   }   
			   
		   }		   
	//	  System.out.println("出现次数最多的元素"+maxEle+" "+"出现的次数"+maxTime);
		  return maxEle;
	    }
	 
	 
	  public static JSONArray getTrainArray(String start, String end, String startdate) throws Exception
	  {
		  
		  
		  
		  String DepartureCityName = URLEncoder.encode(start , "utf8");  //urlencoded编码的城市名
			String ArrivalCityName = URLEncoder.encode(end , "utf8");	
		
			String DepartureCity=Myutil.toHanyuPinyin(start);  //拼音城市名
			String ArrivalCity=Myutil.toHanyuPinyin(end);
			

			
			
			String url="http://trains.ctrip.com/TrainBooking/Ajax/SearchListHandler.ashx?Action=getSearchList&value={%22IsBus%22:false,%22Filter%22:%220%22,%22Catalog%22:%22%22,%22IsGaoTie%22:false,%22IsDongChe%22:false,%22CatalogName%22:%22%22,%22DepartureCity%22:%22"+DepartureCity+"%22,%22ArrivalCity%22:%22"+ArrivalCity+"%22,%22HubCity%22:%22%22,%22DepartureCityName%22:%22"+DepartureCityName+"%22,%22ArrivalCityName%22:%22"+ArrivalCityName+"%22,%22DepartureDate%22:%22"+startdate+"%22,%22DepartureDateReturn%22:%22%22,%22ArrivalDate%22:%22%22,%22TrainNumber%22:%22%22}";
			   System.out.println(url);
		
			   /*  Document document = Jsoup.connect(url).get(); 
	           String jsonbody = document.text();  
	           org.json.JSONObject jsonObject = new org.json.JSONObject(jsonbody);  
	           JSONArray trainArray = jsonObject.getJSONArray("TrainItemsList"); */
			   Response res = Jsoup.connect(url)
						.header("Accept", "*/*")
						.header("Accept-Encoding", "gzip, deflate")
						.header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
						.header("Content-Type", "application/json;charset=UTF-8")
						.header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
						.timeout(300000).ignoreContentType(true).method(Method.GET).execute();   //.get();  .execute()
				String jsonbody = res.body();
				
			   
			
	           System.out.println("jbody size:"+jsonbody.length());
	           org.json.JSONObject jsonObject = new org.json.JSONObject(jsonbody);  
	           JSONArray trainArray = jsonObject.getJSONArray("TrainItemsList"); 
			   
		  
		return trainArray;
		  
	  }
	 
	 
	 
	 
	 
	
}
