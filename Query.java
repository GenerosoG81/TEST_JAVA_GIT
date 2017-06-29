package example2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Query {
	
	private String USER_INFO;
	private Connection conn;
	private String idstring;
	
	Query(String USER_INFO, Connection conn, String idstring){
		this.USER_INFO = USER_INFO;
		this.conn = conn;
		this.idstring = idstring;
	}
	
	public ResultSet getResultQuery() throws SQLException{
		PreparedStatement stmtUserInfo = conn.prepareStatement(USER_INFO);
		stmtUserInfo.setString(1, "1");

		ResultSet rsUserInfoSet = stmtUserInfo.executeQuery();
		return rsUserInfoSet;
	}
	
	public void eseguiQuery(Logger logger, String nome) throws SQLException{
		PreparedStatement stmtUserInfo = conn.prepareStatement(USER_INFO);
		stmtUserInfo.setString(1, "1");

		ResultSet rsUserInfoSet = stmtUserInfo.executeQuery();
		if(rsUserInfoSet.first())
		{
			logger.info(rsUserInfoSet.getString("name"));
		}
	}

}
