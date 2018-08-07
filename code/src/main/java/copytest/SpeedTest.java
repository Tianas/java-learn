package copytest;

/**
 * Created by hzsuntingting on 2018/5/24.
 */

import com.alibaba.fastjson.JSON;
import performance.Memory;

import java.util.ArrayList;

public class SpeedTest {

    public static void main(String[] args) {
        // Make a reasonable large test object. Note that this doesn't
        // do anything useful -- it is simply intended to be large, have
        // several levels of references, and be somewhat random. We start
        // with a hashtable and add vectors to it, where each element in
        // the vector is a Date object (initialized to the current time),
        // a semi-random string, and a (circular) reference back to the
        // object itself. In this case the resulting object produces
        // a serialized representation that is approximate 700K.
        ArrayList<SubClass> slist=new ArrayList<SubClass>();
        for(int j=0; j<100; j++){
            ArrayList<String> a=new ArrayList<String>();
            for(int i =0; i < 100; i++){
                a.add("asdfasdfffffffffffffffffffffffffffffffffffffa;sdhfauiwehfakshdlnfljkasdfhlkasdhfauiwehfalksdhflkajsdhflllllllalhsdfuiawehflkasdhfkjlasdhfjkasd");
            }
            SubClass s = new SubClass(a);
            slist.add(s);
        }
        TestClass t = new TestClass(slist);
        SubClass ts = t.s.get(0);


//        Hashtable t = new Hashtable();
//        for (int i = 0; i < 200; i++) {
//            Vector v = new Vector();
//            for (int j = 0; j < 200; j++) {
//                v.addElement(new Object[] {
//                        new Date(),
//                        "A random number: " + Math.random(),
//                        t
//                });
//            }
//            t.put(new Integer(i), v);
//        }
//
//        Vector tv=(Vector)t.get(0);



        int iterations = 1;

        // Make copies of the object using the unoptimized version
        // of the deep copy utility.
        long unoptimizedTime = 0L;
        long unoptimizedMemory= 0;
        for (int i = 0; i < iterations; i++) {
            long mstart= Memory.used();
            long start = System.currentTimeMillis();
            TestClass copy = (TestClass)UnoptimizedDeepCopy.copy(t);
            long time=(System.currentTimeMillis() - start);
            unoptimizedMemory += (Memory.used()-mstart);
            System.out.println("unoptimizedTime time: " + time);
            unoptimizedTime += time;



            SubClass tmp = copy.s.get(0);
            tmp.b.set(5,"test");
            System.out.println("equal:"+(ts.b.get(5)==tmp.b.get(5)));
            // Avoid having GC run while we are timing...

            copy = null;
            System.gc();
        }


        // Repeat with the optimized version
        long optimizedTime = 0L;
        long optimizedMemory= 0;
        for (int i = 0; i < iterations; i++) {
            long mstart= Memory.used();
            long start = System.currentTimeMillis();
            TestClass copy = (TestClass)DeepCopy.copy(t);
            long time=(System.currentTimeMillis() - start);
            optimizedMemory += (Memory.used()-mstart);
            System.out.println("optimizedTime time: " + time);
            optimizedTime += time;


            SubClass tmp = copy.s.get(0);
            tmp.b.set(5,"test");
            System.out.println("equal:"+(ts.b.get(5)==tmp.b.get(5)));
            // Avoid having GC run while we are timing...
            copy = null;
            System.gc();
        }

        long reflectTime = 0L;
        long reflectMemory= 0;
        for (int i = 0; i < iterations; i++) {
            long mstart= Memory.used();
            long start = System.currentTimeMillis();
            TestClass copy = (TestClass)DeepCloneUtil.cloneObject(t);
//            reflectTime += (System.currentTimeMillis() - start);
            long time=(System.currentTimeMillis() - start);
            reflectMemory += (Memory.used()-mstart);
            System.out.println("reflectTime time: " + time);
            reflectTime += time;


            SubClass tmp = copy.s.get(0);
            tmp.b.set(5,"test");
            System.out.println("equal:"+(ts.b.get(5)==tmp.b.get(5)));
            // Avoid having GC run while we are timing...
            copy = null;
            System.gc();
        }


        long fastJsonTime = 0L;
        long fastJsonMemory= 0;
        for (int i = 0; i < iterations; i++) {
            long mstart= Memory.used();
            long start = System.currentTimeMillis();
            String testStr = JsonCopy.deepClone(t);
            long time=(System.currentTimeMillis() - start);
//            cloneableTime += (System.currentTimeMillis() - start);
            fastJsonMemory += (Memory.used()-mstart);
            System.out.println("fastJsonTime time: " + time);
            fastJsonTime += time;


            TestClass copy = (TestClass)JSON.parseObject(testStr,TestClass.class);
            SubClass tmp = copy.s.get(0);
            tmp.b.set(5,"test");
            System.out.println("equal:"+(ts.b.get(5)==tmp.b.get(5)));
            // Avoid having GC run while we are timing...
            copy = null;
            System.gc();
        }


        long cloneableTime = 0L;
        long cloneableMemory= 0;
        for (int i = 0; i < iterations; i++) {
            long mstart= Memory.used();
            long start = System.currentTimeMillis();
            TestClass copy = (TestClass)t.clone();
            long time=(System.currentTimeMillis() - start);
//            cloneableTime += (System.currentTimeMillis() - start);
            cloneableMemory += (Memory.used()-mstart);
            System.out.println("cloneableTime time: " + time);
            cloneableTime += time;


            SubClass tmp = copy.s.get(0);
            tmp.b.set(5,"test");
            System.out.println("equal:"+(ts.b.get(5)==tmp.b.get(5)));
            // Avoid having GC run while we are timing...
            copy = null;
            System.gc();
        }

        System.out.println("Unoptimized time: " + unoptimizedTime);
        System.out.println("  Optimized time: " + optimizedTime);
        System.out.println("    reflect time: " + reflectTime);
        System.out.println("  fastJsonT time: " + fastJsonTime);
        System.out.println("  cloneable time: " + cloneableTime);

        System.out.println("unoptimizedMemory: " + unoptimizedMemory);
        System.out.println("  optimizedMemory: " + optimizedMemory);
        System.out.println("    reflectMemory: " + reflectMemory);
        System.out.println("   fastJsonMemory: " + fastJsonMemory);
        System.out.println("  cloneableMemory: " + cloneableMemory);


    }

}


