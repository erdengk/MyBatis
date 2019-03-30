package test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;


import bean.User;
public class Test1 {
	@Test
	//通过id查询用户
	public void Test2() throws IOException
	{
		String source="sqlMapConfig.xml";
		//读取配置文件
		InputStream in = Resources.getResourceAsStream(source);
		
		//需要  sqlSeesionFactotyBuliber
		SqlSessionFactoryBuilder ssfb= new SqlSessionFactoryBuilder();
		
		//创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		
		//操作数据库
		// 第一个参数 要操作的sql语句    第二个是sql语句的参数  
		User user = session.selectOne("UserMapper.selectUserById",1 );
		
		System.out.println(user);
		
	}
	@Test
	public void Test3() throws IOException
	{
		String source="sqlMapConfig.xml";
		//读取配置文件
		InputStream in = Resources.getResourceAsStream(source);
		
		//需要  sqlSeesionFactotyBuliber
		SqlSessionFactoryBuilder ssfb= new SqlSessionFactoryBuilder();
		
		//创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		
		//操作数据库
		// 第一个参数 要操作的sql语句    第二个是sql语句的参数  
		List<User> userlist = session.selectList("UserMapper.selectUserByName","王");
		
		for(User u:userlist)
		{
			System.out.println(u);  
		}
	}
	@Test
	public void Test4() throws IOException
	{
		String source="sqlMapConfig.xml";
		//读取配置文件
		InputStream in = Resources.getResourceAsStream(source);
		
		//需要  sqlSeesionFactotyBuliber
		SqlSessionFactoryBuilder ssfb= new SqlSessionFactoryBuilder();
		
		//创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		// 第一个参数 要操作的sql语句    第二个是sql语句的参数
		User user= new User();
		
		user.setU_username("小明");
		user.setU_password("123123");
		user.setU_cid(1);
		user.setU_sex("1");
		session.insert("UserMapper.insertUser",user);
		session.commit();
	}
	@Test
	public void Test5() throws IOException
	{
		String source="sqlMapConfig.xml";
		//读取配置文件
		InputStream in = Resources.getResourceAsStream(source);
		
		//需要  sqlSeesionFactotyBuliber
		SqlSessionFactoryBuilder ssfb= new SqlSessionFactoryBuilder();
		
		//创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		// 第一个参数 要操作的sql语句    第二个是sql语句的参数
		User user= new User();
		user.setU_id(1);
		user.setU_username("小明");

		session.update("UserMapper.updateUser",user);
		session.commit();
	}
	@Test
	public void Test6() throws IOException
	{
		String source="sqlMapConfig.xml";
		//读取配置文件
		InputStream in = Resources.getResourceAsStream(source);
		
		//需要  sqlSeesionFactotyBuliber
		SqlSessionFactoryBuilder ssfb= new SqlSessionFactoryBuilder();
		
		//创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		// 第一个参数 要操作的sql语句    第二个是sql语句的参数
		session.update("UserMapper.deleteUserById",1);
		session.commit();
	}
}
