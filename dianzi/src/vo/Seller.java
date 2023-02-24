package vo;

public class Seller {
	private int sid;
	private String name;
	private String pass;
	private String sellername;
	private String address;
	private int peisong;
	private String photo;
	private int xiaoliang;
	
	public Seller() {
		super();
	}

	public Seller(int sid) {
		super();
		this.sid = sid;
	}

	public Seller(int sid, String name, String pass,String sellername, String address, int peisong,
			String photo,int xiaoliang) {
		super();
		this.sid = sid;
		this.name = name;
		this.pass = pass;
		this.sellername = sellername;
		this.address = address;
		this.peisong = peisong;
		this.photo = photo;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPeisong() {
		return peisong;
	}

	public void setPeisong(int peisong) {
		this.peisong = peisong;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getXiaoliang() {
		return xiaoliang;
	}

	public void setXiaoliang(int xiaoliang) {
		this.xiaoliang = xiaoliang;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
