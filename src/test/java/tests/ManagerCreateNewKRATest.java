package tests;

import org.testng.annotations.Test;


import base.BaseTest;
import factory.DriverFactory;
import pages.LoginPage;
import pages.ManageKRACreateNewKRA;
import utils.ConfigReader;

public class ManagerCreateNewKRATest extends BaseTest {

    @Test
    public void verifyValidLogin() throws InterruptedException {
      
        LoginPage login = new LoginPage(DriverFactory.getDriver());
        login.login(ConfigReader.get("username"), ConfigReader.get("password"));
      
         ManageKRACreateNewKRA ManageKRA = new ManageKRACreateNewKRA(DriverFactory.getDriver());
         ManageKRA.clickManageKRA();
         Thread.sleep(1000);
         ManageKRA.clickCreateNewKRA();
         Thread.sleep(1000);
         ManageKRA.SelectEmployee();
         Thread.sleep(1000);
         ManageKRA.selectEmployeeAngular(4);
         Thread.sleep(1000);
         ManageKRA.KRAName("Prathyusha");
         Thread.sleep(1000);
         ManageKRA.Frequency(4);
         Thread.sleep(1000);
          ManageKRA.DescriptionofKRA("In web automation using Selenium, handling dropdowns depends on how the dropdown is implemented in HTML, not the framework used (Angular, React, etc.). Angular apps can implement dropdowns in two main ways");
         Thread.sleep(1000);
         ManageKRA.setFromDate("09-09-2025");
         Thread.sleep(1000);
         ManageKRA.CreateKRAButton();
         System.out.println("Created Successfully");
         
         /*Not working select KRA dropdown
         ManageKRA.clickCopyKRAfromEmployeetoEmployee();
         Thread.sleep(1000);
         ManageKRA.selectFromEmployeeByIndex(2);
         Thread.sleep(1000);
         ManageKRA.selectMultipleItemsByText("option two");
         Thread.sleep(1000);
         ManageKRA.selectToEmployeeByIndex(1);
         Thread.sleep(1000);
         */
        
         
    }
}
