package code;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import org.objectweb.asm.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;


public class FastJsonParseTest {

    public static void main(String[] args) {
        String str = "{\"name\":\"tt\",\"id\":1,\"@type\":\"code.User\",\"age\":10}";

        ParserConfig.getGlobalInstance().addAccept("code.User");
        Object o = JSON.parse(str);
        User o1 = JSON.parseObject(str,User.class);

        boolean ls = Boolean.parseBoolean("ss");
        if(ls){
            System.out.print(JSON.toJSONString(ls));
        }else{
            System.out.print(JSON.toJSONString(o));
        }


//        o = JSON.parseObject(str, MethodParamParseUtils.returnParam(clazz, method, signature));






    }


}