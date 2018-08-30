//
//package mypack;
//import javax.mail.*;
//import javax.mail.internet.*;
//import java.util.*;
//import java.text.*;
//
//public class PMessage{
//
//  private String subject="";  //�ʼ�����
//  private String from=""; //�ʼ������ߵ�ַ
//  private String to="";  //�ʼ����յ�ַ�б�
//  private String cc="";  //�ʼ����͵�ַ�б�
//  private String bcc=""; //�ʼ��㲥��ַ�б�
//  private String date=new Date().toString(); //�ʼ����ͻ��������
//  private int size=0; //�ʼ���С
//  private String text=""; //�ʼ�����
//  private boolean readFlag; //�ʼ��Ƿ��Ѷ���־
//
//  public PMessage(){}
//
//  public PMessage(Message msg)throws Exception{
//    if(msg!=null){
//      SimpleDateFormat df = new SimpleDateFormat("yy.MM.dd 'at' HH:mm:ss ");
//      try{
//        date=df.format(
//          (msg.getSentDate()!=null) ? msg.getSentDate() : msg.getReceivedDate());
//      }catch(Exception e){date=new Date().toString();}
//
//      subject=msg.getSubject();
//      size=msg.getSize();
//      Object content=null;
//      try{
//        content=msg.getContent();
//      }catch(Exception e){}
//
//      if(msg.isMimeType("text/plain") && content!=null)
//        text=(String)content;
//
//      from=assembleAddress(msg.getFrom());
//      to=assembleAddress(msg.getRecipients(Message.RecipientType.TO));
//      cc=assembleAddress(msg.getRecipients(Message.RecipientType.CC));
//      bcc=assembleAddress(msg.getRecipients(Message.RecipientType.BCC));
//    }
//  }
//
//  public PMessage(String to,String cc,String bcc,String subj,String text){
//    to.replace(';',',');
//    cc.replace(';',',');
//    bcc.replace(';',',');
//    this.to=to;
//    this.cc=cc;
//    this.bcc=bcc;
//    this.subject=subj;
//    this.text=text;
//  }
//
//  //��Address�����е��ʼ���ַ�б�ת��Ϊ�ַ��� ���ʼ���ַ֮���Զ��ŷָ�
//  private String assembleAddress(Address[] addr){
//    if(addr==null)return "";
//
//    String addrString="";
//    boolean tf = true;
//    for(int i = 0; i < addr.length; i++) {
//      addrString=addrString+((tf) ? " " : ", ") + getDisplayAddress(addr[i]);
//      tf = false;
//    }
//
//    return addrString;
//  }
//
//  //�����ַ�����ʽ���ʼ���ַ�������������ҳ��
//  private String getDisplayAddress(Address a) {
//    String pers = null;
//    String addr = null;
//    if(a instanceof InternetAddress &&
//            ((pers = ((InternetAddress)a).getPersonal()) != null)) {
//      addr = pers + "  "+"&lt;"+((InternetAddress)a).getAddress()+"&gt;";
//    }else
//      addr = a.toString();
//
//    return addr;
//  }
//
//  public String getFrom(){return from;}
//
//  public void setFrom(String from){
//    this.from=from==null ? "" : from;
//   }
//
//  public String getTo(){return to;}
//
//  public void setTo(String to){
//    this.to=to==null ? "" : to;
//  }
//
//  public String getCC(){return cc;}
//
//  public void setCC(String cc){
//    this.cc=cc==null ? "" : cc;
//  }
//
//  public String getBCC(){return bcc;}
//
//  public void setBCC(String bcc){
//    this.bcc=bcc==null ? "" : bcc;
//  }
//
//  public int getSize(){return size;}
//
//  public void setSize(int size){this.size=size;}
//
//  public String getDate(){return date;}
//
//  public void setDate(String date){this.date=date;}
//
//  public String getSubject(){return subject;}
//
//  public void setSubject(String subject){
//    this.subject=subject==null ? "" : subject;
//  }
//
//  public String getText(){return text;}
//
//  public void setText(String text){
//   this.text=text==null ? "" : text;
//  }
//
//  public boolean getReadFlag(){return readFlag;}
//
//  public void setReadFlag(boolean readFlag){
//    this.readFlag=readFlag;
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
