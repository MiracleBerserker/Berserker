package mh.cherry.core.framework;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mh.cherry.core.framework.bean.ActionMapping;
import mh.cherry.core.framework.bean.ActionMappingManager;
import mh.cherry.core.framework.bean.Result;

public class ActionServlet extends HttpServlet{
    
	private ActionMappingManager amm=null;
	
	@Override
	public void init() throws ServletException {
		System.out.println("自制struts初始化成功");
		amm=new ActionMappingManager();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
			String uri=req.getRequestURI();
			String [] ps=uri.split("/");
			String aname=ps[ps.length-2];
			String mname=ps[ps.length-1].substring(0,ps[ps.length-1].lastIndexOf("."));
			ActionMapping am=amm.getActionMapping(aname);
			String className=am.getClassName();
			Class<?> clazz=Class.forName(className);
			Object obj=clazz.newInstance();
			Method mt=clazz.getDeclaredMethod(mname,HttpServletRequest.class,HttpServletResponse.class);
			String tname=(String) mt.invoke(obj,req, resp);
			if(tname!=null&&"".equals(tname)){
				Result rs=am.getResults().get(tname);
				if(rs.getType().equals("dispatcher")){
					req.getRequestDispatcher(rs.getPage()).forward(req, resp);
				}else{
					resp.sendRedirect(rs.getPage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}
}
