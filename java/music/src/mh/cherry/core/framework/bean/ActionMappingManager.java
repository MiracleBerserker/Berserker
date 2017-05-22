package mh.cherry.core.framework.bean;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 加载xml配置文件 通过dom4j来解析
 * @author Administrator
 *
 */
public class ActionMappingManager {

	private Map<String,ActionMapping> actions;
	
	/**
	 * 根据请求路径名来获取对应的action的映射信息
	 */
	public ActionMapping getActionMapping(String actionName){
		if(actionName==null||"".equals(actionName)){
            throw new RuntimeException("action名称不能为空");			
		}
		ActionMapping actionMapping=actions.get(actionName);
		if(actionMapping==null){
			throw new RuntimeException("无法找到"+actionName+"对应的action");
		}
		return actionMapping;
	}
	
	//初始化构造器
	public ActionMappingManager() {
		actions =new HashMap<String,ActionMapping>();
//		加载配置文件
		init();
	}
	
	/**
	 * 开始解析xml配置文件
	 * 把xml中的所有action进行解析封装进actions
	 */
	@SuppressWarnings("unchecked")
	public void init(){
		SAXReader sr=null;
		InputStream ins=null;
		try {
			sr=new SAXReader();
			ins=this.getClass().getResourceAsStream("/mystruts.xml");
			Document doc= sr.read(ins);
			Element root= doc.getRootElement();
			Element pk=root.element("package");
			List<Element> acs=pk.elements("action");
			for (Element e : acs) {
				ActionMapping ac=new ActionMapping();
				ac.setName(e.attributeValue("name"));
				ac.setClassName(e.attributeValue("class"));
				ac.setMethod(e.attributeValue("method"));
				//封装返回结果
				Map<String,Result> results=new HashMap<String,Result>();
				Iterator<Element> it= e.elementIterator("result");
				//封装result对象
				while(it.hasNext()){
					Result result=new Result();
					Element er=it.next();
					result.setName(er.attributeValue("name"));
					result.setType(er.attributeValue("type")==null?"dispatcher":"redirect");
					result.setPage(er.getTextTrim());
					results.put(result.getName(),result);
				}
				ac.setResults(results);
				actions.put(ac.getName(),ac);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
