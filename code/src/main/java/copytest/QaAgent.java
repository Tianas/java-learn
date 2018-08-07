package copytest;


import com.alibaba.fastjson.JSONObject;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class QaAgent {

    public static void main(String[] args){

        Class<?> clazz = QaAgent.class;
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass ctClass = pool.get(clazz.getName());
            CtMethod ctMethod = ctClass.getDeclaredMethod("test");
            CtClass[] paramClass = ctMethod.getParameterTypes();
            String[] param$types = new String[paramClass.length];
            JSONObject object$s = new JSONObject();
            for(int i =0; i<paramClass.length; i ++){
                String typeName = paramClass[i].getName();
                param$types[i] = typeName;
                if(paramClass[i].getName().equals("int")){
                    object$s.put(String.valueOf(i),new Integer(i));//将基础类型封装为沙箱类
                }
            }
        }catch (Exception e){

        }

    }

    public static void test(String param1, int param2) {
        System.out.println(param1 + param2);
    }

}