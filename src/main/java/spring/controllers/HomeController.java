package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by hzsuntingting on 2016/10/9.
 */
@Controller
public class HomeController {
    @RequestMapping({"/","/home"})
    public String showHomePage(Map<String, Object> model){
        model.put("testkey","testvalue");
        return "home";
    }
}
