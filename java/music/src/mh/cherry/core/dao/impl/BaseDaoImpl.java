package mh.cherry.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import mh.cherry.core.dao.BaseDao;
import mh.cherry.core.utils.BeanUtils;
import mh.cherry.core.utils.JDBCUtils;

public class BaseDaoImpl<T> implements BaseDao<T>{

	Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
		clazz=(Class<T>) type.getActualTypeArguments()[0];
	}
	
	@Override
	public List<T> getAll() {
		List<T> list=new ArrayList<T>();
		ResultSet rs=null;
		ResultSetMetaData rsd=null;
		StringBuilder sb=null;
		PreparedStatement pr=null;
		Connection con=JDBCUtils.getConnection();
		try {
			pr=con.prepareStatement("SELECT * FROM "+clazz.getSimpleName());
			if(pr.execute()){
				rs=pr.getResultSet();
				rsd=rs.getMetaData();
				T obj=null;
				while(rs.next()){
					obj=clazz.newInstance();
					//自制beanutils= =  
					for(int i=0;i<rsd.getColumnCount();i++){
						sb=new StringBuilder(rsd.getColumnLabel(i+1));
						if(sb.indexOf("_")!=-1){
						int m=sb.indexOf("_");
						char c=(char) (sb.charAt(m+1)-32);
						sb.replace(m,m+2,String.valueOf(c));
						}
						BeanUtils.setField(obj,sb.toString(),rs.getObject(i+1));
					}
					list.add(obj);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeCon(con, pr, rs);
		}
		return list;
	}

	@Override
	public T findObjectById(Serializable id) {
		T obj=null;
		Connection con=null;
	    PreparedStatement pst=null;
		ResultSet rs=null;
		ResultSetMetaData rsd=null;
		StringBuilder sb=null;
		try {
			con=JDBCUtils.getConnection();
			pst=con.prepareStatement("SELECT * FROM "+clazz.getSimpleName()+" WHERE "+clazz.getSimpleName()+"_ID=?");
			pst.setObject(1, id);
			if(pst.execute()){
				rs=pst.getResultSet();
				rsd=rs.getMetaData();
				if(rs.next()){
					obj=clazz.newInstance();
					for(int i=0;i<rsd.getColumnCount();i++){
						sb=new StringBuilder(rsd.getColumnLabel(i+1));
						if(sb.indexOf("_")!=-1){
						int m=sb.indexOf("_");
						char c=(char) (sb.charAt(m+1)-32);
						sb.replace(m,m+2,String.valueOf(c));
						}
						BeanUtils.setField(obj, sb.toString(),rs.getObject(i+1));
					}
				}
				return obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeCon(con, pst, rs);
		}
		return obj;
	}
    
	/**
	 * 注意这里并没有开启事务============= 事务优化的时候再来
	 */
	@Override
	public void save(T entity) {
		//这里耦合性比较高  所以本王用上了反射等一系列的技术= = = =  秘制麻烦= =解耦太麻烦 = =  ............算了  不弄了
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Map<String, Object> map=null;
		StringBuilder sql=null;
		try {
			con=JDBCUtils.getConnection();
			//获取表的列名
			DatabaseMetaData dmd=con.getMetaData();
			List<String> list=new ArrayList<String>();
			rs=dmd.getColumns(null, "%", clazz.getSimpleName(),"%");
			while(rs.next()){
				list.add(rs.getString("CoLUMN_NAME"));
			}
			map=BeanUtils.getFiledName(entity, list);
			Set<Entry<String,Object>> set=map.entrySet();
			List<Object> lis=new ArrayList<Object>();
			sql=new StringBuilder("INSERT INTO "+clazz.getSimpleName()+"(");
			for(Entry<String,Object> entry:set){
				sql.append(entry.getKey()+",");
				lis.add(entry.getValue());
			}
			sql.deleteCharAt(sql.lastIndexOf(","));
			sql.append(") VALUES(");
			for(Entry<String,Object> entry:set){
				sql.append("?"+",");
			}
			sql.deleteCharAt(sql.lastIndexOf(","));
			sql.append(")");
			pst=con.prepareStatement(sql.toString());
			int en=1;
			for(Object obj:lis){
				pst.setObject(en++, obj);
			}
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeCon(con, pst, rs);
		}
	}

	@Override
	public void update(T entity) {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Map<String, Object> map=null;
		StringBuilder sql=null;
		try {
			con=JDBCUtils.getConnection();
			//获取表的列名
			DatabaseMetaData dmd=con.getMetaData();
			List<String> list=new ArrayList<String>();
			rs=dmd.getColumns(null, "%", clazz.getSimpleName(),"%");
			while(rs.next()){
				list.add(rs.getString("COLUMN_NAME"));
			}
			map=BeanUtils.getFiledName(entity, list);
			Set<Entry<String,Object>> set=map.entrySet();
			sql=new StringBuilder("UPDATE "+clazz.getSimpleName()+" SET ");
			List<Object> lis=new ArrayList<Object>();
			for(Entry<String,Object> entry:set){
				sql.append(entry.getKey()+"=?,");
				lis.add(entry.getValue());
			}
			sql.deleteCharAt(sql.lastIndexOf(","));
			sql.append(" WHERE "+clazz.getSimpleName()+"_id=?");
			pst=con.prepareStatement(sql.toString());
			int en=1;
			for(Object obj:lis){
				pst.setObject(en++, obj);
			}
			pst.setObject(en,map.get(clazz.getSimpleName().toLowerCase()+"_id"));
			System.out.println(pst.toString());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeCon(con, pst, rs);
		}
		
	}

	@Override
	public void delete(Serializable id) {
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=JDBCUtils.getConnection();
			pst=con.prepareStatement("DELETE FROM "+clazz.getSimpleName()+" WHERE "+clazz.getSimpleName()+"_id=?");
			pst.setObject(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
