package cn.com.pers.Hessian.test;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;

import cn.com.pers.Hessian.Isay;

public class HessianClient {
	public static void main(String[] args) throws MalformedURLException {  
        //Spring Hessian代理Servelet  
        String url = "http://localhost:8080/SpringMVCDemo/remote/helloSpring";  
        HessianProxyFactory factory = new HessianProxyFactory();  
        Isay api = (Isay) factory.create(Isay.class, url);  
  
        System.out.println(api.sayHello("chen", "weitang"));  
    }  
}
