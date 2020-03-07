package com.hmrs.testbase;

import com.hmrs.pages.AddEmployee;
import com.hmrs.pages.DashboardPageElements;
import com.hmrs.pages.loginPagesElements;

public class PageInitiliazer extends BaseClass{
	
	protected static loginPagesElements login;
	protected static DashboardPageElements dashboard;
	protected static AddEmployee addEmp;
	
	public static void initializeAllPage() {

		login = new loginPagesElements();
		dashboard = new DashboardPageElements();
		addEmp = new AddEmployee();
		
	}
	 
	
	
	
	
	

}
