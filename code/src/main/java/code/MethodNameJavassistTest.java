package code;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodNameJavassistTest {

    public static void main(String[] args) {

        Class<?> clazz = MethodNameJavassistTest.class;

        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass ctClass = pool.get(clazz.getName());
            CtMethod ctMethod = ctClass.getDeclaredMethod("putMap");
// 使用javassist的反射方法的参数名
            CtClass[] paramClass = ctMethod.getParameterTypes();
            ctMethod.getGenericSignature();
            for(int i =0; i<paramClass.length; i ++) {
//                String typeName = paramClass[i].getName();
                System.out.println(paramClass[i].getName());
            }
//            CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
//            LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute
//                    .getAttribute(LocalVariableAttribute.tag);
//            if (attr != null) {
//                int len = ctMethod.getParameterTypes().length;
//                // 非静态的成员函数的第一个参数是this
//                int pos = Modifier.isStatic(ctMethod.getModifiers()) ? 0 : 1;
//                System.out.print("test : ");
//                for (int i = 0; i < len; i++) {
//                    System.out.print(attr.variableName(i + pos) + ' ');
//                }
//                System.out.println();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void test(String[] param1, List<Integer> param2) {
//        System.out.println(param1 + param2);
    }

    public Map<String, User> putMap(String k, User v, Integer flag){
        if(flag!=0){
            Map<String, User> map = new HashMap<String, User>();
            map.put(k,v);
            return map;
        }
        return null;
    }


}