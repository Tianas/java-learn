//package chapter03.helloapp.src.mypack;
//import javax.servlet.jsp.JspException;
//import javax.servlet.jsp.JspTagException;
//import javax.servlet.jsp.tagext.TagSupport;
//
//public class HelloTag extends TagSupport{
//  /** ��JSP����������hello��ǩ�Ľ�����־ʱ�����ô˷��� */
//  public int doEndTag() throws JspException{
//    try{
//      //��ӡ�ַ�����Hello��
//      pageContext.getOut().print("Hello");
//    }catch (Exception e) {
//      throw new JspTagException(e.getMessage());
//    }
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
