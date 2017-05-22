package mh.cherry.core.framework.bean;


/**
 *对应的结果集
 * @author Administrator
 *
 */
public class Result {
    //跳转结果标记
	private String name;
	//跳转类型  重定向 还是转发
	private String type;
	//跳转页面
	private String page;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "Result [name=" + name + ", type=" + type + ", page=" + page
				+ "]";
	}
	
}
