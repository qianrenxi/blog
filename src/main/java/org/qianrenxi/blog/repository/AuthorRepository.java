package org.qianrenxi.blog.repository;

import org.qianrenxi.blog.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	Author findByEmail(String email);
}
