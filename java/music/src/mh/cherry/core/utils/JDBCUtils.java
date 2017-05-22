package mh.cherry.core.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * @author Administrator
 *
 */
public class JDBCUtils {
    
	/**
	 * @return
	 */
	public static Connection getConnection(){
		//System.out.println(JDBCUtils.class.getResource(""));
		//System.out.println(JDBCUtils.class.getResource("/"));
		//System.out.println(JDBCUtils.class.getClassLoader().getResource(""));
		Properties pr=new Properties();
		Connection con=null;
		try {
			pr.load(JDBCUtils.class.getResourceAsStream("/database.properties"));
			Class.forName(pr.getProperty("driver"));
			con = DriverManager.getConnection(pr.getProperty("url"),pr);
		} catch (Exception e) {
		     e.printStackTrace();
		}
		return con;
	}
	/**
	 * 
	 */
	public static void closeCon(Connection con){
		try {
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeCon(Connection con,Statement st){
		try {
			if(st!=null){
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeCon(Connection con,PreparedStatement pst){
		try {
			if(pst!=null){
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeCon(Connection con,PreparedStatement pst,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pst!=null){
					pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(con!=null){
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
