package cn.com.pers.controller;

import org.apache.log4j.Logger;

/** 
* @author wxp  
* @date 2018年1月4日 上午9:02:30 
* @Description: TODO(这里使用APP的接口，使用的是一个接口调用不同的类型) 
*/
public class AppConntroller {
	public String executeService(String type, String message) {
		Logger log = Logger.getLogger(AppConntroller.class);
		int dataType = 0;
		String result = null;
		switch (dataType) {
		case 1002:// 获取服务器时间
			// 增加业务逻辑
			log.info(dataType + "," + result);
			break;
		}
		return result;
	}
}
