package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import factory.DriverFactory;
import pages.*;
import utils.ConfigReader;

public class ManagerDashboardTest extends BaseTest {

    @Test
    public void verifyValidLogin() throws InterruptedException {
      
        LoginPage login = new LoginPage(DriverFactory.getDriver());
        login.login(ConfigReader.get("username"), ConfigReader.get("password"));
        MangerDashborad dashboard = new MangerDashborad(DriverFactory.getDriver());
       // dashboard.TotalKRAS();
        dashboard.InProgress();
        Thread.sleep(1000);
        dashboard.PendingAcceptance();
        Thread.sleep(1000);
        dashboard.Completed();
        Thread.sleep(1000);
        dashboard.ObjectionRaised();
        Thread.sleep(1000);
        dashboard.Misseddeadlines();
        Thread.sleep(1000);
        
        // Step 2: Total KRS Count
        
        ManagerDashboardTotalKRSCount TotalKRASCount = new  ManagerDashboardTotalKRSCount(DriverFactory.getDriver());
        int totalKRAS = TotalKRASCount.getTotalKRAS();
        int sumOfCategories = TotalKRASCount.getInProgress()
                                + TotalKRASCount.getPendingAcceptance()
                                + TotalKRASCount.getCompleted()
                                + TotalKRASCount.getObjectionRaised();
                             // + TotalKRASCount.getMissedDeadlines();   
 
        System.out.println("Total KRAS: " + totalKRAS);
        System.out.println("Sum of Categories: " + sumOfCategories);
 
        Assert.assertEquals(sumOfCategories, totalKRAS, "Sum of all categories should match Total KRAS");
    
        
        // Step 3: PendingAcceptance actions
        ManagerDashboardPendingAcceptance pendingAcceptance = new ManagerDashboardPendingAcceptance(DriverFactory.getDriver());
        pendingAcceptance.navigateToTab("Pending Acceptance");
        Thread.sleep(1000);
        pendingAcceptance.ViewDetails();
        Thread.sleep(1000);
        pendingAcceptance.Closebutton();
        Thread.sleep(1000);
    
     // Step 4: TotalKRAS actions
        ManagerDashboardTotalKRAS Dashboard = new ManagerDashboardTotalKRAS(DriverFactory.getDriver());
        Dashboard.openTotalKRAS();
        Thread.sleep(1000);
        Dashboard.Lists();
        Thread.sleep(1000);
        Dashboard.openFirstKRAItem();
        Thread.sleep(1000);
        Dashboard.ALLKRAS();
        Thread.sleep(1000);
    
    
    
    }
    
}
