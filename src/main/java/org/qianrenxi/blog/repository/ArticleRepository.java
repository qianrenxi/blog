package org.qianrenxi.blog.repository;

import org.qianrenxi.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	Article findByAlias(String alias);
}
