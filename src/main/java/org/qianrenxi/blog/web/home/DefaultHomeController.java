package org.qianrenxi.blog.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultHomeController {

	@RequestMapping(value={"", "index", "index.html", "index.htm"})
	public String index(){
		
		return "index";
	}
}
