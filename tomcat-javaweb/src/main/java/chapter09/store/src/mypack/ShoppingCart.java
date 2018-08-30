//package mypack;
//import java.util.*;
//import java.io.*;
//
//public class ShoppingCart implements Serializable {
//  Map<String,Integer> items = new HashMap<String,Integer>();
//  int numberOfItems = 0;
//
//  public synchronized void add(String itemName) {
//    if(items.containsKey(itemName)) {
//        Integer itemCount = (Integer) items.get(itemName);
//        items.put(itemName,new Integer(itemCount+1));
//    } else {
//        items.put(itemName, new Integer(1));
//    }
//
//    numberOfItems++;
//  }
//
//  public synchronized int getNumberOfItems() {
//      return numberOfItems;
//  }
//
//  public synchronized Map<String,Integer> getItems() {
//      return items;
//  }
//
//}
//
//
//
//
//
///****************************************************
// * ���ߣ�������                                     *
// * ��Դ��<<Tomcat��Java Web�����������>>           *
// * ����֧����ַ��www.javathinker.org                *
// ***************************************************/
