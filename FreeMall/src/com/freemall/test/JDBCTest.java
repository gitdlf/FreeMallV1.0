package com.freemall.test;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.OrderEntry;
import com.freemall.dao.entry.PageBean;
import com.freemall.dao.entry.UserEntry;
import com.freemall.dao.imp.AddOrderDao;
import com.freemall.dao.imp.GetHotKeywordDao;
import com.freemall.dao.imp.GetIndexBannerDao;
import com.freemall.dao.imp.GetIndexCateDao;
import com.freemall.dao.imp.GetProByProIdDao;
import com.freemall.dao.imp.GetProductByChildCateDao;
import com.freemall.dao.imp.InitIndexContentDao;
import com.freemall.dao.imp.LoginDao;
import com.freemall.dao.imp.ProInfomationDao;
import com.freemall.dao.imp.QueryAllOrderDao;
import com.freemall.dao.imp.QueryCartByOrderNoDao;
import com.freemall.dao.imp.QueryOrderByStateDao;
import com.freemall.dao.imp.RegisterDao;
import com.freemall.dao.imp.SearchDao;
import com.freemall.service.init.InitContentService;
import com.freemall.util.JDBCUtil;

public class JDBCTest {
	@Test
	public void test1(){
		System.out.println(JDBCUtil.getConnection());
	}
	
	@Test
	public void test2(){
		UserEntry userEntry=new UserEntry();
		userEntry.setUserName("张三");
		userEntry.setUserPwd("123456");
		System.out.println(new LoginDao().login(userEntry));
		System.out.println(userEntry);
	}
	@Test
	public void test3(){
		//注册测试
		UserEntry userEntry=new UserEntry();
		userEntry.setUserName("我的天啊");
		userEntry.setUserPwd("123456789");
		System.out.println(new RegisterDao().register(userEntry));
	}
	
	@Test
	public void test4(){
		System.out.println(new GetIndexCateDao().getIndexCateNav().get(0));
	}
	
	@Test
	public void test5(){
		System.out.println(new ProInfomationDao().getProInfomation("299"));
	}
	@Test
	public void test6(){
		List<GoodsEntry> contentGoods = new InitIndexContentDao().getContentGoods("2");
		System.out.println(contentGoods.size());
	}
	@Test
	public void test7(){
		System.out.println(new InitContentService().getIndexContentList("./src/com/freemall/test/indexContentConfig.xml"));
	}
	
	@Test
	public void test8(){
		System.out.println(new GetIndexBannerDao().getBannerDate("./src/com/freemall/test/indexBannerConfig.xml").size());
	}
	
	@Test
	public void test9(){
		System.out.println(new GetProductByChildCateDao().getTotalCount(341));
	}
	
	@Test
	public void test10(){
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(13);
		List<GoodsEntry> productChild = new GetProductByChildCateDao().getProductChild(2, pageBean);
		for (GoodsEntry goodsEntry : productChild) {
			System.out.println(goodsEntry.getSaleNum());
		}
		System.out.println(pageBean.getTotalPage());
		System.out.println(productChild.size());
	}
	
	@Test
	public void test11(){
		System.out.println(Math.ceil((double)59/20));
	}
	
	@Test
	public void test12(){
		System.out.println(new SearchDao().getTotalCount("华为"));
	}
	
	@Test
	public void test13(){
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(12);
		List<GoodsEntry> productChild = new SearchDao().getGoodsBySearch("华为", pageBean);
		for (GoodsEntry goodsEntry : productChild) {
			System.out.println(goodsEntry.getGoodsId());
		}
		System.out.println(pageBean.getTotalPage());
		System.out.println(productChild.size());
	}

	@Test
	public void test14(){
		List<String> hotKeywordDate = new GetHotKeywordDao().getHotKeywordDate("./src/com/freemall/test/hotKeyWordsConfig.xml");
		for (String string : hotKeywordDate) {
			System.out.println(string);
		}
	}
	
	
	
	@Test
	public void test15(){
		List<OrderEntry> allOrder = new QueryAllOrderDao().getAllOrder(21);
		for (OrderEntry orderEntry : allOrder) {
			System.out.println(orderEntry);
		}
	}
	@Test
	public void test16(){
		List<CartEntry> queryCartByOrderNo = new QueryCartByOrderNoDao().queryCartByOrderNo("15700763932");
		for (CartEntry cartEntry : queryCartByOrderNo) {
			System.out.println(cartEntry);
		}
	}
	
	
	@Test
	public void test17(){
		List<OrderEntry> orderByState = new QueryOrderByStateDao().getOrderByState(1, 1);
		for (OrderEntry orderEntry : orderByState) {
			System.out.println(orderEntry);
		}
	}
	
	public  String getOrderIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0     
        // 4 代表长度为4     
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }
	@Test
    public  void test18() {
        for(int i=0;i<10;i++){
        	System.out.println(getOrderIdByUUId());
        }
    }
	
	@Test
	public void test19(){
		OrderEntry orderEntry=new OrderEntry();
		//orderid,orderno,statusname,userid,createauthor,address
		orderEntry.setOrderNo("157123456");
		orderEntry.setStatusName(2);
		orderEntry.setUserId(1);
		orderEntry.setCreateAuthor("lfseniors");
		orderEntry.setAddress("154781asdfsdf");
		System.out.println(new AddOrderDao().addOrder(orderEntry));
	}
	
	
	@Test
	public void test20(){
		OrderEntry orderEntry=new OrderEntry();
		//orderid,orderno,statusname,userid,createauthor,address
		orderEntry.setOrderNo("123321");
		orderEntry.setStatusName(2);
		orderEntry.setUserId(1);
		orderEntry.setCreateAuthor("lfseniors");
		orderEntry.setAddress("154781asdfsdf");
		String[] strs={"5","4"};
		orderEntry.setCartIdList(strs);
		orderEntry.setUserId(21);
		System.out.println(new AddOrderDao().addOrder(orderEntry));
	}
	
	
	@Test
	public void test21(){
		System.out.println(new GetProByProIdDao().getProByProId("258"));
	}
}
