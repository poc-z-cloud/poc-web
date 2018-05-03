package poc.domain.model;

import java.io.Serializable;
import java.util.Date;

public class User  implements Serializable{
	private static final long serialVersionUID = 8771746118408907855L;
	
	private int userId;
	private String userName;
	private String gender;
	private Date dob;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	
}
