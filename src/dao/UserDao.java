package dao;

import bean.User;

public interface UserDao
{
	//根据id 查找 User
	public User getUserById(Integer id);
}
