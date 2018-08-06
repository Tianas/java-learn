package copytest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzsuntingting on 2018/5/25.
 */
public class TestClass implements Cloneable,Serializable{

    ArrayList<SubClass> s=new ArrayList<SubClass>();

    public ArrayList<SubClass> getS() {
        return s;
    }

    public void setS(ArrayList<SubClass> s) {
        this.s = s;
    }

    public TestClass(){}

    public TestClass(ArrayList<SubClass> s1){
        s = s1;
    }

    public TestClass clone(){
        TestClass t = null;
        try{
            t = (TestClass)super.clone();
            t.s = new ArrayList<SubClass>();
            for(SubClass sc:this.s){
                t.s.add(sc.clone());
            }
        }catch (Exception e){

        }
        return t;
    }

    public static void main(String[] args){

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
        TestClass t1 = t.clone();
        t1.s.get(0).b.set(0,"test");

//        s2.b.add("test");

        System.out.println("s.b == s2.b:"+(t.s.get(0).b.get(0)==t1.s.get(0).b.get(0)));
//        System.out.println("s.b.size == s2.b.size:"+(s.b.size()==s2.b.size()));
    }
}

class SubClass implements Cloneable,Serializable{

    ArrayList<String> b=new ArrayList<String>();

    public ArrayList<String> getB() {
        return b;
    }

    public void setB(ArrayList<String> b) {
        this.b = b;
    }

    public SubClass(){}

    public SubClass(List<String> a){
        for(String s:a){
            b.add(s);
        }
    }
    public SubClass clone(){
        SubClass s = null;
        try{
            s = (SubClass)super.clone();
            s.b = (ArrayList<String>)this.b.clone();
        }catch (Exception e){

        }
        return s;
    }

}
