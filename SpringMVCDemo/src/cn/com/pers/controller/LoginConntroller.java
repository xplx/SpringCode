package cn.com.pers.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.pers.model.Login;
import cn.com.pers.server.LoginServer;
import cn.com.pers.utils.JSONUtil;

@Controller
public class LoginConntroller {

	private static Logger logger = Logger.getLogger(LoginConntroller.class);
	/** 日志 */
	// private static Logger logger = LogManager.getLogger(LoginConntroller.class.getName());
	// 注入
	@Resource
	private LoginServer loginServer;

	/**
	 * 返回json示例
	 *
	 * @return
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request) {
		// 返回值
		Map<String, Object> map = new HashMap<>();
		String parm = request.getParameter("parm");
		 // 参数转换Json2Bean
		try {
			Login login = JSONUtil.toBean(parm, Login.class);
			
			String password = login.getPassword();
			String username = login.getUsername();
			map = loginServer.login(username, password);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("错误"+e);
			e.printStackTrace();
			logger.debug("错误"+e);
		}
        
		return map;
	}
}
