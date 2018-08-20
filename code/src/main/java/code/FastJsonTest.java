package code;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastJsonTest {

    public static void main(String[] args){
        List<String> l = new ArrayList<String>();
        l.add("stt");
        l.add("stt");
        l.add("stt");
        String jsonObject = JSONObject.toJSONString(l,SerializerFeature.WriteMapNullValue);
        Object ol = JSON.parse(jsonObject);
        System.out.println(ol);

        System.out.println(jsonObject);

        Map<String,String> m = new HashMap<String,String>();
        m.put("s","s");
        m.put("t","t");
        String mj = JSONObject.toJSONString(m,SerializerFeature.WriteMapNullValue);

        System.out.println(mj);

        Object om = JSON.parse(mj);
        System.out.println(om);

        Meta meta = new Meta();
        meta.key="key";
        String metaj = JSONObject.toJSONString(meta,SerializerFeature.WriteMapNullValue);
        System.out.println(metaj);

        Object ometa = JSON.parse(metaj);
        System.out.println(ometa);


    }
}

class Meta{
    String key;
    String key1;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }
}