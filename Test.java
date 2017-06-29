package example2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import org.apache.commons.dbutils.*;
import org.apache.log4j.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Test {

	final static Logger logger = Logger.getLogger(Test.class);
	final static String USER_INFO = "SELECT name FROM smartphone where id = ?;";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("Test main started.");
		logger.debug("debug test.");

		//MysqlDataSource dataSource = new MysqlDataSource(); //TODO spring bean

		//dataSource.setUser("root");
		//dataSource.setPassword("");
		//dataSource.setUrl("jdbc:mysql://localhost:3306/phone");
        DataSource data = new DataSource("root","","jdbc:mysql://localhost:3306/phone");
        MysqlDataSource dataSource = data.getDatasource();
        	
		Connection conn = null;

		try {
			conn = dataSource.getConnection();		
			Query q = new Query(USER_INFO, conn, "1");
			q.eseguiQuery(logger,"name");
			
			//ResultSet rsUserInfoSet = q.getResultQuery();
			//PreparedStatement stmtUserInfo = conn.prepareStatement(USER_INFO);
			//stmtUserInfo.setString(1, "1");

			//ResultSet rsUserInfoSet = stmtUserInfo.executeQuery();

			//if(rsUserInfoSet.first())
			//{
			//	logger.info(rsUserInfoSet.getString("name"));
			//}
			
			/*while(rsUserInfoSet.next()){
				logger.info(rsUserInfoSet.getString("name"));
			}*/	

		}

		catch(SQLException e)	{
			logger.error(e);
		}

	}


}


