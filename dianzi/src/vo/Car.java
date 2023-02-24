package vo;

public class Car {
	private int id;
	private String goodsname;
	private String sellername;
	private String username;
	
	public Car() {
		super();
	}

	public Car(int id) {
		super();
		this.id = id;
	}

	public Car(String goodsname,String sellername, String username) {
		super();
		this.goodsname = goodsname;
		this.sellername = sellername;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



}
