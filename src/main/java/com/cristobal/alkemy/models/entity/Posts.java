package com.cristobal.alkemy.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="post")
public class Posts {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "seq_post")
	@SequenceGenerator(name = "seq_post", sequenceName = "seq_post", allocationSize = 1, initialValue= 5)
	@Column(name = "post_id")
	private int id;
	
	@Column(name = "title",  length = 100)
	private String title;
	
	@Column(name = "content",  length = 4000)
	private String content;
	
	@Column(name = "image", length = 20)
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "categories_id", nullable = false, foreignKey = @ForeignKey(name = "FK_post_categories_id"))
	private Categories categorie;
	
	@Column(name = "dates")
	@Temporal(TemporalType.DATE)
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Categories getCategorie() {
		return categorie;
	}

	public void setCategoria(Categories categorie) {
		this.categorie = categorie;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Posts [id=" + id + ", title=" + title + ", content=" + content + ", image=" + image + ", categoria="
				+ categorie + ", date=" + date + "]";
	}
	
	
	
	
	
	

}
