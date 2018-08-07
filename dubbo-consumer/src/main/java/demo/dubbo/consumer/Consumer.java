package demo.dubbo.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import demo.dubbo.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Consumer {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context 
			= new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
		context.start();
		
		String username = "ting";
		DemoService demoService = (DemoService) context.getBean("demoService");
		RpcContext.getContext().setAttachment("test","testContext");
		System.out.println(demoService.changeUsername(username));
	}
	
}
