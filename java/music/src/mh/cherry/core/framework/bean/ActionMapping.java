package mh.cherry.core.framework.bean;

import java.util.Map;


/**
 * 
 * <action name="login" class="cn.itcast.framework.action.LoginAction" method="login">
			<result name="success" type="redirect">/index.jsp</result>
			<result name="loginFaild">/login.jsp</result>
   </action>
   需要封装的数据有
   name 类名
   class 类的包路径
   method 方法名
       返回的结果集      	
 * @author Administrator
 *
 */

public class ActionMapping {
  //请求路径名称
	private String name;
  //类的包路径
	private String className;
  //请求方法
	private String method;
  //结果集
	private Map<String,Result> results;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Map<String, Result> getResults() {
		return results;
	}
	public void setResults(Map<String, Result> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "ActionMapping [name=" + name + ", className=" + className
				+ ", method=" + method + ", results=" + results + "]";
	}
	
	
}
