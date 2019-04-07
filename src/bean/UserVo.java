package bean;

import java.util.List;

public class UserVo extends User
{
	//包装类
	
	// 需要全部的User对象信息
	
	private User user;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
	
	private Country country;

	public Country getCountry()
	{
		return country;
	}

	public void setCountry(Country country)
	{
		this.country = country;
	}

	public String toString()
	{
		return "UserVo [country=" + country + ", getU_id()=" + getU_id()
				+ ", getU_username()=" + getU_username() + ", getU_sex()="
				+ getU_sex() + "]";
	}

	private List<Integer> idList;

	public List<Integer> getIdList()
	{
		return idList;
	}

	public void setIdList(List<Integer> idList)
	{
		this.idList = idList;
	}
	
	
	
}
