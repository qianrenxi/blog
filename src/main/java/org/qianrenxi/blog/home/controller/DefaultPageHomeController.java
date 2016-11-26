package org.qianrenxi.blog.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultPageHomeController {

	@RequestMapping(value={"", "index", "index.html", "index.htm"})
	public String index(){
		
		return "index";
	}
}
