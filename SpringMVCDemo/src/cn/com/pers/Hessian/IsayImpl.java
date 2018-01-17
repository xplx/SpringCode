package cn.com.pers.Hessian;

import org.springframework.stereotype.Service;

/**
 * @author wxp
 * @date 2018年1月17日 上午10:12:47
 * @Description: TODO() @****实现类里面要实现接口的所有方法*****@ 简介：
 * 
 *               Hessian是一个简单的连接Web服务的二进制协议。
 * 
 *               客户端和服务端不依赖于其他任何jar,比起webService 它显得轻量许多,比如使用xfire包含核心库和客户端的jar,大小达到了10M ,而最新的hessian-4.0.7 jar大小也只有不到400K.
 * 
 *               更适合二进制的传输,比起webService.Hessian的 传输速度要高于webService.
 * 
 *               支持Java,c#,Flex(actionscrpit)
 */
@Service("implServer")
public class IsayImpl implements Isay {

	public String sayHello(String arg1, String arg2) {
		return "Hello:" + arg1 + arg2;
	}
}
