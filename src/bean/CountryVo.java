package bean;

import java.util.List;

public class CountryVo extends Country {
	//需要维护一个User集合
	
	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public String toString() {
		//return "CountryVo [userList=" + userList + ", toString()=" + super.toString() + "]";
		return super.toString()  + "   userList = " + userList;
	}
	
}
