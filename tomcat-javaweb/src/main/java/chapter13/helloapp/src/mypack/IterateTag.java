//package mypack;
//import javax.servlet.jsp.*;
//import javax.servlet.jsp.tagext.TagSupport;
//import java.util.*;
//
//public class IterateTag extends TagSupport{
//  private Iterator items;  //�������ļ���
//  private String var;  //�����ҳ�淶Χ�ڵļ�����Ԫ�ص�������
//  private Object item;  //�����е�һ��Ԫ��
//
//  public void setItems(Collection items){
//    if(items.size()>0)
//      this.items=items.iterator();
//  }
//
//  public void setVar(String var){
//    this.var=var;
//  }
//
//  public int doStartTag()throws JspException{
//    if(items.hasNext()){
//      item=items.next();  //�Ӽ����ж�ȡһ��Ԫ��
//      saveItem(); //��Ԫ�ش����ҳ�淶Χ��
//      return EVAL_BODY_INCLUDE;
//    }else{
//      return SKIP_BODY;
//    }
//
//  }
//
//  public int doAfterBody()throws JspException{
//    //��������л���Ԫ�أ��Ͱ�Ԫ�ش����ҳ�淶Χ�ڣ����ظ�ִ�б�ǩ����
//    if(items.hasNext()){
//      item=items.next();
//      saveItem();
//      return EVAL_BODY_AGAIN;
//    }else{
//      return SKIP_BODY;
//    }
//  }
//
//  /**���Ԫ�ز�Ϊnull���Ͱ��������ҳ�淶Χ�� */
//  private void saveItem(){
//    if(item==null)
//      pageContext.removeAttribute(var,PageContext.PAGE_SCOPE);
//    else
//      pageContext.setAttribute(var,item);
//  }
//
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
