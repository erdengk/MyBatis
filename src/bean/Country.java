package bean;

public class Country
{
	private Integer id;
	private String c_countryname;
	private String c_capital;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getC_countryname()
	{
		return c_countryname;
	}

	public void setC_countryname(String c_countryname)
	{
		this.c_countryname = c_countryname;
	}

	public String getC_capital()
	{
		return c_capital;
	}

	public void setC_capital(String c_capital)
	{
		this.c_capital = c_capital;
	}

	public String toString()
	{
		return "Country [id=" + id + ", c_countryname=" + c_countryname
				+ ", c_capital=" + c_capital + "]";
	}

}
