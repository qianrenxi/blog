package org.qianrenxi.blog.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DefaultAdminController {
	
	@RequestMapping(value={"", "/", "/index"})
	public String index() {
		
		return "admin/index";
	}
}
