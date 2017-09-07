<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<html>
	<head>
		<title>火车转车查询页面</title>		
		<link rel="stylesheet" href="/fruitscity/css/styles.css" type="text/css" />		
	</head>
	<body>
	
	
	
	<form action="inqueryinfo?" method="post" name="ufrm">
	

	
	<table width="100%" border="0" cellspacing="0" cellpadding="1" align="center">
							<tr>
								<td  width="170">
									出发地(如：哈尔滨)：
								<td   width="100" style="width: 132px; ">
									<input type="text" name="Departure" style="width:100;">
								</td></td>
								
							
								<td style="width: 200px; ">
									目的地(如：上海)：
								</td>
								<td>
									<input type="text" name="Arrival" style="width:100;">
								</td>
							
							
						     	<td style="width: 217px; ">
								日期(有效且参照2017-9-1)：
								</td>
								<td>
									<input type="text" name="startdate" style="width:90;">
								</td>
							
							
								<td>
									<input type="submit" name="login" value="查询">
								</td>
							
								<td>
									&nbsp;</td>
							
								
							</tr>
							
						
							
							<tr>
								<td colspan="1">
									
								</td>
							</tr>
											
       </table>
							
															
	</form>		
						<br />
						<br />
						<br /><br />
						
			<div style="color:#000000">
			 ATTENTION：<br />
			 1.由于jsoup抓取的网页最大限制是1M，如果车次(如北京-上海)数据太多抓取不完整，会导致json解析出现异常。<br />
			 2.如果将全部省会城市作为备选中转点,需要抓取30多次数据 ，频繁抓取数据会被服务器禁止访问，所以这里只用五个城市代替。<br />
             3.抓取第三方网站数据，响应时间比较长；受网站服务器状态影响还可能会出现请求超时的情况。<br />
             4.不懂前端，做的比较粗糙，凑合看；时间紧张，很多地方还需要改进。              
            </div>		
            
            <br />
            <br />
            <div style="color:#000000">
                        示例结果：
            <br /> <br />
            <img src="./images/example.jpg"  alt="示例：哈尔滨-上海"  />

            </div>		
            
		
	</body>
</html>
