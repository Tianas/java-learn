package copytest;

import com.alibaba.fastjson.JSON;

/**
 * Created by hzsuntingting on 2018/5/25.
 */
public class JsonCopy {

    public static String deepClone(Object o){

        String json = JSON.toJSONString(o);
        return json;
    }
}
