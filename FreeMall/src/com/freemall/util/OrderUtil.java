package com.freemall.util;

import java.util.UUID;


/**
 * 订单工具类
 * @author LFSenior
 *
 *上午9:54:55
 *
 */
public class OrderUtil {
	/**
	 * 通过uuid获取16位的uuid
	 * @return
	 */
	public static  String getOrderNoByUUId() {
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
}
