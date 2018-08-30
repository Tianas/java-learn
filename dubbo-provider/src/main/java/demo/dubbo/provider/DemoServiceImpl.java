package demo.dubbo.provider;


import com.alibaba.dubbo.rpc.RpcContext;
import demo.dubbo.api.DemoService;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * 测试服务端接口实现类
 * @author aotian
 *
 */
public class DemoServiceImpl implements DemoService {

	/**
	 * 测试方法，在用户名后添加一个字符串
	 * @param username	用户名
	 * @return	修改后的字符串
	 */
	@Override
	public String changeUsername(String username) {
		System.out.println(System.currentTimeMillis()+"");
		TestServiceImpl testService = new TestServiceImpl();
		System.out.println(Thread.currentThread().getId());

		Map<String,String> attachments = RpcContext.getContext().getAttachments();
//		for(String k : attachments.keySet()){
//			System.out.println("key="+k+";value="+attachments.get(k));
//		}

//		RpcContext.getContext().setAttachment("traceId","testChangeUserName");
		int s = changeRpc(1);
//		System.out.println(RpcContext.getContext().getAttachment("traceId"));
		List<String> list = testService.testMockList(username);
		Map<String,String> map  = testService.testMockMap(username);
		Meta meta  = testService.testBean(username);
		System.currentTimeMillis();
		System.out.println(System.currentTimeMillis());
		return username + " is changed";
	}

	private int changeRpc(int i){
		return i ++;
//		RpcContext.getContext().setAttachment("traceId","testChangeRpc");
	}

}
