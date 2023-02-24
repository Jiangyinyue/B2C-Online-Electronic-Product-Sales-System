package vo;

public class Goods {
	private int fid;
	private String sellername;
	private String goodsname;
	private float price;
	private int amount;
	private String introduce;
	private String photo;
	
	public Goods() {
		super();
	}
	
	public Goods(int fid) {
		super();
		this.fid = fid;
	}

	public Goods(int fid, String sellername, String goodsname, float price,
			int amount, String introduce, String photo) {
		super();
		this.fid = fid;
		this.sellername = sellername;
		this.goodsname = goodsname;
		this.price = price;
		this.amount = amount;
		this.introduce = introduce;
		this.photo = photo;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
