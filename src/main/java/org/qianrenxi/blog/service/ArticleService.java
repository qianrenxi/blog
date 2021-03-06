package org.qianrenxi.blog.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.ast.DocumentHeader;
import org.joda.time.DateTime;
import org.qianrenxi.blog.entity.Article;
import org.qianrenxi.blog.entity.Author;
import org.qianrenxi.blog.entity.ReversionInfo;
import org.qianrenxi.blog.repository.ArticleRepository;
import org.qianrenxi.blog.repository.AuthorRepository;
import org.qianrenxi.blog.utils.asciidoctor.AsciidoctorHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
	static final Logger logger = LoggerFactory.getLogger(ArticleService.class);
	
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	AuthorRepository authorRepository;
	
	public Page<Article> articleList(Example<Article> example, Pageable pageable){
		return articleRepository.findAll(example, pageable);
	}
	
	public Page<Article> articleList(Article article, Pageable pageable){
		Example<Article> example = Example.of(article);
		return articleList(example, pageable);
	}
	
	public Article getOne(Long id){
		return articleRepository.findOne(id);
	}
	
	public Article getOne(String alias){
		return articleRepository.findByAlias(alias);
	}
	
	public Article save(Article article){
		parseContent(article);
		return articleRepository.saveAndFlush(article);
	}
	
	public void delete(Long id){
		articleRepository.delete(id);
	}
	
	public void delete(List<Long> ids){
		for (Long id : ids) {
			delete(id);
		}
	}
	
	public Page<Article> getLatestArticles(Pageable pageable){
		return articleRepository.findAll(pageable);
	}
	
	protected void parseContent(Article article){
		String theOriginal = article.getTheOriginal();
		logger.info("ASCIIdoctor 解析原文:\n{}", theOriginal);
		if(StringUtils.isNotBlank(theOriginal)){
			Asciidoctor asciidoctor = AsciidoctorHelper.getAsciidoctor();
			Options options = AsciidoctorHelper.getDefaultOptions();
			
			String html =asciidoctor.convert(theOriginal, options);
			article.setContent(html);
			
			DocumentHeader header = asciidoctor.readDocumentHeader(theOriginal);
			
			//article.setTitle(header.getDocumentTitle().getMain());
			article.setTitle(header.getPageTitle());
			
			List<org.asciidoctor.ast.Author> astAuthors = header.getAuthors();
			if (astAuthors.isEmpty() && null!=header.getAuthor()) {
				astAuthors.add(header.getAuthor());
			}
			for (org.asciidoctor.ast.Author astAuthor : astAuthors) {
				String fullName = astAuthor.getFullName();
				String email = astAuthor.getEmail();
				Author author = authorRepository.findByEmail(email);
				if(null == author){
					author = new Author(fullName, email, null);
				}
				article.addAuthor(author);
			}
			
			String version = header.getRevisionInfo().getNumber();
			String date = header.getRevisionInfo().getDate();
			String remark = header.getRevisionInfo().getRemark();
			ReversionInfo reversionInfo = new ReversionInfo(null!=date ? DateTime.parse(date).toDate() : null, version, remark);
			article.setReversionInfo(reversionInfo);
		}
	}
	
	
	public List<Author> allAuthors(){
		return authorRepository.findAll();
	}
}
