package org.qianrenxi.blog.web.home;

import org.qianrenxi.blog.entity.Article;
import org.qianrenxi.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleHomeController {

	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/list")
	public String articleList(Article article, Pageable pageable, Model model){
		Page<Article> articles = articleService.articleList(article, pageable);
		
		model.addAttribute("articles", articles);
		
		return "home/article/article-list";
	}
	
	@RequestMapping("/{articleId}")
	public String edit(@PathVariable("articleId")Long id, Model model){
		Article article = articleService.getOne(id);
		model.addAttribute("article", article);
		
		return "home/article/article-detail";
	}
}
