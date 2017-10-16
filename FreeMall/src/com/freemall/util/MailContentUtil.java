package com.freemall.util;

import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.OrderEntry;
import com.freemall.dao.entry.UserEntry;


/**
 * 邮箱content内容工具类
 * @author LFSenior
 *
 *下午4:42:29
 *
 */
public class MailContentUtil {
	public static final String WebUrl="http:172.20.20.2";
	public static String registerContet(UserEntry userEntry){
		String url=WebUrl+"/index";
		String content = "<div>尊敬的"+userEntry.getUserName()+"用户：<br>您好！感谢您注册成为FreeMall用户。<br>请点击下面链接进入主页：<br><a href='"+url+"' target='_blank'>"+url+"</a><br><br>"
				+ "（如果链接无法点击，请将该网址复制并粘贴至浏览器的地址栏中）<br><br>-----------------------------------------<br>此邮箱为系统邮箱，不接收邮件，请勿回复。<br><br>技术支持邮箱：<a href='javascript:;' target='_blank'>wingsgod@<wbr>outlook.com</a><br></div>";
		return content;
	}
	
	
	public static String orderContent(OrderEntry orderEntry){
		String content="";
		content+="<div>";
		content+="<div style='line-height: 22.4px;'>";
		content+="<table width='100%' cellpadding='0' cellspacing='0' border='0'>";
		content+="<tbody>";
		content+="<!--头部-->";
		content+="<tr>";
		content+="<td class='news-text'>尊敬的FreeMall用户：</td>";
		content+="</tr>";
		content+="<tr>";
		content+="<td style=' color: rgb(102, 102, 102);  '><p style='text-indent: 2em;'>您的账户（<span style='border-bottom:1px dashed #ccc;z-index:1'>"+orderEntry.getCreateAuthor()+"</span>）购买了以下商品，正在发货。</p>";
		content+="<p>有1件商品正在发货。</p>";
		content+="<table cellpadding='5' cellspacing='0' border='1' bordercolor='#CCCCCC'>";
		content+="<tbody>";
		content+="<tr>";
		content+="<th>商品名称</th>";
		content+="<th>商品价格</th>";
		content+="<th>商品数量</th>";
		content+="<th>预计到货时间</th>";
		content+="</tr>";
		for(CartEntry cartEntry:orderEntry.getCartEntryList()){
			content+="<tr>";
			content+="<td>"+cartEntry.getProName()+"</td>";
			content+="<td>"+cartEntry.getProPrice()+"</td>";
			content+="<td>"+cartEntry.getProCount()+"</td>";
			content+="<td>"+new java.sql.Date(System.currentTimeMillis())+"</td>";
			content+="</tr>";
		}
		content+="</tbody>";
		content+="</table>";
		content+="<p style='text-indent: 2em;'>现在去查看：<a href='https://172.20.20.2/queryorder' target='_blank'>https://172.20.20.2/queryorder</a>";
		content+="</p>";
		content+="</td>";
		content+="</tr>";
		content+="</tbody>";
		content+="</table>";
		content+="</div>";
		content+="<div class='block' style='line-height: 22.4px;'>";
		content+="<table width='100%' cellpadding='0' cellspacing='0' border='0' id='backgroundTable'>";
		content+="<tr>";
		content+="<td align='center' valign='middle' st-content='preheader' style='  ; ; ; ; ; ; ; ; ; ; '>此为系统邮件，请勿回复 ?<span style='border-bottom:1px dashed #ccc;z-index:1' >2013-2018</span>FreeMall.com版权所有";
		content+="</td>";
		content+="</tr>";
		content+="</table>";
		content+="</div>";
		content+="</div>";
		return content;
	}
	
	
}
