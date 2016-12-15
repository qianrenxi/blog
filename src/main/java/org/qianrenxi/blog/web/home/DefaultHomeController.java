package org.qianrenxi.blog.web.home;

import org.qianrenxi.blog.entity.Article;
import org.qianrenxi.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultHomeController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping(value={"", "index", "index.html", "index.htm"})
	public String index(Model model){
		Pageable pageable = new PageRequest(0, 10, Direction.DESC, "id");
		Page<Article> latestArticles = articleService.getLatestArticles(pageable);
		
		model.addAttribute("latestArticles", latestArticles);
		
		return "home/index";
	}
}
