package chapter01.src.server;
import java.io.*;
public class HelloServlet implements Servlet{
  public void init()throws Exception{
    System.out.println("HelloServlet is inited");
  }
  public void service(byte[] requestBuffer, OutputStream out)throws Exception{
    String request=new String(requestBuffer);

    //���HTTP����ĵ�һ��
    String firstLineOfRequest=request.substring(0,request.indexOf("\r\n"));
    //����HTTP����ĵ�һ�� 
    String[] parts=firstLineOfRequest.split(" "); 
    String method=parts[0]; //���HTTP�����е�����ʽ
    String uri=parts[1]; //���HTTP�����е�uri
    
                    
    /*����������username */
    String username=null;
    if(method.equalsIgnoreCase("get") && uri.indexOf("username=")!=-1){
      
      /*�ٶ�uri="servlet/HelloServlet?username=Tom&password=1234"*/
      //parameters="username=Tom&password=1234"
      String parameters=uri.substring(uri.indexOf("?"),uri.length()); 
      
      //parts={"username=Tom","password=1234"};
      parts=parameters.split("&");
      //parts={"username","Tom"};
      parts=parts[0].split("=");
      username=parts[1];   
    } 
    if(method.equalsIgnoreCase("post")){
      int locate=request.indexOf("\r\n\r\n");
      //�����Ӧ���� 
      String content=request.substring(locate+4,request.length());
      if(content.indexOf("username=")!=-1){
        /*�ٶ�content="username=Tom&password=1234"*/
        //parts={"username=Tom","password=1234"};
        parts=content.split("&");
        //parts={"username","Tom"};
        parts=parts[0].split("=");
        username=parts[1];   
      } 
    } 
    
    /*����������HTTP��Ӧ*/
    //����HTTP��Ӧ��һ��
    out.write("HTTP/1.1 200 OK\r\n".getBytes());
    //����HTTP��Ӧͷ
    out.write("Content-Type:text/html\r\n\r\n".getBytes());
    //����HTTP��Ӧ����
    out.write("<html><head><title>HelloWorld</title></head><body>".getBytes());
    out.write(new String("<h1>Hello:"+username+"</h1></body><head>").getBytes());
    
  }
}



/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
