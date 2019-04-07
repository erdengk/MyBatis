package mapper1;

import java.util.List;

import bean.Country;
import bean.CountryVo;

public interface CountryMapper
{
	//查询所有
	
	List <Country> selectAll(); 
	
	List<CountryVo> selectAllCountryVo();
}
