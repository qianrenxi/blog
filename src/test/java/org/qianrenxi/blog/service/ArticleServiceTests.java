package org.qianrenxi.blog.service;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.qianrenxi.blog.entity.Article;
import org.qianrenxi.blog.entity.Author;
import org.qianrenxi.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTests {
	
	static final Logger logger = LoggerFactory.getLogger(ArticleServiceTests.class);
	
	@Autowired
	ArticleService articleService;
	
	@Value("= 这是一级标题\nZhang San <zhangsan@qq.com>; Li Si <lisi@qq.com>\n:title: 这才是标题呢\n\n 隔一行后才是内容")
	String content;
	
	@Value("= 这是一级标题\nWang Wu <wangwu@qq.com>; Li Si <lisi@qq.com>\n:title: 这才是标题呢\n\n 隔一行后才是内容")
	String contentPost;
	
	//@Before
	public void createArticle(){
		Article article = new Article();
		article.setTheOriginal(content);
		logger.info("原文:\n{}", article.getTheOriginal());
		
		articleService.save(article);
		logger.info("第一次解析\n 标题：{} \n 作者：{} \n内容:\n{}", article.getTitle(), article.getAuthors(), article.getContent());
	} 
	
	//@Test
	public void testSaveArticle(){
		Article article = new Article();
		article.setId(1L);
		article.setTheOriginal(contentPost);
		
		article = articleService.save(article);
		logger.info("第二次解析\n 标题：{} \n 作者：{} \n内容:\n{}", article.getTitle(), article.getAuthors(), article.getContent());
		
		List<Author> authors = articleService.allAuthors();
		logger.info(authors.toString());
	}
	
	@Test
	public void testArticleList(){
		Date begin = new Date();
		Page<Article> articles = articleService.articleList(new Article(), new PageRequest(0, 10));
		Date end = new Date();
		double len = (end.getTime() - begin.getTime());
		logger.info("It cost {} ms for loading article list.", len);
	}
}
