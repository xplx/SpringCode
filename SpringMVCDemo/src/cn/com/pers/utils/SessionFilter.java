package cn.com.pers.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author wxp
 * @date 2017年12月8日 下午2:26:12
 * @Description: TODO(拦截器)
 */
public class SessionFilter implements Filter {

	// 日志
	private static Logger logger = LogManager.getLogger(SessionFilter.class.getName());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 返回值初期化
		Map<String, Object> map = new HashMap<String, Object>();

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		// 设定返回字符集
		httpServletResponse.setCharacterEncoding("UTF-8");

		// 不过滤的uri
		String[] notFilterToken = new String[] { "getVerifyCode", "userRegister", "forgotPassword", "login", "getParm", "getVersion" };

		// 请求的uri
		String uri = httpServletRequest.getRequestURI();

		// 获取请求参数
		String serviceParm = httpServletRequest.getParameter(Constants.POST_PARM);

		Long timeNow = System.currentTimeMillis();

		try {
			// 是否验证tokken
			boolean doFilterToken = true;
			for (String s : notFilterToken) {
				if (uri.indexOf(s) != -1) {
					// 如果uri中包含不过滤的uri，则不进行过滤
					doFilterToken = false;
					break;
				}
			}
			chain.doFilter(request, response);

		} catch (

		Exception e) {
			httpServletResponse.getWriter().write(JSONUtil.toJson(map));
			logger.error("doFilterInternal方法异常" + e);
		}

	}

	@Override
	public void destroy() {

	}
}
