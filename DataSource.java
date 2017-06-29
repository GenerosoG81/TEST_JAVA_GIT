package example2;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSource {
	
	private String root; 
	private String password;
	private String Url;
	
	DataSource(String root, String password, String Url){
		this.root=root;
		this.password=password;
		this.Url=Url;
	}
	
	public MysqlDataSource getDatasource(){
		
		MysqlDataSource dataSource = new MysqlDataSource(); 

		dataSource.setUser(root);
		dataSource.setPassword(password);
		dataSource.setUrl(Url);
		
	return  dataSource;
		
	}

}
