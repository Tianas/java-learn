package chapter01.src.server;
import java.io.*;
public class UploadServlet implements Servlet{
  public void init()throws Exception{
    System.out.println("UploadServlet is inited");
  }
  public void service(byte[] requestBuffer, OutputStream out)throws Exception{
    String request=new String(requestBuffer);

    //���HTTP�����ͷ
    String headerOfRequest=request.substring(request.indexOf("\r\n")+2,request.indexOf("\r\n\r\n"));

    BufferedReader br=new BufferedReader(new StringReader(headerOfRequest));
    String data=null;
    //��ȡboundary
    String boundary=null;
    while((data=br.readLine())!=null){
      if(data.indexOf("Content-Type")!=-1){
        boundary=data.substring(data.indexOf("boundary=")+9,data.length())+"\r\n";
        break;
      }
    }
    
    if(boundary==null){
      out.write("HTTP/1.1 200 OK\r\n".getBytes());
      //����HTTP��Ӧͷ
      out.write("Content-Type:text/html\r\n\r\n".getBytes());
      //����HTTP��Ӧ����
      out.write("Uploading is failed".getBytes());
      return;
    }
    
    //��һ��boundary���ֵ�λ��
    int index1OfBoundary=request.indexOf(boundary);    
    //�ڶ���boundary���ֵ�λ��
    int index2OfBoundary=request.indexOf(boundary,index1OfBoundary+boundary.length());
    //������boundary���ֵ�λ��
    int index3OfBoundary=request.indexOf(boundary,index2OfBoundary+boundary.length());
    //�ļ����ֵ����Ĳ��ֵĿ�ʼǰ��λ��    
    int beforeOfFilePart=request.indexOf("\r\n\r\n",index2OfBoundary)+3;
    //�ļ����ֵ����Ĳ��ֵĽ������λ��
    int afterOfFilePart=index3OfBoundary-4;
    //�ļ����ֵ�ͷ�ĵ�һ�н������λ��
    int afterOfFilePartLine1=request.indexOf("\r\n",index2OfBoundary+boundary.length());
    //�ļ����ֵ�ͷ�ĵڶ���   
    String header2OfFilePart=request.substring(index2OfBoundary+boundary.length(),afterOfFilePartLine1);
    //�ϴ��ļ�������
    String fileName=header2OfFilePart.substring(header2OfFilePart.lastIndexOf("\\")+1,header2OfFilePart.length()-1);
    //�ļ����ֵ����Ĳ���֮ǰ���ַ������ֽڳ���
    int len1=request.substring(0,beforeOfFilePart+1).getBytes().length;
    //�ļ����ֵ����Ĳ���֮����ַ������ֽڳ���
    int len2=request.substring(afterOfFilePart,request.length()).getBytes().length; 
    //�ļ����ֵ����Ĳ��ֵ��ֽڳ���
    int fileLen=requestBuffer.length-len1-len2;

    /* ���ļ����ֵ����Ĳ��ֱ��浽�����ļ�ϵͳ�� */
    FileOutputStream f=new FileOutputStream("server\\root\\"+fileName);
    f.write(requestBuffer,len1,fileLen);
    f.close();  
   
    /*����������HTTP��Ӧ*/
    //����HTTP��Ӧ��һ��
    out.write("HTTP/1.1 200 OK\r\n".getBytes());
    //����HTTP��Ӧͷ
    out.write("Content-Type:text/html\r\n\r\n".getBytes());
    //����HTTP��Ӧ����
    out.write("<html><head><title>HelloWorld</title></head><body>".getBytes());
    out.write(new String("<h1>Uploading is finished.<br></h1>").getBytes());
    out.write(new String("<h1>FileName:"+fileName+"<br></h1>").getBytes());
    out.write(new String("<h1>FileSize:"+fileLen+"<br></h1></body><head>").getBytes());

  }
}



/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
