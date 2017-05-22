package mh.cherry.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mh.cherry.user.entity.User;
import mh.cherry.user.service.UserService;
import mh.cherry.user.service.impl.UserServiceImpl;

public class UserAction{
	
    //这个类是多例的= =  自制struts就是酸爽
	private UserService userService=new UserServiceImpl();
	
	public String list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("utf-8");
		List<User> userList=userService.getAll();
		req.setAttribute("userList",userList);
		req.getRequestDispatcher("/WEB-INF/jsp/sys/user/index.jsp").forward(req, resp);
		return "list";
	}
}
