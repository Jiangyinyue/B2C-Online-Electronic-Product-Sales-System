package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import vo.Seller;

public class SellerDao {
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
	
	public List<Seller> getAll(){
		List<Seller> list=new ArrayList<Seller>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from takeseller");
			rs=ps.executeQuery();
			while(rs.next()){
				Seller s=new Seller();
				s.setSid(rs.getInt("sid"));
				s.setSellername(rs.getString("sellername"));
				s.setAddress(rs.getString("address"));
				s.setPeisong(rs.getInt("peisong"));
				s.setPhoto(rs.getString("photo"));
				s.setXiaoliang(rs.getInt("xiaoliang"));

				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	public List<Seller> getMyMessage(String username,String userpass){
		List<Seller> list=new ArrayList<Seller>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from takeseller where name='"+username+"' and pass='"+userpass+"'");
			rs=ps.executeQuery();
			while(rs.next()){
				Seller s=new Seller();
				s.setSid(rs.getInt("sid"));
				s.setSellername(rs.getString("sellername"));
				s.setAddress(rs.getString("address"));
				s.setPeisong(rs.getInt("peisong"));
				s.setPhoto(rs.getString("photo"));
				s.setXiaoliang(rs.getInt("xiaoliang"));

				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	public List<Seller> getSellername(String name){
		List<Seller> list=new ArrayList<Seller>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from takeseller where name='"+name+"'");
			rs=ps.executeQuery();
			while(rs.next()){
				Seller s=new Seller();
				s.setSid(rs.getInt("sid"));
				s.setSellername(rs.getString("sellername"));
				s.setAddress(rs.getString("address"));
				s.setPeisong(rs.getInt("peisong"));
				s.setPhoto(rs.getString("photo"));
				s.setXiaoliang(rs.getInt("xiaoliang"));

				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	
	
	public List<Seller> getSearch(String search){
		List<Seller> list=new ArrayList<Seller>();
		this.getConnection();
		try {
			if(!search.equals("")&&!search.equals("请输入商家名称进行搜索"))
				ps=conn.prepareStatement("select * from takeseller where sellername like '%"+search+"%'");
			else
				ps=conn.prepareStatement("select * from takeseller");
			rs=ps.executeQuery();
			while(rs.next()){
				Seller s=new Seller();
				s.setSid(rs.getInt("sid"));
				s.setSellername(rs.getString("sellername"));
				s.setAddress(rs.getString("address"));
				s.setPeisong(rs.getInt("peisong"));
				s.setPhoto(rs.getString("photo"));
				s.setXiaoliang(rs.getInt("xiaoliang"));

				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	public List<Seller> getDetail(String sellername){
		List<Seller> list=new ArrayList<Seller>();
		this.getConnection();
		try {	
			ps=conn.prepareStatement("select * from takeseller where sellername='"+sellername+"'");
			rs=ps.executeQuery();
			while(rs.next()){
				Seller s=new Seller();
				s.setSid(rs.getInt("sid"));
				s.setSellername(rs.getString("sellername"));
				s.setAddress(rs.getString("address"));
				s.setPeisong(rs.getInt("peisong"));
				s.setPhoto(rs.getString("photo"));
				s.setXiaoliang(rs.getInt("xiaoliang"));

				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}

	public List<Seller> getName(String name){
		List<Seller> list=new ArrayList<Seller>();
		this.getConnection();
		try {	
			ps=conn.prepareStatement("select * from takeseller where name='"+name+"'");
			rs=ps.executeQuery();
			while(rs.next()){
				Seller s=new Seller();
				s.setSid(rs.getInt("sid"));
				s.setSellername(rs.getString("sellername"));
				s.setAddress(rs.getString("address"));
				s.setPeisong(rs.getInt("peisong"));
				s.setPhoto(rs.getString("photo"));
				s.setXiaoliang(rs.getInt("xiaoliang"));

				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	public List<Seller> getOrderby(){
		List<Seller> list=new ArrayList<Seller>();
		
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from takeseller");
			
			rs=ps.executeQuery();
			while(rs.next()){
				Seller s=new Seller();
				s.setSid(rs.getInt("sid"));
				s.setSellername(rs.getString("sellername"));
				s.setAddress(rs.getString("address"));
				s.setPeisong(rs.getInt("peisong"));
				s.setPhoto(rs.getString("photo"));
				s.setXiaoliang(rs.getInt("xiaoliang"));

				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	public void updatenum(String sellername){
		this.getConnection();
		try {
			ps=conn.prepareStatement("update takeseller set xiaoliang=xiaoliang+1  where sellername='"+sellername+"'");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}		
	}
	
	public void insert(String name,String pass,String sellername,String address,int peisong,String photo,int xiaoliang){
		this.getConnection();
		try {
			ps= conn.prepareStatement("insert into takeseller(name,pass,sellername,address,peisong,photo,xiaoliang) values(?,?,?,?,?,?,?)");
	
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setString(3, sellername);
			ps.setString(4, address);
			ps.setInt(5, peisong);
			ps.setString(6,photo);
			ps.setInt(7, xiaoliang);
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}
	}
	
	public void update(String sellername,String address,int peisong,String photo){
		this.getConnection();
		try {
			ps=conn.prepareStatement("update takeseller set address='"+address+"' ,peisong="+peisong+",photo='"+photo+"' where sellername='"+sellername+"'");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}		
	}
	
	public void delete(String sellername){
		this.getConnection();
		try {
			ps=conn.prepareStatement("delete from takeseller where sellername='"+sellername+"'");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}		
	}

}
