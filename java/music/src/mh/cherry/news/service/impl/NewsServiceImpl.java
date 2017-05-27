package mh.cherry.news.service.impl;

import mh.cherry.core.service.impl.BaseServiceImpl;
import mh.cherry.news.dao.NewsDao;
import mh.cherry.news.dao.impl.NewsDaoImpl;
import mh.cherry.news.entity.News;
import mh.cherry.news.service.NewsService;

public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService{
	//这里没有框架就手动注入dao咯
	private NewsDao newsDao;
	public void setNewsDao(NewsDao newsDao) {
		this.setBaseDao(newsDao);
		this.newsDao = newsDao;
	}
	
    public NewsServiceImpl() {
		this.setNewsDao(new NewsDaoImpl());
	}
}
