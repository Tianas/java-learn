package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import services.AddService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hzsuntingting on 2016/10/18.
 */

@Controller
@RequestMapping("/datatest")
public class DataTestController {

    @Autowired
    AddService addService;

    @RequestMapping(value = "/ajaxadd.json", method = RequestMethod.POST)
    @ResponseBody
    public int ajaxadd(HttpServletRequest request){
        int data1 = ParameterUtils.optInt(request, "data1", 0);
        int data2 = ParameterUtils.optInt(request, "data2", 0);



        return addService.ajaxAdd(data1,data2);
    }
}
