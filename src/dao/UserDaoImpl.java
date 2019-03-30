package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.User;

public class UserDaoImpl implements UserDao
{
	//
	private SqlSessionFactory ssf;
	//通过构造器  给 ssf 赋值
	public UserDaoImpl(SqlSessionFactory ssf)
	{
		super();
		this.ssf = ssf;
	}
	public User getUserById(Integer id)
	{
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		// 第一个参数 要操作的sql语句    第二个是sql语句的参数  
		return session.selectOne("UserMapper.selectUserById",id );
	}

}
