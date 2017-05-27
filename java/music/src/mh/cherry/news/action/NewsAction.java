package mh.cherry.news.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mh.cherry.news.entity.News;
import mh.cherry.news.service.NewsService;
import mh.cherry.news.service.impl.NewsServiceImpl;

public class NewsAction {

	private NewsService newService=new NewsServiceImpl();
	
	
	public String list(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("utf-8");
		List<News> newses=newService.getAll();
		req.setAttribute("newses", newses);
		return "list";
	}
}
