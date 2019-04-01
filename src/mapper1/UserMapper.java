package mapper1;

import java.util.List;

import bean.User;

public interface UserMapper
{

	// 1 接口方法名 与mapper.xml 中的 要调用的sql 语句的id 要一致
	// 2 接口的形参类型需要与 mappe.xml parameterType 一致
	// 3 返回值类型也需要 与 resultType相一致
	// 4 mapper.xml 中 namespace 要与接口的全包名一致
	// 5 mapper 动态代理开发中 根据返回值类型自动选择 selectOne （id查询） selectList （模糊查询）

	public User selectUserById(Integer id);

	// public List<User> User selectUser(User user);
	// 再来一遍
	// 接口方法名要与 调用的sql的语句中的id 一致
	// 接口的类型要与 parameterType 一致
	// 返回值类型要与 resultType 一致

	public List<User> selectUserByName(String username);

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUserById(int id);

}
