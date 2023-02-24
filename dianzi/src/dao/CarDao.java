package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Car;

public class CarDao {
	Connection conn=null;
	PreparedStatement ps=null;
	Statement st=null;
	ResultSet rs=null;	
	String url = "jdbc:mysql://localhost:3306/dianzi?useUnicode=true&characterEncoding=utf8"; 
    String user = "root"; 
    String password = "123456"; 
		
	Connection getConnection(){
		try {
		    conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	void close(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void close(Connection conn,Statement ps){
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close(conn);
	}
	
	void close(Connection conn,Statement ps,ResultSet rs){
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close(conn, ps);
	}
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//看内容是否重复
	public List<Car> getRepeat(String username,String goodsname){
		List<Car> list=new ArrayList<Car>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from takecar where username='"+username+"' and goodsname='"+goodsname+"'");
			rs=ps.executeQuery();
			while(rs.next()){
				Car o=new Car();
				o.setId(Integer.parseInt(rs.getString("id")));
				o.setUsername(rs.getString("username"));
				o.setGoodsname(rs.getString("goodsname"));
				o.setSellername(rs.getString("sellername"));
				
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	public List<Car> getMyCar(String username){
		List<Car> list=new ArrayList<Car>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from takecar where username='"+username+"'");
			rs=ps.executeQuery();
			while(rs.next()){
				Car o=new Car();
				o.setId(Integer.parseInt(rs.getString("id")));
				o.setUsername(rs.getString("username"));
				o.setGoodsname(rs.getString("goodsname"));
				o.setSellername(rs.getString("sellername"));
				
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}

	public void insert(String goodsname,String sellername,String username){
		this.getConnection();
		try {
			ps= conn.prepareStatement("insert into takecar(goodsname,sellername,username) values(?,?,?)");
		
			ps.setString(1, goodsname);
			ps.setString(2, sellername);
			ps.setString(3, username);
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}
	}
	
	public void delete(int id){
		this.getConnection();
		try {
			ps=conn.prepareStatement("delete from takecar where id="+id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}		
	}


}
