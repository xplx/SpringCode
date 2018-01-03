package cn.com.pers.server;

import java.util.Map;

public interface LoginServer {
	// 用户登录
	public Map<String, Object> login(String username, String password);
}
