package test.server.method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.pers.mapper.LoginMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/resources/spring/spring-service.xml","classpath:/resources/spring/spring-web.xml","classpath:/resources/spring/spring-dao.xml"})
public class TUserTest {

	@Autowired
	private LoginMapper loginM;

	@Test
	public void findAll() {
		System.out.println(loginM.selectUser("wxp"));
	}

}
