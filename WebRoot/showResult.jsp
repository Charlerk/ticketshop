<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
 <%@page import="org.json.JSONObject"%>
 <%@page import="org.json.JSONException"%>
  <%@page import="org.json.JSONArray"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>转车查询结果</title>



</head>
<body>
  
   
   
   <table  id="table" onclick=sortColumn(event) border="0" bgcolor="#0033cc" cellspacing="1" cellpadding="0" width="99%" align="center">
<THEAD><tr bgcolor="#ffffff"><td height="18" align="center"><a href=#>车次</a></td>
<td align="center"><a href=#>出发站</a></td><td align="center"><a href=#>开车时间</a></td><td align="center"><a href=#>到达站</a></td><td align="center"><a href=#>到达时间</a></td><td align="center"><a href=#>用时</a></td><td align="center"><a href=#>硬座价/余</a></td><td align="center"><a href=#>无座价/余</a></td><td align="center"><a href=#>硬卧价/余</a></td><td align="center"><a href=#>软卧价/余</a></td>
 <td align="center"><a href=#>二等座价/余</a></td> <td align="center"><a href=#>一等座价/余</a></td><td align="center"><a href=#>特等座价/余</a></td><td align="center"><a href=#>商务座价/余</a></td><td align="center"><a href=#>高级软卧价/余</a></td><td align="center"><a href=#>动卧价/余</a></td>    </tr></THEAD>


<tbody>

<%
  ArrayList<JSONObject> list=new ArrayList<JSONObject>();
  JSONObject[] ansJson=(JSONObject[]) request.getAttribute("ansJson");
 for (int i = 0; i < ansJson.length && ansJson[i]!=null; i+=2) { 
        JSONObject singleTrain = ansJson[i];
        list.add(singleTrain);
        String IsStartStation=singleTrain.getString("IsStartStation");
        String IsEndStation=singleTrain.getString("IsEndStation");   
        String transferInfo;    
         JSONArray SeatBookingItem = singleTrain.getJSONArray("SeatBookingItem");
         String isStartStr="";
         String isEndStr="";
         if(IsStartStation.equals("true"))
            isStartStr="http://search.huochepiao.com/images/qshi.gif";
         else
            isStartStr="http://search.huochepiao.com/images/guo.gif";
         
      
         
         String yingZuoPrice="-";
         String yingZuoLeft="-";
         String yingWoPrice="-";
         String yingWoLeft="-";
         String ruanWoPrice="-";
         String ruanWoLeft="-";
         String wuZuoPrice="-";
         String wuZuoLeft="-";
         String deng2Price="-";
         String deng2Left="-";
         String deng1Price="-";
         String deng1Left="-";
         String dengTePrice="-";
         String dengTeLeft="-";
         String shangWuPrice="-";
         String shangWuLeft="-";
         String gaoRuanPrice="-";
         String gaoRuanLeft="-";
         String dongWoPrice="-";
         String dongWoLeft="-";
         
         
          for (int j = 0; j < SeatBookingItem.length(); j++) 
          { 
		           JSONObject seat = SeatBookingItem.getJSONObject(j);     
		           String name = seat.getString("SeatTypeId");  //test
		           int SeatTypeId=Integer.valueOf(seat.getString("SeatTypeId")).intValue();
		           switch(SeatTypeId)
		           {
		               case 201:   yingZuoPrice=seat.getString("Price");  yingZuoLeft=seat.getString("Inventory");break;
		               case 224:   yingWoPrice=seat.getString("Price");   yingWoLeft=seat.getString("Inventory");break;
		               case 225:   ruanWoPrice=seat.getString("Price");  ruanWoLeft=seat.getString("Inventory");break;
		               case 227:   wuZuoPrice=seat.getString("Price");   wuZuoLeft=seat.getString("Inventory");break;
		               case 209:   deng2Price=seat.getString("Price");  deng2Left=seat.getString("Inventory");break;
		               case 207:   deng1Price=seat.getString("Price");  deng1Left=seat.getString("Inventory");break;
		               case 205:   dengTePrice=seat.getString("Price");  dengTeLeft=seat.getString("Inventory");break;
		               case 221:   shangWuPrice=seat.getString("Price");  shangWuLeft=seat.getString("Inventory");break;
		               case 226:   gaoRuanPrice=seat.getString("Price");  gaoRuanLeft=seat.getString("Inventory");break;
		               case 304:   dongWoPrice=seat.getString("Price");  dongWoLeft=seat.getString("Inventory");break;
		           }
		          
		           
		  } 
                              
 %>

<tr id="tr0" bgcolor="#4EFEB3"  > 


<td align="center" height="20"><a href="/checi/G5"><%= singleTrain.getString("TrainName") %></a></td>
<td align="center"><img  src=<%= isStartStr %> border="0"><%= singleTrain.getString("StartStationName") %></td>
<td align="center"><%=  singleTrain.getString("StratTime") %></td>
<td align="center"><%= singleTrain.getString("EndStationName") %></td>
<td align="center"><%= singleTrain.getString("EndTime") %></td>
<td align="center"><%= singleTrain.getString("TakeTime") %></td>
<td align="center"><%=yingZuoPrice%>/<%=yingZuoLeft%></td>
<td align="center"><%=yingWoPrice%>/<%=yingWoLeft%></td>
<td align="center"><%=ruanWoPrice%>/<%=ruanWoLeft%></td>
<td align="center"><%=wuZuoPrice%>/<%=wuZuoLeft%></td>
<td align="center"><%=deng2Price%>/<%=deng2Left%></td>
<td align="center"><%=deng1Price%>/<%=deng1Left%></td>
<td align="center"><%=dengTePrice%>/<%=dengTeLeft%></td>
<td align="center"><%=shangWuPrice%>/<%=shangWuLeft%></td>
<td align="center"><%=gaoRuanPrice%>/<%=gaoRuanLeft%></td>
<td align="center"><%=dongWoPrice%>/<%=dongWoLeft%></td>
</tr>






<%


 JSONObject singleTrain1 = ansJson[i+1];
        list.add(singleTrain);
        String IsStartStation1=singleTrain1.getString("IsStartStation");
        String IsEndStation1=singleTrain1.getString("IsEndStation");   
        String transferInfo1;    
         JSONArray SeatBookingItem1 = singleTrain1.getJSONArray("SeatBookingItem");
         String isStartStr1="";
         String isEndStr1="";
         if(IsStartStation1.equals("true"))
            isStartStr1="http://search.huochepiao.com/images/qshi.gif";
         else
            isStartStr1="http://search.huochepiao.com/images/guo.gif";
         
         
         
        
       
            
		           String timeStr1 = singleTrain.getString("UseTime"); 
		           int timeInt1=Integer.valueOf(timeStr1).intValue();
		           String[] endTimeStr = singleTrain.getString("EndTime").split(":"); 
		           String  midCity = singleTrain.getString("EndStationName"); 
		           int endTimeInt=Integer.valueOf(endTimeStr[0]).intValue()*60+Integer.valueOf(endTimeStr[1]).intValue();
		           
		           
		             
		           String timeStr2 = singleTrain1.getString("UseTime"); 
		           int timeInt2=Integer.valueOf(timeStr2).intValue();
		           String[] startTimeStr= singleTrain1.getString("StratTime").split(":"); 
		           int startTimeInt=Integer.valueOf(startTimeStr[0]).intValue()*60+Integer.valueOf(startTimeStr[1]).intValue();
		           
		           int gapTime;
		           if(startTimeInt>endTimeInt)
		        	   gapTime=startTimeInt-endTimeInt;
		           else    	   
		        	   gapTime=startTimeInt+24*60-endTimeInt;
		           int allTime=gapTime+timeInt1+timeInt2;	
		           int allHour=allTime/60;
		           int allMin=allTime%60;  
		           transferInfo=midCity+"换乘停留"+gapTime+"分钟，全程"+allHour+"小时"+allMin+"分钟";
		             		        	                 
      
         
         
         
         
         
         
         
         String yingZuoPrice1="-";
         String yingZuoLeft1="-";
         String yingWoPrice1="-";
         String yingWoLeft1="-";
         String ruanWoPrice1="-";
         String ruanWoLeft1="-";
         String wuZuoPrice1="-";
         String wuZuoLeft1="-";
         String deng2Price1="-";
         String deng2Left1="-";
         String deng1Price1="-";
         String deng1Left1="-";
         String dengTePrice1="-";
         String dengTeLeft1="-";
         String shangWuPrice1="-";
         String shangWuLeft1="-";
         String gaoRuanPrice1="-";
         String gaoRuanLeft1="-";
         String dongWoPrice1="-";
         String dongWoLeft1="-";
         
         
          for (int j = 0; j < SeatBookingItem1.length(); j++) 
          { 
		           JSONObject seat = SeatBookingItem1.getJSONObject(j);     
		           String name = seat.getString("SeatTypeId");  //test
		           int SeatTypeId=Integer.valueOf(seat.getString("SeatTypeId")).intValue();
		           switch(SeatTypeId)
		           {
		               case 201:   yingZuoPrice1=seat.getString("Price");  yingZuoLeft1=seat.getString("Inventory");break;
		               case 224:   yingWoPrice1=seat.getString("Price");   yingWoLeft1=seat.getString("Inventory");break;
		               case 225:   ruanWoPrice1=seat.getString("Price");  ruanWoLeft1=seat.getString("Inventory");break;
		               case 227:   wuZuoPrice1=seat.getString("Price");   wuZuoLeft1=seat.getString("Inventory");break;
		               case 209:   deng2Price1=seat.getString("Price");  deng2Left1=seat.getString("Inventory");break;
		               case 207:   deng1Price1=seat.getString("Price");  deng1Left1=seat.getString("Inventory");break;
		               case 205:   dengTePrice1=seat.getString("Price");  dengTeLeft1=seat.getString("Inventory");break;
		               case 221:   shangWuPrice1=seat.getString("Price");  shangWuLeft1=seat.getString("Inventory");break;
		               case 226:   gaoRuanPrice1=seat.getString("Price");  gaoRuanLeft1=seat.getString("Inventory");break;
		               case 304:   dongWoPrice1=seat.getString("Price");  dongWoLeft1=seat.getString("Inventory");break;
		           }
		          
		           
		  } 

 %>





<tr id="tr1" bgcolor="#4EFEB3" > 


<td align="center" height="20"><a href="/checi/G5"><%= singleTrain1.getString("TrainName") %></a></td>
<td align="center"><img  src=<%= isStartStr1 %> border="0"><%= singleTrain1.getString("StartStationName") %></td>
<td align="center"><%=  singleTrain1.getString("StratTime") %></td>
<td align="center"><%= singleTrain1.getString("EndStationName") %></td>
<td align="center"><%= singleTrain1.getString("EndTime") %></td>
<td align="center"><%= singleTrain1.getString("TakeTime") %></td>
<td align="center"><%=yingZuoPrice1%>/<%=yingZuoLeft1%></td>
<td align="center"><%=yingWoPrice1%>/<%=yingWoLeft1%></td>
<td align="center"><%=ruanWoPrice1%>/<%=ruanWoLeft1%></td>
<td align="center"><%=wuZuoPrice1%>/<%=wuZuoLeft1%></td>
<td align="center"><%=deng2Price1%>/<%=deng2Left1%></td>
<td align="center"><%=deng1Price1%>/<%=deng1Left1%></td>
<td align="center"><%=dengTePrice1%>/<%=dengTeLeft1%></td>
<td align="center"><%=shangWuPrice1%>/<%=shangWuLeft1%></td>
<td align="center"><%=gaoRuanPrice1%>/<%=gaoRuanLeft1%></td>
<td align="center"><%=dongWoPrice1%>/<%=dongWoLeft1%></td>
</tr>



<tr id="tr2" bgcolor="#FFD2D2" > 
<td colspan=2 align="center">转车信息</td>
 <td colspan=15><%=transferInfo %></td><!--colspan=3 跨3列 --> 

</tr>


<%
 
}

 %>


</tbody>



</table>


</body>
</html>