package cn.com.pers.support;

import cn.com.pers.utils.AESEncoder;

/**
 * @author wxp
 * @date 2018年1月15日 下午5:04:36
 * @Description: TODO(解密数据库配置信息)
 */
public class PrivateDataSource extends com.alibaba.druid.pool.DruidDataSource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void setUsername(String username) {
		super.setUsername(new AESEncoder().decrypt(username));
	}

	@Override
	public void setPassword(String password) {
		super.setPassword(new AESEncoder().decrypt(password));
	}
}
