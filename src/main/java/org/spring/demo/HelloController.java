package org.spring.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello-world", method = RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap, @RequestParam(value="message", required=false) String message) {
        if(message != null)
            modelMap.addAttribute("message", message);
        else
            modelMap.addAttribute("message", "Hello World, my first Spring MVC project.");

        return "hello_world";
    }
}
