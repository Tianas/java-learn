package spring.services;

import org.springframework.stereotype.Component;

/**
 * Created by hzsuntingting on 2017/1/23.
 */

@Component("addService")
public class AddServiceImpl implements AddService {

    public int ajaxAdd(int data1, int data2){
        return data1+data2;
    }
}
