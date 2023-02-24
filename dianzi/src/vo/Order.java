package vo;

public class Order {
	private int oid;
	private String sellername;
	private String username;
	private String goodsname;
	private String flag;
	private float price;
	private float total;
	private int amount;
	private String address;
	private String tel;
	
	public Order() {
		super();
	}

	public Order(int oid) {
		super();
		this.oid = oid;
	}

	public Order(String sellername, String username, String goodsname,
			String flag, float price, float total, int amount,String address,String tel) {
		super();
		this.sellername = sellername;
		this.username = username;
		this.goodsname = goodsname;
		this.flag = flag;
		this.price = price;
		this.total = total;
		this.amount = amount;
		this.address = address;
		this.tel = tel;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
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

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	

}
