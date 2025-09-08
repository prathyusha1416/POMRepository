package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import factory.DriverFactory;
import pages.Dashboardpage;

public class dashboardtest extends BaseTest {
	
	 @Test
	public void dashboardtesting() {
		
		Dashboardpage page = new Dashboardpage(DriverFactory.getDriver());
		page.clickOnDashboard();
		page.clickOnDashboard();
		
	}
	
}
