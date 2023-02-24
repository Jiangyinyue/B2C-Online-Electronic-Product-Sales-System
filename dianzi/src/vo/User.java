package vo;

public class User {
	private String username;
	private String userpass;
	private String truename;
	private String address;
	private String tel;
	
	public User(String username, String userpass) {
		super();
		this.username = username;
		this.userpass = userpass;
	}
	
	public User(String username) {
		super();
		this.username = username;
	}
	
	public User(String username, String userpass,String address,String truename,String tel) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.truename = truename;
		this.address = address;
		this.tel = tel;
	}
	
	public User() {
		super();
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
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
