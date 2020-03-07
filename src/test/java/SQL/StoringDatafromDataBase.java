package SQL;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.junit.Test;

import com.hmrs.utils.SqlConstants;

public class StoringDatafromDataBase {
	
	@Test
	public void storeData() throws SQLException {
	Connection c = DriverManager.getConnection(SqlConstants.dbUrl, SqlConstants.dbUsername, SqlConstants.dbPassword);	
	Statement s = c.createStatement();
	
	ResultSet rset =s.executeQuery("select * from ohrm_location;");
	
	List<Map<String,String>> listData = new ArrayList<>();
	
	while(rset.next()) {
		Map<String, String> map=new LinkedHashMap<>();
		map.put("id", rset.getObject("id").toString());
		map.put("name", rset.getObject("name").toString());
		map.put("country_code", rset.getObject("country_code").toString());
	
		listData.add(map);
		
	}
	System.out.println(listData);
	
	}
	
	@Test
	public void getandstoredataEnchased() throws SQLException {
		Connection c = DriverManager.getConnection(SqlConstants.dbUrl, SqlConstants.dbUsername, SqlConstants.dbPassword);	
		Statement s = c.createStatement();
		
		ResultSet rset =s.executeQuery("select * from ohrm_skill;");
		ResultSetMetaData rsetMeta = rset.getMetaData();
		
		int numCol = rsetMeta.getColumnCount();
		System.out.println();
		
		List<Map<String,String>> listData = new ArrayList<>();
		Map<String, String> map;
		
		while(rset.next()) {
			 map=new LinkedHashMap<>();
			 for(int i =1; i<=numCol; i++) {
					
				 map.put(rsetMeta.getColumnName(i), rset.getObject(i).toString());
				 
				 listData.add(map);
				}
	}
		System.out.println("Printing List Data with Enhansed method:");
		System.out.println(listData);
		System.out.println();
	
		
		
	}	
}
