package copytest;

import java.io.*;

/**
 * Created by hzsuntingting on 2018/5/24.
 */
public class CloneableCopy implements Cloneable {
    CSubClass subClass;
    int num;

    CloneableCopy(CSubClass subClass, int num) {
        this.subClass = subClass;
        this.num = num;
    }

    public CloneableCopy clone() throws CloneNotSupportedException
    {
        CloneableCopy c = (CloneableCopy) super.clone();
        c.subClass = this.subClass.clone();
        return c;
    }

    public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {

        CSubClass subClass = new CSubClass(20);
        CloneableCopy s = new CloneableCopy(subClass,30);

        int times =100;
        int costtime = 0;
        for(int i=0; i <times; i ++){
            long start = System.currentTimeMillis();
            CloneableCopy s2 = (CloneableCopy) s.clone();
            long end = System.currentTimeMillis();
            System.out.println("time="+(end-start));
            costtime += (end-start);
        }

//        costtime = 0;
//        for(int i=0; i <times; i ++){
//            long start = System.currentTimeMillis();
//            CloneableCopy s2 = new CloneableCopy(subClass,30);
//            long end = System.currentTimeMillis();
//            System.out.println("time="+(end-start));
//            costtime += (end-start);
//        }

//        System.out.println("subclass="+(s.subClass == s2.subClass));
//        System.out.println("subclass.int="+(s.subClass.sumnum == s2.subClass.sumnum));

    }
}

class CSubClass implements Cloneable{
    int sumnum;
    public CSubClass(int sumnum){
        this.sumnum = sumnum;
    }

    public CSubClass clone() throws CloneNotSupportedException
    {
        CSubClass subClass = (CSubClass) super.clone();
        return subClass;
    }
}
