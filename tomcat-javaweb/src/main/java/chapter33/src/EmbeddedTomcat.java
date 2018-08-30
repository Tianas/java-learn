//import java.net.URL;
//import java.net.InetAddress ;
//import org.apache.catalina.connector.Connector;
//import org.apache.catalina.Context;
//import org.apache.catalina.Engine;
//import org.apache.catalina.Host;
//import org.apache.catalina.startup.Embedded;
//import org.apache.catalina.Container;
//
//public class EmbeddedTomcat {
//
//  private String path = null;
//  private Embedded embedded = null;
//  private Host host = null;
//
//  public EmbeddedTomcat() { }
//
//  /** ����Tomcat�ĸ�·�� */
//  public void setPath(String path) {
//    this.path = path;
//  }
//
//  /** ����Tomcat�ĸ�·�� */
//  public String getPath() {
//    return path;
//  }
//
//  /** ����Tomcat������ */
//  public void startTomcat() throws Exception {
//
//    Engine engine = null;
//
//    //����catalina.homeϵͳ����
//    System.setProperty("catalina.home", getPath());
//
//    //����Ƕ��ʽTomcat������
//    embedded = new Embedded();
//
//    //����Engineʵ��
//    engine = embedded.createEngine();
//    engine.setDefaultHost("localhost");
//
//    //����Ĭ�ϵ�Hostʵ��
//    host = embedded.createHost("localhost", getPath() + "/webapps");
//    engine.addChild(host);
//
//    //����ROOT context
//    Context context = embedded.createContext("",  getPath() + "webapps/ROOT");
//    host.addChild(context);
//
//    //����examples context
//    Context examplesContext = embedded.createContext("/examples",
//     getPath() + "webapps/examples");
//    host.addChild(examplesContext);
//
//    //��Engineʵ�����뵽Ƕ��ʽTomcat������
//    embedded.addEngine(engine);
//
//    //�����Ͱ�װĬ�ϵ�HTTP connector
//    InetAddress addr=null;
//    Connector connector = embedded.createConnector(addr, 8080, false);
//    embedded.addConnector(connector);
//
//    //����Ƕ��ʽTomcat������
//    embedded.start();
//  }
//
//  /** ��ֹǶ��ʽTomcat������  */
//  public void stopTomcat() throws Exception {
//    embedded.stop();
//  }
//
//  public static void main(String args[]) {
//    try {
//      EmbeddedTomcat tomcat = new EmbeddedTomcat();
//      String rootpath=null;
//	if(args.length>0)
//	   rootpath=args[0];
//	else
//         throw new Exception("Tomcat's root path is unknown.");
//      tomcat.setPath(rootpath);
//      tomcat.startTomcat();
//      Thread.sleep(1000*60*60); //˯��1Сʱ
//      tomcat.stopTomcat();
//      System.exit(0);
//    }
//    catch( Exception e ) {
//      e.printStackTrace();
//    }
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
