package copytest;

import org.springframework.cglib.beans.BeanCopier;

import java.io.IOException;

/**
 * Created by hzsuntingting on 2018/5/24.
 */
public class BeanCopierCopy {
    BSubClass subClass;
    int num;

    public BSubClass getSubClass() {
        return subClass;
    }

    public void setSubClass(BSubClass subClass) {
        this.subClass = subClass;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    BeanCopierCopy(){}
    BeanCopierCopy(BSubClass subClass, int num) {
        this.subClass = subClass;
        this.num = num;
    }

    public BeanCopierCopy beanCopier(){
        final BeanCopier copier = BeanCopier.create(BeanCopierCopy.class, BeanCopierCopy.class, false);
        BeanCopierCopy b = new BeanCopierCopy();
        copier.copy(this, b, null);
        return b;
    }


    public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {

        BSubClass subClass = new BSubClass(20);
        BeanCopierCopy s = new BeanCopierCopy(subClass,30);

        long start = System.currentTimeMillis();
        BeanCopierCopy s2 = (BeanCopierCopy) s.beanCopier();

        long end = System.currentTimeMillis();
        System.out.println("time="+(end-start));
//            costtime += (end-start);
//        }

        System.out.println("subclass="+(s.subClass == s2.subClass));
        System.out.println("subclass.int="+(s.subClass.sumnum == s2.subClass.sumnum));


    }
}

class BSubClass{
    int sumnum;
    public BSubClass(int sumnum){
        this.sumnum = sumnum;
    }
}
