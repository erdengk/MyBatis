package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import mapper1.UserMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import bean.User;

public class MapperTest
{
	@Test
	public void Test1() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		// 第一个参数 要操作的sql语句 第二个是sql语句的参数
		UserMapper mapper = session.getMapper(UserMapper.class);

		User user = mapper.selectUserById(2);

		System.out.println(user);
		// 相比较于 dao 层开发 需要 UserDao 及它的实现类 还有 UserMapper.xml
		// mapper 动态代理开发 只需要 一个接口 和 UserMapper.xml 加快了开发速度
	}

	@Test
	// 模糊查询
	public void Test2() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		// 第一个参数 要操作的sql语句 第二个是sql语句的参数
		UserMapper mapper = session.getMapper(UserMapper.class);

		List<User> userlist = mapper.selectUserByName("王");

		for (User u : userlist)
		{
			System.out.println(u);
		}
	}

	@Test
	// 插入用户
	public void Test3() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();
		// 操作数据库
		// 第一个参数 要操作的sql语句 第二个是sql语句的参数
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setU_id(19);
		user.setU_username("小名");
		user.setU_password("1231323");
		user.setU_cid(1);
		user.setU_sex("1");
		mapper.insertUser(user);
		session.commit();////这里一定要提交，不然数据进不去数据库中  
	}
	
	@Test
	//更新用户
	public void Test4() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		// 第一个参数 要操作的sql语句 第二个是sql语句的参数
		UserMapper mapper = session.getMapper(UserMapper.class);

		User user= new User();
		user.setU_id(19);
		user.setU_username("小明");
		mapper.updateUser(user);	
		session.commit();

		// 相比较于 dao 层开发 需要 UserDao 及它的实现类 还有 UserMapper.xml
		// mapper 动态代理开发 只需要 一个接口 和 UserMapper.xml 加快了开发速度
	}
	@Test
	//删除
	public void Test5() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		// 第一个参数 要操作的sql语句 第二个是sql语句的参数
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		
		mapper.deleteUserById(19);
		session.commit();

		// 相比较于 dao 层开发 需要 UserDao 及它的实现类 还有 UserMapper.xml
		// mapper 动态代理开发 只需要 一个接口 和 UserMapper.xml 加快了开发速度
	}
}



