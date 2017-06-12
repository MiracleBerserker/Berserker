package springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestUserAction implements Controller{

	@Override
	public ModelAndView handleRequest(
			HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse) throws Exception {
	       
		   ModelAndView view=new ModelAndView();
		   view.addObject("message","连接成功");
	       view.setViewName("/WEB-INF/jsp/test/springmvc.jsp");
		return view;
	}



}

