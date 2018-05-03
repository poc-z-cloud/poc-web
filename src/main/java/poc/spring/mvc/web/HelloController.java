package poc.spring.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController{
 
   @RequestMapping(value = "/hello", method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");
      return "hello";
   }

   @RequestMapping(value = "/index", method = RequestMethod.GET)
   public String index() {
	   return "index";
   }
   
   @RequestMapping(value = "/redirect", method = RequestMethod.POST)
   public String redirect() {
     
      return "redirect:finalPage";
   }
   
   @RequestMapping(value = "/finalPage", method = RequestMethod.GET)
   public String finalPage() {
     
      return "final";
   }
   
   @RequestMapping(value = "/staticPage", method = RequestMethod.GET)
   public String staticPage() {
     
      return "redirect:pages/final.htm";
   }   
}