//package mypack;
//import javax.servlet.jsp.JspException;
//import javax.servlet.jsp.JspTagException;
//import javax.servlet.jsp.tagext.TagSupport;
//import javax.servlet.http.HttpSession;
//import java.util.*;
//import java.io.*;
//
//public class MessageTag extends TagSupport{
//  private String key=null;
//
//  public String getKey(){
//    return this.key;
//  }
//
//  public void setKey(String key){
//    this.key=key;
//  }
//
//  public int doEndTag() throws JspException {
//    try {
//      //���Ӣ����Դ�ı�
//      Properties ps=(Properties)pageContext.getAttribute("ps",pageContext.APPLICATION_SCOPE);
//      //���������Դ�ļ�
//      Properties ps_ch=(Properties)pageContext.getAttribute("ps_ch",pageContext.APPLICATION_SCOPE);
//
//      HttpSession session=pageContext.getSession();
//      //��ȡ��ǰʹ�õ�����
//      String language=(String)session.getAttribute("language");
//
//      //������keyƥ����ı�
//      String message=null;
//      if(language!=null && language.equals("Chinese")){
//        message=(String)ps_ch.get(key);
//	message=new String(message.getBytes("ISO-8859-1"),"GB2312");
//      }else{
//         message=(String)ps.get(key);
//      }
//
//      //��ӡ��̬�ı�
//      pageContext.getOut().print(message);
//
//    }catch (Exception e) {
//      throw new JspTagException(e);
//    }
//
//    return EVAL_PAGE;
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
