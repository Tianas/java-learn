package chapter01.src.server;
import java.io.*;
import java.net.*;

public class HTTPServer{
  public static void main(String args[]) {
    int port;
    ServerSocket serverSocket;
      
    try { 
       port = Integer.parseInt(args[0]);
     }catch (Exception e) {
       System.out.println("port = 8080 (Ĭ��)");
       port = 8080; //Ĭ�϶˿�Ϊ8080
     }

     try{
       serverSocket = new ServerSocket(port); 
       System.out.println("���������ڼ����˿ڣ�" + serverSocket.getLocalPort());
        
       while(true) { //��������һ������ѭ���в��Ͻ������Կͻ���TCP��������
         try{
           //�ȴ��ͻ���TCP��������
           final Socket socket = serverSocket.accept(); 
           System.out.println("��������ͻ���һ���µ�TCP���ӣ��ÿͻ��ĵ�ַΪ��"+
                socket.getInetAddress()+":" + socket.getPort());
          
           service(socket);  //��Ӧ�ͻ�����
        }catch(Exception e){e.printStackTrace();} 
      } //#while
    }catch (Exception e) {e.printStackTrace();}
  }

  /** ��Ӧ�ͻ���HTTP���� */
  public static void service(Socket socket)throws Exception{
    
    /*��ȡHTTP������Ϣ*/
    InputStream socketIn=socket.getInputStream(); //���������
    Thread.sleep(500);  //˯��500���룬�ȴ�HTTP����  
    int size=socketIn.available();
    byte[] requestBuffer=new byte[size];
    socketIn.read(requestBuffer);
    String request=new String(requestBuffer);
    System.out.println(request); //��ӡHTTP��������
     
    /*����HTTP����*/
    //���HTTP����ĵ�һ��
    String firstLineOfRequest=request.substring(0,request.indexOf("\r\n"));
    //����HTTP����ĵ�һ�� 
    String[] parts=firstLineOfRequest.split(" "); 
    String uri=parts[1]; //���HTTP�����е�uri
    
    /*����HTTP��Ӧ���ĵ�����*/
    String contentType;
    if(uri.indexOf("html")!=-1 || uri.indexOf("htm")!=-1)
      contentType="text/html";
    else if(uri.indexOf("jpg")!=-1 || uri.indexOf("jpeg")!=-1)
      contentType="image/jpeg";
    else if(uri.indexOf("gif")!=-1) 
      contentType="image/gif";
    else
      contentType="application/octet-stream"; 
    
    
    /*����HTTP��Ӧ��� */
    //HTTP��Ӧ�ĵ�һ��
    String responseFirstLine="HTTP/1.1 200 OK\r\n";
    //HTTP��Ӧͷ
    String responseHeader="Content-Type:"+contentType+"\r\n\r\n";
    //��ö�ȡ��Ӧ�������ݵ�������
    InputStream in=HTTPServer1.class.getResourceAsStream("root/"+uri);
    
    /*����HTTP��Ӧ��� */
    OutputStream socketOut=socket.getOutputStream(); //��������
    //����HTTP��Ӧ�ĵ�һ��
    socketOut.write(responseFirstLine.getBytes());
    //����HTTP��Ӧ��ͷ
    socketOut.write(responseHeader.getBytes());
    //����HTTP��Ӧ������
    int len=0;
    byte[] buffer=new byte[128];
    while((len=in.read(buffer))!=-1)
    socketOut.write(buffer,0,len);  
    
    Thread.sleep(1000);  //˯��1�룬�ȴ��ͻ�����HTTP��Ӧ���        
    socket.close(); //�ر�TCP����  
    
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
