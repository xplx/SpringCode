package test.conntroller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cn.com.pers.controller.LoginConntroller;
import cn.com.pers.model.Login;
import cn.com.pers.utils.JSONUtil;

/** 
* @author wxp  
* @date 2017年12月8日 下午1:39:45 
* @Description: TODO(登录Controller测试) 
*/
//使用Spring Test组件进行单元测试
@RunWith(SpringJUnit4ClassRunner.class)
//使用这个Annotate会在跑单元测试的时候真实的启一个web服务，然后开始调用Controller的Rest API，待单元测试跑完之后再将web服务停掉;(现在没用也能跑，不知道原因？)
//@WebAppConfiguration
//指定Bean的配置文件信息，可以有多种方式，这个例子使用的是文件路径形式，如果有多个配置文件，可以将括号中的信息配置为一个字符串数组来表示;
@ContextConfiguration(locations = { "classpath:/resources/spring/spring-service.xml","classpath:/resources/spring/spring-web.xml","classpath:/resources/spring/spring-dao.xml"})
//@ContextConfiguration(locations = { "classpath:/resources/spring/spring-service.xml"})
public class TestLoginController {

    @Autowired
    private LoginConntroller loginConntroller;

    private MockMvc mockMvc;

    @Test
    public void testLogin() throws Exception {
    	//获取mockMvc对象
        mockMvc = MockMvcBuilders.standaloneSetup(loginConntroller).build();

        Map<String,String> map = new HashMap<>();

        Login loginParm = new Login();

        loginParm.setUsername("wxp");

        loginParm.setPassword("123456");

        String jsonStr = JSONUtil.toJson(loginParm);
        
        try {
        	//perform，调用controller的业务处理逻辑
        	String responseString = this.mockMvc.perform
                    (		
                            MockMvcRequestBuilders.post("/login")
                                    .param("parm",jsonStr)
                                    .param("lenth",String.valueOf(jsonStr.length()))
                                    .param("time",String.valueOf(System.currentTimeMillis()))
                    )
                    //andExport( status().isOk())方法看请求的状态响应码是否为200
                    .andExpect(status().isOk())
                    ////打印出请求和相应的内容 
                    .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
        	System.out.println("--------返回的json = " + responseString); 
        } catch (Exception e) {
            e.printStackTrace();
        }


}
}
