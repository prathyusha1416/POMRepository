package tests;

import org.testng.annotations.Test;


import base.BaseTest;
import factory.DriverFactory;
import pages.LoginPage;
import pages.MangerDashboardInprogressViewDetailsChangeStatus;
import utils.ConfigReader;

public class ManagerInprogressViewDetailsStatusTest extends BaseTest {

    @Test
    public void verifyValidLogin() throws InterruptedException {
      
        LoginPage login = new LoginPage(DriverFactory.getDriver());
        login.login(ConfigReader.get("username"), ConfigReader.get("password"));
      
    
	  MangerDashboardInprogressViewDetailsChangeStatus ViewDetails = new MangerDashboardInprogressViewDetailsChangeStatus(DriverFactory.getDriver());
	  ViewDetails.clickManageKRA();
	  Thread.sleep(1000);
	  ViewDetails.Inprogress();
	  Thread.sleep(1000);
	  ViewDetails.Lists();
	  Thread.sleep(1000);
	  ViewDetails.firstKRAPendingReview();
	  Thread.sleep(1000);
	  ViewDetails.ViewDetails();
	  Thread.sleep(1000);
	  //ViewDetails.SelectStatus(1);
	  ViewDetails.SelectStatus(2);
	  Thread.sleep(1000);
	  //ViewDetails.RejectedComments("Not yet designed as per SDD");
	  Thread.sleep(1000);
	  ViewDetails.UpdateKraStatus();
	  Thread.sleep(1000);
}
}