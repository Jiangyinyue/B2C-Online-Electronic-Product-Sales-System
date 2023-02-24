package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Goods;
import vo.User;

public class GoodsDao {
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
	
	public List<Goods> getDetail(String goodsname){
		List<Goods> list=new ArrayList<Goods>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from goods where goodsname='"+goodsname+"'");
			rs=ps.executeQuery();
			while(rs.next()){
				Goods a=new Goods();
				a.setFid(rs.getInt("fid"));
				a.setSellername(rs.getString("sellername"));
				a.setGoodsname(rs.getString("goodsname"));
				a.setPrice(rs.getFloat("price"));
				a.setAmount(rs.getInt("amount"));
				a.setIntroduce(rs.getString("introduce"));
				a.setPhoto(rs.getString("photo"));
				
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	public List<Goods> getSeller(String sellername){
		List<Goods> list=new ArrayList<Goods>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from goods where sellername='"+sellername+"'");
			rs=ps.executeQuery();
			while(rs.next()){
				Goods a=new Goods();
				a.setFid(rs.getInt("fid"));
				a.setSellername(rs.getString("sellername"));
				a.setGoodsname(rs.getString("goodsname"));
				a.setPrice(rs.getFloat("price"));
				a.setAmount(rs.getInt("amount"));
				a.setIntroduce(rs.getString("introduce"));
				a.setPhoto(rs.getString("photo"));
				
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	//统计的函数
	public List<Goods> getTongji(){
		List<Goods> list=new ArrayList<Goods>();
		this.getConnection();
		try {
			//按照销量统计出相关推荐
			ps=conn.prepareStatement("select * from goods order by amount desc");
			rs=ps.executeQuery();
			while(rs.next()){
				Goods a=new Goods();
				a.setFid(rs.getInt("fid"));
				a.setSellername(rs.getString("sellername"));
				a.setGoodsname(rs.getString("goodsname"));
				a.setPrice(rs.getFloat("price"));
				a.setAmount(rs.getInt("amount"));
				a.setIntroduce(rs.getString("introduce"));
				a.setPhoto(rs.getString("photo"));
				
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return list;
}

	
	public List<Goods> getGoodsMessage(String sellername,String goodsname){
		List<Goods> list=new ArrayList<Goods>();
		this.getConnection();
		try {
			ps=conn.prepareStatement("select * from goods where sellername='"+sellername+"' and goodsname='"+goodsname+"'");
			rs=ps.executeQuery();
			while(rs.next()){
				Goods a=new Goods();
				a.setFid(rs.getInt("fid"));
				a.setSellername(rs.getString("sellername"));
				a.setGoodsname(rs.getString("goodsname"));
				a.setPrice(rs.getFloat("price"));
				a.setAmount(rs.getInt("amount"));
				a.setIntroduce(rs.getString("introduce"));
				a.setPhoto(rs.getString("photo"));
				
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	public void updatenum(String goodsname,int amount){
		this.getConnection();
		try {
			ps=conn.prepareStatement("update goods set amount=amount+"+amount+" where goodsname='"+goodsname+"'");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}		
	}
	
	public void deleteGoods(String sellername){
		this.getConnection();
		try {
			ps=conn.prepareStatement("delete from goods where sellername='"+sellername+"'");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}		
	}
	
	public void insert(String sellername,String goodsname,float price,int amount,String introduce,String photo){
		this.getConnection();
		try {
			ps= conn.prepareStatement("insert into goods(sellername,goodsname,price,amount,introduce,photo) values(?,?,?,?,?,?)");
	
			ps.setString(1, sellername);
			ps.setString(2, goodsname);
			ps.setFloat(3, price);
			ps.setInt(4, amount);
			ps.setString(5,introduce);
			ps.setString(6, photo);
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}
	}
	
	public void update(String goodsname,String sellername,float price,String photo,String introduce){
		this.getConnection();
		try {
			ps=conn.prepareStatement("update goods set price="+price+" ,photo='"+photo+"',introduce='"+introduce+"' where goodsname='"+goodsname+"'");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}		
	}
	
	public void delete(int fid){
		this.getConnection();
		try {
			ps=conn.prepareStatement("delete from goods where fid="+fid);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps);
		}		
	}

}
