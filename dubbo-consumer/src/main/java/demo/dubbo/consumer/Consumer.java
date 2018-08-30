package demo.dubbo.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSONObject;
import demo.dubbo.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Consumer {
	
	public static void main(String[] args) throws Exception{
		ClassPathXmlApplicationContext context
			= new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
		context.start();

		String username = "ting";
		DemoService demoService = (DemoService) context.getBean("demoService");
		RpcContext.getContext().setAttachment("invokeIds","1713,1714,1716,1717");
		for(int i=0; i < 10000; i ++){
			String result = demoService.changeUsername(username);
			System.out.println(result);
			Thread.sleep(10000);
		}

		System.in.read();
	}

//	public static void main(String[] str){
//
//		DubboService dubboService = new DubboService("zookeeper://10.165.124.14:4281","",null);
//		String interfaceName = "demo.dubbo.api.DemoService";
//		String methodName = "changeUsername";
//		String paramType[] = {"java.lang.String"};
//
//		Object paramValue[] = {"suifei_li@163.com"};
//		try {
//			RpcContext.getContext().setAttachment("invokeIds","1713,1714,1716,1717");
//			Object o = dubboService.genericInvoke(interfaceName, methodName, paramType, paramValue);
//			System.out.println(o);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//
//	}
	
}
