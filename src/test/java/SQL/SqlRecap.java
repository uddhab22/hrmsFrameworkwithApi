package SQL;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.hmrs.utils.SqlConstants;


public class SqlRecap {
	@Test
	public void recap() throws SQLException {
		Connection c = DriverManager.getConnection(SqlConstants.dbUrl, SqlConstants.dbUsername, SqlConstants.dbPassword);
		
		DatabaseMetaData metadata = c.getMetaData();
		String databasemetaData = metadata.getDatabaseProductName();
		System.out.println("Product name is "+databasemetaData);
		System.out.println();
		
		Statement s = c.createStatement();
		ResultSet rset =s.executeQuery("select * from ohrm_skill");
		ResultSetMetaData rsetMeta = rset.getMetaData();
		
		int column = rsetMeta.getColumnCount();
		System.out.println("Total number of column in this table is "+column);
		System.out.println();
		
		for(int i =1; i<=column; i++) {
			String colName = rsetMeta.getColumnName(i);
			System.out.println("Column name ="+colName);	
		}
		
		System.out.println();
		String name,id;
		
		
		while(rset.next()) {
			id = rset.getObject("id").toString();
			name = rset.getObject("name").toString();
			
			System.out.println(id+" = "+name);
		}
		rset.close();
		s.close();
		c.close();
	}

}
