package chapter04.helloapp.src.mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HelloServlet extends HttpServlet {
  /** ��Ӧ�ͻ�����*/
  public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
    //���username�������
    String username=request.getParameter("username");

    /*�ַ�����ת����HTTP�����Ĭ���ַ�����ΪISO-8859-1����������а������ģ���Ҫ��
    ��ת��ΪGB2312���ı��롣*/
    if(username!=null)
      username=new String(username.getBytes("ISO-8859-1"),"GB2312");

    if(username==null){
      //����Ϊ����ʾresponse.sendError()���÷���
      response.sendError(response.SC_FORBIDDEN);
      return;
    }

    //����HTTP��Ӧ�����ĵ�MIME���ͼ��ַ�����
    response.setContentType("text/html;charset=GB2312");

    /*���HTML�ĵ�*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>HelloServlet</TITLE></head>");
    out.println("<body>");
    out.println("���: "+username);
    out.println("</body></html>");

    System.out.println("before close():"+response.isCommitted()); //false
    out.close(); //�ر�PrintWriter
    System.out.println("after close():"+response.isCommitted());  //true
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
