package org.qianrenxi.blog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;



@Entity
public class Article implements Serializable {

	private static final long serialVersionUID = 6529997237502654920L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String alias;
	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Author> authors;
	@ElementCollection
	private Set<String> tags;
	@Embedded
	private ReversionInfo reversionInfo;
	
	@Lob
	private String theOriginal;
	@Lob
	private String content;
	
	@Transient
	private String link;
	
	public void addAuthor(Author author){
		if(null == authors){
			authors = new ArrayList<>();
		}
		authors.add(author);
	}
	
	public void addTag(String tag){
		if(null == tags){
			tags = new HashSet<>();
		}
		tags.add(tag);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public Set<String> getTags() {
		return tags;
	}
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	public ReversionInfo getReversionInfo() {
		return reversionInfo;
	}
	public void setReversionInfo(ReversionInfo reversionInfo) {
		this.reversionInfo = reversionInfo;
	}
	public String getTheOriginal() {
		return theOriginal;
	}
	public void setTheOriginal(String theOriginal) {
		this.theOriginal = theOriginal;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
