//package mypack;
//
//import javax.servlet.jsp.*;
//import javax.servlet.jsp.tagext.*;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class MaxTag extends SimpleTagSupport implements DynamicAttributes{
//
//  private ArrayList<String> al=new ArrayList<String>();
//
//  public void setDynamicAttribute(String uri,String localeName,Object value)throws JspException{
//    //���������Ա��浽ArrayList��
//    al.add((String)value);
//  }
//
//  public void doTag() throws JspException, IOException {
//    JspContext context=getJspContext();
//
//    int max=0;
//    for(int i=0;i<al.size();i++){
//      int num=Integer.parseInt(al.get(i));
//      max= num > max ? num : max;
//    }
//    //�����ֵ���浽ҳ�淶Χ��
//    context.setAttribute("max",new Integer(max));
//  }
//}
//
//
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
