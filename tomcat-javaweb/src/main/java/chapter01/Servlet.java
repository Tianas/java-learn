package chapter01;

import java.io.OutputStream;

/**
 * Created by hzsuntingting on 2018/9/7.
 */
public interface Servlet {
    public void init()throws Exception;
    public void service(byte[] requestBuffer, OutputStream out)throws Exception;
}
