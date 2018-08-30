package chapter01.src.server;
import java.io.*;
public interface Servlet{
  public void init()throws Exception;
  public void service(byte[] requestBuffer, OutputStream out)throws Exception;
}



/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
