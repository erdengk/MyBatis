package service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserDaoTest
{
	//
	private static SqlSessionFactory ssf;
	static
	{
		String source="sqlMapConfig.xml";
		//读取配置文件
		InputStream in;
		try
		{
			in = Resources.getResourceAsStream(source);
			//需要  sqlSeesionFactotyBuliber
			SqlSessionFactoryBuilder ssfb= new SqlSessionFactoryBuilder();
			//创建sqlSessionfactory
			ssf = ssfb.build(in);
			in.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	} 
	@Test
	public void DaoTest()
	{
		UserDao dao = new UserDaoImpl(ssf);
		User user = dao.getUserById(3);
		System.out.println(user);
	}
}
