package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.User;


public class UserDao {
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
	
	public List<User> getAll(){
		List<User> list=new ArrayList<User>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from takeuser");
			rs=ps.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setTruename(rs.getString("truename"));
				user.setAddress(rs.getString("address"));
				user.setTel(rs.getString("tel"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	public List<User> getMessage(String username){
		List<User> list=new ArrayList<User>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from takeuser where username='"+username+"'");
			rs=ps.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setTruename(rs.getString("truename"));
				user.setAddress(rs.getString("address"));
				user.setTel(rs.getString("tel"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	public List<User> getMyMessage(String username,String pass){
		List<User> list=new ArrayList<User>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from takeuser where username='"+username+"' and userpass='"+pass+"'");
			rs=ps.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setTruename(rs.getString("truename"));
				user.setAddress(rs.getString("address"));
				user.setTel(rs.getString("tel"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	public void insert(User user){
		this.getConnection();
		try {
			ps= conn.prepareStatement("insert into takeuser values(?,?,?,?,?)");
	
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getUserpass());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getTruename());
			ps.setString(5, user.getTel());
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}
	}

	public void update(User user){
		this.getConnection();
		try {
			ps=conn.prepareStatement("update takeuser set userpass='"+user.getUserpass()+"' ,truename='"+user.getTruename()+"',address='"+user.getAddress()+"',tel='"+user.getTel()+"' where username='"+user.getUsername()+"'");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}		
	}
	
	
	public void delete(String username){
		this.getConnection();
		try {
			ps=conn.prepareStatement("delete from takeuser where username='"+username+"'");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}		
	}
}
