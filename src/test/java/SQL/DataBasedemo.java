package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DataBasedemo {
	
	String dbUrl="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	
	@Test
	public void datebasedemo() throws SQLException {
		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		System.out.println("Connection is created ");
		System.out.println(connection);
		
		Statement sta = connection.createStatement();
		
		ResultSet resultset = sta.executeQuery("select emp_number, emp_firstname, emp_lastname, job_title\n" + 
				"from hs_hr_employees e right join ohrm_job_title t\n" + 
				"on e.job_title_code=t.id");
		
		resultset.next();
		String columndata = resultset.getString("emp_firstname");
		System.out.println(columndata);
		
		//resultset.next();
		columndata = resultset.getString("emp_lastname");
		System.out.println(columndata);
		
		System.out.println("================================================================================");
		while(resultset.next()) {
			columndata = resultset.getString("emp_firstname");
			System.out.println(columndata);
			
		}
		
		
		
		
		
		
		
		
	}
	

}
