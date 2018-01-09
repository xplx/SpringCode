package cn.com.pers.server.serverImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import cn.com.pers.mapper.LoginMapper;
import cn.com.pers.model.Login;
import cn.com.pers.server.LoginServer;

@Service
public class LoginServerImpl implements LoginServer {
	//注意选择包
	//Logger logger = Logger.getLogger(LoginServerImpl.class);
	static Logger logger = LogManager.getLogger(LoginServerImpl.class.getName());

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
			logger.info("登录失败"+e);
			logger.error("登录失败"+e);
			map.put("success", "登录失败");
			return map;
		}
		map.put("success", login);
		logger.debug("登录成功");
		return map;
	}

}
