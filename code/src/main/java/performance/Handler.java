package performance;

/**
 * Created by hzsuntingting on 2018/5/24.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class Handler implements InvocationHandler {




    private Object obj;




    public Handler(Object obj) {

        this.obj = obj;

    }




    public static Object newInstance(Object obj) {

        Object result = Proxy.newProxyInstance(obj.getClass().getClassLoader(),

                obj.getClass().getInterfaces(), new Handler(obj));




        return (result);

    }




    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result;

        try {

            System.out.print("begin method " + method.getName() + "(");

            for (int i = 0; args != null && i < args.length; i++) {




                if (i > 0) System.out.print(",");

                System.out.print(" " +

                        args[i].toString());

            }

            System.out.println(" )");

            long start=System.currentTimeMillis();

            result = method.invoke(obj, args);

            long end=System.currentTimeMillis();

            System.out.println("the method "+method.getName()+" lasts "+(end-start)+"ms");

        } catch (InvocationTargetException e) {

            throw e.getTargetException();

        } catch (Exception e) {

            throw new RuntimeException

                    ("unexpected invocation exception: " +

                            e.getMessage());

        } finally {

            System.out.println("end method " + method.getName());

        }

        return result;

    }

    public Object invokeMemory(Object proxy, Method method, Object[] args) throws Throwable {

        Object result;

        try {

            System.out.print("begin method " + method.getName() + "(");

            for (int i = 0; args != null && i < args.length; i++) {




                if (i > 0) System.out.print(",");

                System.out.print(" " +

                        args[i].toString());

            }

            System.out.println(" )");

            long start=Memory.used();

            result = method.invoke(obj, args);

            long end=Memory.used();

            System.out.println("memory increased by "+(end-start)+"bytes");

        } catch (InvocationTargetException e) {

            throw e.getTargetException();

        } catch (Exception e) {

            throw new RuntimeException

                    ("unexpected invocation exception: " +

                            e.getMessage());

        } finally {

            System.out.println("end method " + method.getName());

        }

        return result;

    }

}
