package mh.cherry.user.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
		return "list";
	}
	public String editUI(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("utf-8");
		int id=Integer.valueOf(req.getParameter("id"));
		User user=userService.findObjectById(id);
		if(user==null){
			return "error";
		}
		req.setAttribute("user",user);
		return "editUI";
	}
	public String edit(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("utf-8");
        User user=new User();
        user.setUserName(req.getParameter("username"));
        user.setUserMail(req.getParameter("email"));
        user.setUserPwd(req.getParameter("password"));
        user.setUserStatus(req.getParameter("status").equals("1")?1:0);
        user.setUserRealname(req.getParameter("realname"));
        user.setUserId(Integer.valueOf(req.getParameter("id")));
        userService.update(user);
		return "relist";
		
	}
	public String delete(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("utf-8");
		int id=Integer.valueOf(req.getParameter("id"));
		userService.delete(id);
		return "relist";
	}
	public String addUI(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		return "addUI";
	}
	public String add(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("utf-8");
         User user=new User();
         user.setUserName(req.getParameter("username"));
         user.setUserMail(req.getParameter("email"));
         user.setUserPwd(req.getParameter("password"));
         user.setUserStatus(req.getParameter("status").equals("1")?1:0);
         user.setUserRealname(req.getParameter("realname"));
         userService.save(user);
		return "relist";
	}
}
