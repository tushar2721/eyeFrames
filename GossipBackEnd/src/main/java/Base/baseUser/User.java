package Base.baseUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="users")
public class User {
	
	@Id
	private String id;
	private String name,password,email,mobile,address,pincode,gender;
	private List<String> reqsend = new ArrayList <String>();
	private List<String> reqreceived = new ArrayList <String>();
	private List<String> frnds = new ArrayList <String>();
	
    private String profilePicUrl;
	
	public String getProfilePicUrl() {
		return profilePicUrl;
	}
	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getReqsend() {
		return reqsend;
	}
	public void setReqsend(List<String> reqsend) {
		this.reqsend = reqsend;
	}
	public List<String> getReqreceived() {
		return reqreceived;
	}
	public void setReqreceived(List<String> reqreceived) {
		this.reqreceived = reqreceived;
	}
	public List<String> getFrnds() {
		return frnds;
	}
	public void setFrnds(List<String> frnds) {
		this.frnds = frnds;
	}
	
}
