//package mytaglib;
//import javax.servlet.jsp.JspTagException;
//import javax.servlet.jsp.tagext.TagSupport;
//import java.util.*;
//
//public class DefinitionTag extends TagSupport {
//   private  String definitionName = null;
//   private  String screenId;
//   private  int screenNum;
//
//   public DefinitionTag() {
//      super();
//   }
//   public void setName(String name) {
//      this.definitionName = name;
//   }
//   public void setScreenId(String screenId) {
//      this.screenId = screenId;
//   }
//
//   public void setScreenNum(int screenNum){
//      this.screenNum=screenNum;
//   }
//
//   public int doStartTag() {
//      HashMap screens = null;
//
//      screens =
//(HashMap) pageContext.getAttribute("screens", pageContext.APPLICATION_SCOPE);
//      if (screens == null)
//      	pageContext.setAttribute("screens",
//new HashMap(), pageContext.APPLICATION_SCOPE);
//      else{
//        if(screens.size()==screenNum)
//           return SKIP_BODY;
//      }
//      return EVAL_BODY_INCLUDE;
//   }
//   public int doEndTag()throws JspTagException {
//      try {
//         Definition definition = new Definition();
//         HashMap screens = null;
//         ArrayList parameters = null;
//         TagSupport screen = null;
//
//         screens = (HashMap) pageContext.getAttribute("screens",
//pageContext.APPLICATION_SCOPE);
//         if (screens != null) {
//            parameters = (ArrayList) screens.get(screenId);
//         }
//
//         Iterator	ir = null;
//
//         if (parameters != null)
//            ir = parameters.iterator();
//
//         while ((ir != null) && ir.hasNext())
//            definition.setParam((Parameter) ir.next());
//
//         //��Definition���󱣴���ҳ�淶Χ��
//         pageContext.setAttribute(definitionName, definition);
//      } catch (Exception ex) {
//         ex.printStackTrace();
//      }
//      return EVAL_PAGE;
//   }
//   public void release() {
//      definitionName = null;
//      screenId = null;
//      super.release();
//   }
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
