package demo.dubbo.provider;

import com.alibaba.dubbo.rpc.RpcContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestServiceImpl {

    public List<String> testMockList(String username){
        List l = new ArrayList();
        l.add(username);
        l.add(username);
        return l;
    }

    public Map<String,String> testMockMap(String username){
        Map<String,String> m = new HashMap<String, String>();
        m.put("key","value");
        m.put("key1","value1");
        return m;
    }

    public Meta testBean(String username){
        Meta meta = new Meta();
        meta.key="key";
        meta.key1="key1";
        return meta;
    }
}