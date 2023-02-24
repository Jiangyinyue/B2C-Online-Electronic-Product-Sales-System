package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Order;

public class OrderDao {
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
	
	public List<Order> getMyOrder(String username){
		List<Order> list=new ArrayList<Order>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from takeorder where username='"+username+"'");
			rs=ps.executeQuery();
			while(rs.next()){
				Order order=new Order();
				order.setOid(rs.getInt("oid"));
				order.setSellername(rs.getString("sellername"));
				order.setUsername(rs.getString("username"));
				order.setGoodsname(rs.getString("goodsname"));
				order.setFlag(rs.getString("flag"));
				order.setPrice(rs.getFloat("price"));
				order.setTotal(rs.getFloat("total"));
				order.setAmount(rs.getInt("amount"));
				order.setAddress(rs.getString("address"));
				order.setTel(rs.getString("tel"));
				
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	public List<Order> getSellerOrder(String sellername){
		List<Order> list=new ArrayList<Order>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from takeorder where sellername='"+sellername+"'");
			rs=ps.executeQuery();
			while(rs.next()){
				Order order=new Order();
				order.setOid(rs.getInt("oid"));
				order.setSellername(rs.getString("sellername"));
				order.setUsername(rs.getString("username"));
				order.setGoodsname(rs.getString("goodsname"));
				order.setFlag(rs.getString("flag"));
				order.setPrice(rs.getFloat("price"));
				order.setTotal(rs.getFloat("total"));
				order.setAmount(rs.getInt("amount"));
				order.setAddress(rs.getString("address"));
				order.setTel(rs.getString("tel"));
				
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	public void insert(String sellername, String username, String goodsname,String flag, float price, float total, int amount,String address,String tel){
		this.getConnection();
		try {
			ps= conn.prepareStatement("insert into takeorder(sellername,username,goodsname,flag,price,total,amount,address,tel) values(?,?,?,?,?,?,?,?,?)");
	
			ps.setString(1,sellername);
			ps.setString(2,username);
			ps.setString(3,goodsname);
			ps.setString(4,flag);
			ps.setFloat(5,price);
			ps.setFloat(6,total);
			ps.setInt(7,amount);
			ps.setString(8,address);
			ps.setString(9,tel);
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}
	}
	
	public List<Order> getAll(){
		List<Order> list=new ArrayList<Order>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from takeorder");
			rs=ps.executeQuery();
			while(rs.next()){
				Order order=new Order();
				order.setOid(rs.getInt("oid"));
				order.setSellername(rs.getString("sellername"));
				order.setUsername(rs.getString("username"));
				order.setGoodsname(rs.getString("goodsname"));
				order.setFlag(rs.getString("flag"));
				order.setPrice(rs.getFloat("price"));
				order.setTotal(rs.getFloat("total"));
				order.setAmount(rs.getInt("amount"));
				order.setAddress(rs.getString("address"));
				order.setTel(rs.getString("tel"));
				
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}

	public void updateflag(int oid){
		this.getConnection();
		try {
			ps=conn.prepareStatement("update takeorder set flag='商家已接单，派送中' where oid='"+oid+"'");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}		
	}
	
	
	public void updateshou(int oid){
		this.getConnection();
		try {
			ps=conn.prepareStatement("update takeorder set flag='买家确认收货' where oid='"+oid+"'");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}		
	}
	
	public void delete(int oid){
		this.getConnection();
		try {
			ps=conn.prepareStatement("delete from takeorder where oid="+oid);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}		
	}


}
