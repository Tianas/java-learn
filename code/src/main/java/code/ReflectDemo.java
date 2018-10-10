package code;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by zejian on 2017/5/1.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class ReflectDemo implements Serializable {
    public static void main(String[] args) throws Exception {

        Class<?> clazz = null;

        //获取Class对象的引用
        clazz = Class.forName("code.User");

        //第一种方法，实例化默认构造方法，User必须无参构造函数,否则将抛异常
        User user = (User) clazz.newInstance();
        user.setAge(20);
        user.setName("Rollen");
        System.out.println(user);

        System.out.println("--------------------------------------------");

        //获取带String参数的public构造函数
        Constructor cs1 =clazz.getConstructor(String.class);
        //创建User
        User user1= (User) cs1.newInstance("xiaolong");
        user1.setAge(22);
        System.out.println("user1:"+user1.toString());

        System.out.println("--------------------------------------------");

        //取得指定带int和String参数构造函数,该方法是私有构造private
        Constructor cs2=clazz.getDeclaredConstructor(int.class,String.class);
        //由于是private必须设置可访问
        cs2.setAccessible(true);
        //创建user对象
        User user2= (User) cs2.newInstance(25,"lidakang");
        System.out.println("user2:"+user2.toString());

        System.out.println("--------------------------------------------");

        //获取所有构造包含private
        Constructor<?> cons[] = clazz.getDeclaredConstructors();
        // 查看每个构造方法需要的参数
        for (int i = 0; i < cons.length; i++) {
            //获取构造函数参数类型
            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.println("构造函数["+i+"]:"+cons[i].toString() );
            System.out.print("参数类型["+i+"]:(");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
            System.out.println(")");
        }

        Method[] methods = clazz.getDeclaredMethods();
        for(Method m : methods){
            Class<?>[] ccs = m.getParameterTypes();
            Type[] types = m.getGenericParameterTypes();
            System.out.println("方法:"+m.getName() );
            System.out.print("参数类型:(");
            for (int j = 0; j < ccs.length; j++) {
                if (j == ccs.length - 1)
                    System.out.print(paramName(ccs[j]));
                else
                    System.out.print(paramName(ccs[j]) + ",");
            }
            System.out.println(")");
            System.out.print("getTypeName参数类型:(");
            for (int j = 0; j < types.length; j++) {
                if (j == types.length - 1)
                    System.out.print(types[j].getClass());
                else
                    System.out.print(types[j].getClass() + ",");
            }
            System.out.println(")");
            System.out.print("toString参数类型:(");
            for (int j = 0; j < types.length; j++) {
                if (j == types.length - 1)
                    System.out.print(paramType(types[j]));
                else
                    System.out.print(paramType(types[j]) + ",");
            }
            System.out.println(")");


        }

    }

//    public static String paramType(Type type){
//        if (!(type instanceof ParameterizedType)){
//            Class<?> cl = (Class)type;
//            if(cl.isArray()) {
//                try {
//                    int dimensions = 0;
//                    while (cl.isArray()) {
//                        dimensions++;
//                        cl = cl.getComponentType();
//                    }
//                    StringBuilder sb = new StringBuilder();
//                    sb.append(cl.getName());
//                    for (int i = 0; i < dimensions; i++) {
//                        sb.append("[]");
//                    }
//                    return sb.toString();
//                } catch (Throwable e) { /*FALLTHRU*/ }
//            }
//        }
//        return type.toString();
//
//    }

    public static String paramName(Class<?> cl){
        if(cl.isArray()) {
            try {
                int dimensions = 0;
                while (cl.isArray()) {
                    dimensions++;
                    cl = cl.getComponentType();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(cl.getName());
                for (int i = 0; i < dimensions; i++) {
                    sb.append("[]");
                }
                return sb.toString();
            } catch (Throwable e) { /*FALLTHRU*/ }
        }
        return cl.getName();

    }

    public static String paramType(Type type){
        if (!(type instanceof ParameterizedType)){
            Class<?> cl = (Class)type;
            if(cl.isArray()){
                return paramName(cl);
            }
        }
        return type.toString();

    }
}


//class User {
//    private int age;
//    private String name;
//    public User() {
//        super();
//    }
//    public User(String name) {
//        super();
//        this.name = name;
//    }
//
//    /**
//     * 私有构造
//     * @param age
//     * @param name
//     */
//    private User(int age, String name) {
//        super();
//        this.age = age;
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void testParamType(User[][] args){
//
//    }
//
//    public void testParamTypeList(List<User[]> args){
//
//    }
//
//    public void testParamTypeMap(Map<String[],User> args){
//
//    }
//
//
//}