package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import mapper1.CountryMapper;
import mapper1.UserMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import bean.Country;
import bean.CountryVo;
import bean.User;
import bean.UserVo;

public class MapperTest
{
	private static final UserMapper mapper = null;

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
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setU_id(19);
		user.setU_username("小明");
		user.setU_password("1231323");
		user.setU_cid(1);
		user.setU_sex("1");
		mapper.insertUser(user);
		session.commit();// //这里一定要提交，不然数据进不去数据库中
	}

	@Test
	// 更新用户
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
		UserMapper mapper = session.getMapper(UserMapper.class);

		User user = new User();
		user.setU_id(19);
		user.setU_username("小明");
		mapper.updateUser(user);
		session.commit();

		// 相比较于 dao 层开发 需要 UserDao 及它的实现类 还有 UserMapper.xml
		// mapper 动态代理开发 只需要 一个接口 和 UserMapper.xml 加快了开发速度
	}

	@Test
	// 删除
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
		UserMapper mapper = session.getMapper(UserMapper.class);

		mapper.deleteUserById(19);
		session.commit();

		// 相比较于 dao 层开发 需要 UserDao 及它的实现类 还有 UserMapper.xml
		// mapper 动态代理开发 只需要 一个接口 和 UserMapper.xml 加快了开发速度
	}

	@Test
	// 查询 selectUserByUserVoId
	public void Test6() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		UserMapper mapper = session.getMapper(UserMapper.class);

		UserVo vo = new UserVo();
		User u = new User();

		u.setU_id(3);
		vo.setUser(u);
		User user = mapper.selectUserByUserVoId(vo);

		System.out.println(user);
	}

	@Test
	// 查询 selectUserCount
	public void Test7() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		UserMapper mapper = session.getMapper(UserMapper.class);

		Integer selectUserCount = mapper.selectUserCount();

		System.out.println(selectUserCount);
	}

	@Test
	// 查询 使用 map 映射 查询 国家
	public void Test8() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		CountryMapper mapper = session.getMapper(CountryMapper.class);

		List<Country> list = mapper.selectAll();

		for (Country country : list)
		{
			System.out.println(country);
		}

	}

	@Test
	public void Test_selectAllCountryVo() throws IOException
	{
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = ssf.openSession();

		CountryMapper mapper = session.getMapper(CountryMapper.class);

		List<CountryVo> list = mapper.selectAllCountryVo();

		for (CountryVo c : list)
		{
			System.out.println(c);
		}
	}

	@Test
	// 动态多条件查询
	public void Test9() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		UserMapper mapper = session.getMapper(UserMapper.class);

		User u = new User();
		// u.setU_sex("1");
		u.setU_cid(1);
		u.setU_username("王");
		List<User> list = mapper.selectUserListByUser(u);

		for (User user : list)
		{
			System.out.println(u);
		}
	}

	@Test
	// 动态多条件查询 trim
	public void Test10() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		UserMapper mapper = session.getMapper(UserMapper.class);

		User u = new User();
		// u.setU_sex("1");
		u.setU_cid(1);
		u.setU_username("王");
		List<User> list = mapper.selectUserListByUserTrim(u);

		for (User user : list)
		{
			System.out.println(u);
		}
	}

	@Test
	// 动态多条件修改 使用 set 标签
	public void Test11() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		UserMapper mapper = session.getMapper(UserMapper.class);

		User u = new User();
		u.setU_id(2);
		u.setU_username("王1");
		u.setU_password("123");
		// u.setU_sex("2");
		mapper.updateSetUser(u);

		// 修改完之后记得提交
		session.commit();
	}
//	
//	@Test
//	// 根据id 查询多个用户
//	public void Test12() throws IOException
//	{
//		String source = "sqlMapConfig.xml";
//		// 读取配置文件
//		InputStream in = Resources.getResourceAsStream(source);
//
//		// 需要 sqlSeesionFactotyBuliber
//		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
//
//		// 生产一个sqlSession
//		SqlSession session = ssf.openSession();
//
//		// 操作数据库
//		UserMapper mapper = session.getMapper(UserMapper.class);
//		
//		Integer[] ids = {1,3,5} ;
//		List<User> list = mapper.selectUserListByIds(ids);
//		
//		for (User user : list)
//		{
//			System.out.println(user);
//		}
//	}
	
	@Test
	// 根据list中的id 查询多个用户
	public void Test13() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		List<Integer> idList = new ArrayList<Integer>();
		
		idList.add(2);
		idList.add(3);
		idList.add(4);
		
		List<User> list = mapper.selectUserListByList(idList);
		
		for (User user : list)
		{
			System.out.println(user);
		}
	}
	
	
	@Test
	// 根据包装类 查询多个用户
	public void Test14() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		
		List<Integer> idList = new ArrayList<Integer>();
		
		idList.add(2);
		idList.add(3);
		idList.add(4);
		
		UserVo vo = new UserVo();
		vo.setIdList(idList);
		
		List<User> list = mapper.selectUserListByUserVo(vo);
		
		for (User user : list)
		{
			System.out.println(user);
		}
	}
	
	
}






