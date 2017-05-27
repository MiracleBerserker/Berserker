package mh.cherry.news.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer newsId;
	private String newsTitle;
	private String newsImgurl;
	private String newsAuthor;
	private String newsCategory;
	private Timestamp newsTime;
	private String newsFrom;
	private String newsContent;
	private String newsPosition;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(String newsTitle, String newsImgurl, String newsAuthor,
			String newsCategory, Timestamp newsTime, String newsFrom,
			String newsContent, String newsPosition) {
		this.newsTitle = newsTitle;
		this.newsImgurl = newsImgurl;
		this.newsAuthor = newsAuthor;
		this.newsCategory = newsCategory;
		this.newsTime = newsTime;
		this.newsFrom = newsFrom;
		this.newsContent = newsContent;
		this.newsPosition = newsPosition;
	}

	// Property accessors

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsImgurl() {
		return this.newsImgurl;
	}

	public void setNewsImgurl(String newsImgurl) {
		this.newsImgurl = newsImgurl;
	}

	public String getNewsAuthor() {
		return this.newsAuthor;
	}

	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}

	public String getNewsCategory() {
		return this.newsCategory;
	}

	public void setNewsCategory(String newsCategory) {
		this.newsCategory = newsCategory;
	}

	public Timestamp getNewsTime() {
		return this.newsTime;
	}

	public void setNewsTime(Timestamp newsTime) {
		this.newsTime = newsTime;
	}

	public String getNewsFrom() {
		return this.newsFrom;
	}

	public void setNewsFrom(String newsFrom) {
		this.newsFrom = newsFrom;
	}

	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsPosition() {
		return this.newsPosition;
	}

	public void setNewsPosition(String newsPosition) {
		this.newsPosition = newsPosition;
	}

}