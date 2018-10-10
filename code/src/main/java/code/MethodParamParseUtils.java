package code;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
//import com.netease.hzqa.intercept.SystemVariableData;
import javassist.CtClass;
import org.apache.log4j.Logger;
import sun.reflect.generics.factory.CoreReflectionFactory;
import sun.reflect.generics.repository.MethodRepository;
import sun.reflect.generics.scope.MethodScope;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @Auther duxingxing
 * @Date 2018/4/11 13:58
 */
public class MethodParamParseUtils {

//    private static Logger logger = QaAgentLogUtil.getLogger(MethodParamParseUtils.class);

    public static String coverCtClassToClass(CtClass[] ctClasses) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ctClasses.length; i++) {
            builder.append(",").append(ctClasses[i].getName()).append(".class");
        }
        return builder.toString().replaceFirst(",", "");
    }

    public static Method getMethod(Class c, String methodName, Class[] classes) {
        try {
            Method m = null;
            if (classes == null || classes.length == 0) {
                m = c.getMethod(methodName);
            } else {
                m = c.getMethod(methodName, classes);
            }
            return m;
        } catch (Exception e) {
//            logger.error("getMethod fail:", e);
        }
        return null;
    }

    private static MethodRepository getMethodRepository(Method m, String sign) {
        return MethodRepository.make(sign, CoreReflectionFactory.make(m, MethodScope.make(m)));
    }

//    public static Type inputParam(Class c, Method m, String sign, int location) {
//        logger.info(c.getName() + "--" + m.getName() + "--" + sign + "--" + location + "--inputParam");
//        try {
//            if (m != null) {
//                if (sign == null || "".equals(sign) || "null".equals(sign)) {
//                    Type t1 = m.getParameterTypes()[location];
//                    logger.info("inputParam type:" + t1);
//                    return t1;
//                } else {
//                    if (SystemVariableData.isLowSb) {
//                        MethodRepository methodRepository = getMethodRepository(m, sign);
//                        if (methodRepository != null) {
//                            Type t2 = methodRepository.getParameterTypes()[location];
//                            logger.info("LowSb inputParam params methodRepository:" + t2);
//                            return t2;
//                        }
//                        return m.getParameterTypes()[location];
//                    } else {
//                        Type t3 = m.getGenericParameterTypes()[location];
//                        logger.info("inputParam getGenericParameterTypes type:" + t3);
//                        return t3;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            logger.error("inputParam error", e);
//        }
//        return null;
//    }


    public static Type returnParam(Class c, Method m, String sign) {
//        logger.info(c.getName() + "--" + m.getName()  + "--returnParam");
        try {
            if (m != null) {
                if (sign == null || "".equals(sign) || "null".equals(sign)) {
                    Type t1 = m.getReturnType();
//                    logger.info("returnParam type:" + t1);
                    return t1;
                } else {
//                    if (SystemVariableData.isLowSb) {
                        MethodRepository methodRepository = getMethodRepository(m, sign);
                        if (methodRepository != null) {
                            Type t2 = methodRepository.getReturnType();
//                            logger.info("LowSb returnParam params methodRepository:" + t2);
                            return t2;
                        }
                        return m.getReturnType();
//                    } else {
//                        Type t3 = m.getGenericReturnType();
//                        logger.info("returnParam getGenericReturnType type:" + t3);
//                        return t3;
//                    }

                }
            }
        } catch (Exception e) {
//            logger.error("returnParam error", e);
        }
        return null;
    }

    public static Type getRpcMethodType(JSONObject json) {
        //logger.info(json.getString("interface") + "--" + json.getString("methodName") + "--" + json.getJSONArray("parameterTypes").toString() + "--getRpcMethodType");
        try {
            Class c = Class.forName(json.getString("interface"));
            JSONArray array = json.getJSONArray("parameterTypes");
            Class[] paramTypeArr = new Class[array.size()];
            for (int i = 0; i < array.size(); i++) {
                if ("int".equals(array.getString(i))) {
                    paramTypeArr[i] = int.class;
                } else if ("long".equals(array.getString(i))) {
                    paramTypeArr[i] = long.class;
                } else if ("boolean".equals(array.getString(i))) {
                    paramTypeArr[i] = boolean.class;
                } else if ("short".equals(array.getString(i))) {
                    paramTypeArr[i] = short.class;
                } else if ("float".equals(array.getString(i))) {
                    paramTypeArr[i] = float.class;
                } else if ("double".equals(array.getString(i))) {
                    paramTypeArr[i] = double.class;
                } else if ("char".equals(array.getString(i))) {
                    paramTypeArr[i] = char.class;
                } else if ("byte".equals(array.getString(i))) {
                    paramTypeArr[i] = byte.class;
                } else {
                    paramTypeArr[i] = Class.forName(array.getString(i));
                }
            }
            Method m = c.getMethod(json.getString("methodName"), paramTypeArr);
            //logger.info("RpcMethodType:" + m.getGenericReturnType());
            return m.getGenericReturnType();
        } catch (Exception e) {
//            logger.error(e);
        }
        return null;
    }


}
