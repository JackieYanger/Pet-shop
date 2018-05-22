package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import 宠物商店文件版.Cat;

public class InitPanel {
	public static ArrayList<Cat>  cat_init = new ArrayList<>();
	private InitPanel() {
		try {
		       Class.forName("com.mysql.jdbc.Driver"); 
		       
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try {
			select();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static  Connection getconnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pet_shop? characterEncoding=UTF-8", "root",
                "594SHENG");
	}
	//查询记录(根据名称)

	public static int index = 0 ;
		public static void select() throws SQLException {
		
			String sql = "select  *  from Cat  " ;
			Connection c = getconnection();
			PreparedStatement s = c.prepareStatement(sql);
			  ResultSet rs = s.executeQuery(sql);			
			
	            while (rs.next()) {
	            	Cat instances = new Cat();
	                instances.name = rs.getString("name");// 可以使用字段名
	                instances. color = rs.getString("color");// 也可以使用字段的顺序
	                instances. age = rs.getString("age");
	                instances. variety = rs.getString("variety");
	                instances. cost = rs.getString("cost");
	                cat_init.add(instances);
	                HomePanel.insert_pet_init();
	          
	                 index++ ;
	            }
	             for(int i = 0 ; i < index ; i ++ )
	             {
	            	 InsertPanel.cats.add(cat_init.get(i));
	             }
	
	         
		
		}
		public static InitPanel instance = new InitPanel();
	
	public void showpanel() throws SQLException {
            
              
	}
	//增加一条记录
	public void add(String name,String color ,String age,String variety, String cost) throws SQLException {
		String sql = "insert Cat values(?,?,?,?,?)";
		Connection c1 = getconnection();
		PreparedStatement getinsql= c1.prepareStatement(sql);
		getinsql.setString(1,name);
		getinsql.setString(2, color);
		getinsql.setString(3, age);
		getinsql.setString(4, variety);
		getinsql.setString(5, cost);
		getinsql.execute();
		//ResultSet result = getinsql.getGeneratedKeys();
	   		
	}
	//删除一条记录
	public void delete(String name) throws SQLException {
		String sql = "delete from Cat where name =? ";		
		Connection c = getconnection();
		PreparedStatement getinsql = c.prepareStatement(sql);
		getinsql.setString(1, name);
		getinsql.execute();
	}
	//更新一条记录(更新名字)
		public void update(String name,String color ,String age,String variety, String cost,String newname) throws SQLException {
			String sql = "update Cat set name = ? , color = ? , age = ? ,variety= ? ,cost= ? where name = ?";
			Connection c = getconnection();
			PreparedStatement getinsql= c.prepareStatement(sql);
			getinsql.setString(1,name);
			getinsql.setString(2, color);
			getinsql.setString(3, age);
			getinsql.setString(4, variety);
			getinsql.setString(5, cost);
			getinsql.setString(6, newname);
			getinsql.execute();
		}
	public static void main(String[] args) throws SQLException {
//		    instance.select();
//			for(int  i = 0 ; i < index  ;i ++) {
//				  System.out.println( InsertPanel.cats.get(i).toString());
//			}
	}
}
