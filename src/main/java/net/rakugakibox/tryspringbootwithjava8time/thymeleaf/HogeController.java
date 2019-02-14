package net.rakugakibox.tryspringbootwithjava8time.thymeleaf;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HogeController {

    @RequestMapping(value = "/hoge", method = RequestMethod.GET)
    public String getHoge(Model model,HttpServletResponse httpServletResponse) {
    	 String headerValue = CacheControl.maxAge(10, TimeUnit.SECONDS)
                 .getHeaderValue();
    	Date date= new Date();
    	 
    	 model.addAttribute("hoge", new Hoge());
    	 model.addAttribute("now", date);
     	httpServletResponse.setHeader(HttpHeaders.CACHE_CONTROL,headerValue);
        return "hoge";
    }

}
