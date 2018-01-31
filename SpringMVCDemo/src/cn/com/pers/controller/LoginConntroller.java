package cn.com.pers.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.pers.model.Login;
import cn.com.pers.server.LoginServer;
import cn.com.pers.utils.JSONUtil;

@Controller
public class LoginConntroller {

	// private static Logger logger = Logger.getLogger(LoginConntroller.class);
	/** 日志 */
	private static Logger logger = LogManager.getLogger(LoginConntroller.class.getName());
	// 注入
	@Resource
	private LoginServer loginServer;

	/**
	 * 返回json示例,用于app请求
	 *
	 * @return
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request) {
		logger.info("登录开始");
		// 返回值
		Map<String, Object> map = new HashMap<>();
		// 使用json
		String parm = request.getParameter("parm");
		// 参数转换Json2Bean
		try {
			Login login = JSONUtil.toBean(parm, Login.class);
			String password = login.getPassword();
			String username = login.getUsername();
			// 使用get方式
			// String username = request.getParameter("username");
			// String password = request.getParameter("password");
			map = loginServer.login(username, password);
			logger.info("登录结束");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("错误" + e);
			e.printStackTrace();
			logger.debug("错误" + e);
		}

		return map;
	}

	@RequestMapping(value = "/tologin")
	public String toLogin(Model model) {
		logger.info("跳转到登录页开始");
		model.addAttribute("modelKey", "modelValue");
		return "login";
	}

}
