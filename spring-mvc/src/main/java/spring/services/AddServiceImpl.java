package spring.services;

import com.alibaba.dubbo.rpc.RpcContext;
import demo.dubbo.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by hzsuntingting on 2017/1/23.
 */

@Component("addService")
public class AddServiceImpl implements AddService {

    public int ajaxAdd(int data1, int data2){
        return data1+data2;
    }


    public void test(){
        ClassPathXmlApplicationContext context
			= new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
		context.start();

		String username = "ting";
		DemoService demoService = (DemoService) context.getBean("demoService");
		RpcContext.getContext().setAttachment("invokeIds","1713,1714,1716,1717");
		String result = demoService.changeUsername(username);
		System.out.println(result);
    }
}
