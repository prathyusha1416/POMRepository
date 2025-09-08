package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import factory.DriverFactory;
import pages.*;
import utils.ConfigReader;

public class ManagerLoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {
      
        loginpage login = new loginpage(DriverFactory.getDriver());
        login.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Dashboardpage dashboard = new Dashboardpage(DriverFactory.getDriver());
        dashboard.clickDashboard();
        dashboard.openLeavesSection();
        dashboard.openEmpLeaveRequest();
        LeaveApprovalPage leavePage = new LeaveApprovalPage(DriverFactory.getDriver());
        leavePage.selectYear(2);
        leavePage.clickSubmit();
        leavePage.clickFirstView();
        leavePage.selectApprovalStatus(1);
        leavePage.enterManagerComment("Test");
        leavePage.submitApproval();
        String alertText = leavePage.handleAlert();
        System.out.println("Alert: " + alertText);
        Logoutpage logout = new Logoutpage(DriverFactory.getDriver());
        logout.logout();
    }
}
