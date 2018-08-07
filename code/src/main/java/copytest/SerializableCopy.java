package copytest;

import java.io.*;

/**
 * Created by hzsuntingting on 2018/5/24.
 */
public class SerializableCopy implements Serializable {
    SSubClass subClass;
    int num;

    public SSubClass getSubClass() {
        return subClass;
    }

    public void setSubClass(SSubClass subClass) {
        this.subClass = subClass;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    SerializableCopy(SSubClass subClass, int num) {
        this.subClass = subClass;
        this.num = num;
    }



    public Object deepClone() throws IOException, OptionalDataException,
            ClassNotFoundException {
        // 将对象写到流里
        OutputStream bo = new ByteArrayOutputStream();
        //OutputStream op = new ObjectOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);

        // 从流里读出来
        InputStream bi = new ByteArrayInputStream(((ByteArrayOutputStream) bo).toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (oi.readObject());
    }


    public static void main(String[] args) throws OptionalDataException, ClassNotFoundException, IOException {

        SSubClass subClass = new SSubClass(20);
        SerializableCopy s = new SerializableCopy(subClass,30);

        int times =100;
        int costtime = 0;
        for(int i=0; i <times; i ++){
            long start = System.currentTimeMillis();
            SerializableCopy s2 = (SerializableCopy) s.deepClone();
            long end = System.currentTimeMillis();
            System.out.println("time="+(end-start));
            costtime += (end-start);
        }


//        System.out.println("subclass="+(s.subClass == s2.subClass));
//        System.out.println("subclass.int="+(s.subClass.sumnum == s2.subClass.sumnum));


    }
}

class SSubClass implements Serializable{
    int sumnum;
    public SSubClass(int sumnum){
        this.sumnum = sumnum;
    }
}
