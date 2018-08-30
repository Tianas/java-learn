//package mypack;
//import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.*;
//import java.util.*;
//
//public class ShoppingServlet extends HttpServlet{
//  public void doGet(HttpServletRequest req, HttpServletResponse res)
//  throws ServletException, java.io.IOException{
//    String[] itemNames={"�ǹ�","������","��ϰ��"};
//    //��ȡ�Ự����
//    HttpSession session=req.getSession(true);
//     //��ȡ�Ự��Χ�ڵ�ShoppingCart����
//    ShoppingCart cart=(ShoppingCart) session.getAttribute("cart");
//    //����Ự��Χû��ShoppingCart���󣬾ʹ�����������������Ự��Χ
//    if (cart==null){
//      cart=new ShoppingCart();
//      session.setAttribute("cart",cart);
//    }
//
//    res.setContentType("text/html;charset=GB2312");
//    PrintWriter out=res.getWriter();
//
//    //��ȡ������
//    String[] itemsSelected;
//    String itemIndex; //��Ʒ������
//    String itemName;  //��Ʒ������
//    itemsSelected=req.getParameterValues("item"); //��ȡ��ѡ�������
//
//    if(itemsSelected !=null){
//      for(int i=0;i<itemsSelected.length;i++){
//        itemIndex=itemsSelected[i];  //���ѡ�е���Ʒ������
//        itemName=itemNames[Integer.parseInt(itemIndex)];
//        //��ѡ�е���Ʒ���빺�ﳵ
//        cart.add(itemName);
//      }
//
//    }
//
//    //��ӡ���ﳵ������
//    out.println("<html>");
//    out.println("<head>");
//    out.println("<title>���ﳵ������</title>");
//    out.println("</head>");
//    out.println("<body>");
//    out.println("Session ID:"+session.getId()+"<br>");
//
//    out.println("<center><h1>��Ĺ��ﳵ��"+cart.getNumberOfItems()+"����Ʒ�� </h1></center>");
//
//    Map<String,Integer> items=cart.getItems();
//    Iterator<Map.Entry<String,Integer>> it=items.entrySet().iterator();
//    while(it.hasNext()){
//      Map.Entry entry=it.next();  //entry��ʾMap�е�һ�Լ���ֵ
//      out.println(entry.getKey()+": "+entry.getValue()+"<br>");
//    }
//    out.println("<br><a href='shopping.htm'>��������</a><br>");
//
//    out.println("</body>");
//    out.println("</html>");
//    out.close();
//  }
//
//  public void doPost(HttpServletRequest req, HttpServletResponse res)
//  throws ServletException, java.io.IOException{
//    doGet(req,res);
//  }
//}
//
//
//
//
///****************************************************
// * ���ߣ�������                                     *
// * ��Դ��<<Tomcat��Java Web�����������>>           *
// * ����֧����ַ��www.javathinker.org                *
// ***************************************************/
