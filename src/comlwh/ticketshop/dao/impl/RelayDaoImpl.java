package comlwh.ticketshop.dao.impl;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sun.mail.iap.Response;

import comlwh.ticketshop.dao.RelayDao;
import comlwh.ticketshop.util.Myutil;

public class RelayDaoImpl implements RelayDao {

	@Override
	public Integer getGap(String start, String end) throws IOException {
      
		String DepartureCityName = URLEncoder.encode(start , "GBK");  //urlencoded编码的城市名
		String ArrivalCityName = URLEncoder.encode(end , "GBK");	
		Random rand = new Random();
		int rand1= rand.nextInt(100);
		int rand2= rand.nextInt(100);
		String url="http://search.huochepiao.com/chaxun/result.asp?txtChuFa="+DepartureCityName+"&txtDaoDa="+ArrivalCityName+"&sz.x="+rand1+"&sz.y="+rand2;			

						
		    
			    Document doc = Jsoup.connect(url).get();			    
		        Elements elements1 = doc.select("tbody").get(8).select("tr");
			    int[]  gapArray=new int[elements1.size()];
			   			    
			    for (int i = 0; i < elements1.size(); i++) {		    	
			    	String td = elements1.get(i).select("td").get(7).text();	
			   
			    	gapArray[i]=(int)Double.parseDouble(td);
			    }
				
	   //	System.out.println(start+"到"+end+"最可能距离"+Myutil.findmost(gapArray));
	   return Myutil.findmost(gapArray);
	}

	@Override
	public String getRelay(String start, String end, String[] citys) throws Exception {
		int minlength=100000;
		String mincity = null;
			
		
		for(String ele:citys)
		{	
			if(ele.equals(start) || ele.equals(end))
				continue;
			int tmp=getGap(start,ele)+getGap(ele,end);
			System.out.println("中转站："+ele+"  第一段:"+getGap(start,ele)+"   第二段:"+getGap(ele,end)+"  和："+tmp);
			
			if(minlength>tmp)
			{
				minlength=tmp;	
				mincity=ele;
			}
		}
			
		
		return mincity;
	}

	

}
