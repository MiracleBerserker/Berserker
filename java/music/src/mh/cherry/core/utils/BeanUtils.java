package mh.cherry.core.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtils {
    /**
     * 这个方法有一个小问题  待解决
     * @param obj
     * @param fieldName
     * @param fiedlValue
     */
	public static void setField(Object obj,String fieldName,Object fieldValue){
		if(fieldValue==null||"".equals(fieldValue)){
			
		}else{
		Field field=null;
		for(Class<?> su=obj.getClass();su!=Object.class;su=su.getSuperclass()){
			try {
				field=su.getDeclaredField(fieldName);//只能获取本类里面的所有字段
				break;
			} catch (NoSuchFieldException e) {
				System.out.println("继续向上转型");
			}
		}
		if(field==null){
			System.out.println("找不到该字段");
		}else{
			if(!Modifier.isPublic(field.getModifiers())){
				field.setAccessible(true);
			}
			try {
				field.set(obj, fieldValue);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	  }
	}
	/**
	 * 这个方法本身是具有一个小问题 也是扫描的是字段而不是set方法
	 * @param obj
	 * @return
	 */
	public static Map<String,Object> getFiledName(Object obj,List<String> list){
		Map<String,Object> map=new HashMap<String,Object>();
		Field field=null;
		StringBuilder sb=null;
		String st=null;
		for (String str : list) {
			sb=new StringBuilder(str);
			int m=sb.indexOf("_");
			sb.replace(m, m+2,String.valueOf((char)(sb.charAt(m+1)-32)));
			st=sb.toString();
			for(Class<?> su=obj.getClass();su!=Object.class;su=su.getSuperclass()){
				try {
					field=su.getDeclaredField(st);
					break;
				} catch (NoSuchFieldException e) {
					System.out.println("继续向上转型");
				}
			}
			if(field==null){
				System.out.println("没有此字段");
			}else{
				if(!Modifier.isPublic(field.getModifiers())){
					field.setAccessible(true);
				}
				try {
					map.put(str, field.get(obj));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			field=null;
			st=null;
		}
		return map;
		
	}
	
}
