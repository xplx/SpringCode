package cn.com.pers.server.serverImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.com.pers.mapper.LoginMapper;
import cn.com.pers.model.Login;
import cn.com.pers.server.LoginServer;

@Service
public class LoginServerImpl implements LoginServer {
	Logger logger = Logger.getLogger(LoginServerImpl.class);

	@Resource
	private LoginMapper loginM;

	@Override
	public Map<String, Object> login(String username, String password) {
		Map<String, Object> map = new HashMap<>();
		// 对应的是持久层
		Login login = new Login();
		try {
			// login.setUsername("wxp");
			// login.setPassword("123456");
			login = loginM.selectUser(username);
			if (!(username.equals(login.getUsername()))) {
				map.put("usernaem", "usernaem error");
				logger.debug("用户名错误");
				return map;
			}

			if (!(password.equals(login.getPassword()))) {
				logger.debug("密码错误");
				map.put("password", "password error");
				return map;
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("登录失败"+e);
			
		}
		map.put("success", login);
		logger.debug("登录成功");
		return map;
	}

}
