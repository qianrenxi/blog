package org.qianrenxi.blog.web.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.qianrenxi.blog.entity.Article;
import org.qianrenxi.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/article")
public class ArticleAdminController {
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/list")
	public String articleList(Article article, Pageable pageable, Model model){
		Page<Article> articles = articleService.articleList(article, pageable);
		
		model.addAttribute("articles", articles);
		
		return "admin/article/article-list";
	}
	
	@RequestMapping("/add")
	public String add(Model model){
		model.addAttribute("article", new Article());
		
		return "admin/article/article-edit";
	}
	
	@RequestMapping("/{articleId}/edit")
	public String edit(@PathVariable("articleId")Long id, Model model){
		Article article = articleService.getOne(id);
		model.addAttribute("article", article);
		
		return "admin/article/article-edit";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(Article article, Model model){
		articleService.save(article);
		
		Map<String, Object> result = new HashMap<>();
		result.put("success", true);
		return result;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("ids[]")Long[] ids){
		articleService.delete(Arrays.asList(ids));
		
		return "redirect:list";
	}
}
