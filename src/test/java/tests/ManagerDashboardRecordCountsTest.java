package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import factory.DriverFactory;
import pages.*;
import utils.ConfigReader;

public class ManagerDashboardRecordCountsTest extends BaseTest {

    @Test
    public void verifyValidLogin() throws InterruptedException {
      
        
         LoginPage login = new LoginPage(DriverFactory.getDriver());
        login.login(ConfigReader.get("username"), ConfigReader.get("password"));
        
        MangerDashborad dashboard = new MangerDashborad(DriverFactory.getDriver());
        dashboard.TotalKRAS();
        dashboard.InProgress();
        Thread.sleep(1000);
        dashboard.PendingAcknowleged();
        Thread.sleep(1000);
        dashboard.Completed();
        Thread.sleep(1000);
        dashboard.ObjectionRaised();
        Thread.sleep(1000);
        dashboard.Misseddeadlines();
        Thread.sleep(1000);
        
        // Step 2: Total KRAS Count
        
        ManagerDashboardTotalKRASCount TotalKRASCount = new  ManagerDashboardTotalKRASCount(DriverFactory.getDriver());
        int totalKRAS = TotalKRASCount.getTotalKRAS();
        int TotalsumofallcategoryKRAsindashboard = TotalKRASCount.getInProgress()
                                + TotalKRASCount.getPendingAcknowleged()
                                + TotalKRASCount.getCompleted()
                                + TotalKRASCount.getObjectionRaised();
                             // + TotalKRASCount.getMissedDeadlines();   
 
        System.out.println("Total KRAS: " + totalKRAS);
        System.out.println("TotalsumofallcategoryKRAsindashboard: " + TotalsumofallcategoryKRAsindashboard);
 
        Assert.assertEquals(TotalsumofallcategoryKRAsindashboard, totalKRAS, "Sum of all categories should match Total KRAS");
         
        
        
        // Step 3: In Progress actions
        ManagerDashboardInprogressCountandViewDetails Inprogress = new ManagerDashboardInprogressCountandViewDetails(DriverFactory.getDriver());
        Inprogress.navigateToTab("In Progress");
        Thread.sleep(1000);
        Inprogress.Lists();
        Thread.sleep(1000);
        Inprogress.firstKRAPendingReview();
        Thread.sleep(1000);
        Inprogress.PendingReviews();
        Thread.sleep(1000);
        Inprogress.ReviewedKRAS();
        Thread.sleep(1000);
        Inprogress.reviewedKRAsViewDetails();
        Thread.sleep(1000);
        Inprogress.Closebutton();
        Thread.sleep(1000);
        Inprogress.RejectedKRAS();
        Thread.sleep(1000);
        Inprogress.rejectedKRAsViewDetails();
        Thread.sleep(1000);
        Inprogress.YetToStart();
        Thread.sleep(1000);
        
    // Inprogress combining all count with represtive of Total KRAS
        /*
         int PendingReviews = Inprogress.getpendingReview();
        int SumOfCategories1Inprogress = Inprogress.getReviewedKRAS()
                                + Inprogress.getRejectedKRAS()
                                + Inprogress.getYetToStart();
                                   
 
        System.out.println("PendingReviews: " + PendingReviews);
        System.out.println("SumOfCategories1Inprogress: " + SumOfCategories1Inprogress);
 
        Assert.assertEquals(SumOfCategories1Inprogress, PendingReviews, "Sum of all categories should match pendingReviews");
        
        */
        
        
        // Step 4: PendingAcknowleged actions
        ManagerDashboardPendingAcknowleged pendingAcknowleged = new ManagerDashboardPendingAcknowleged(DriverFactory.getDriver());
        pendingAcknowleged.navigateToTab("Pending Acknowleged");
        Thread.sleep(1000);
        pendingAcknowleged.ViewDetails();
        Thread.sleep(1000);
        pendingAcknowleged.Closebutton();
        Thread.sleep(1000);
    
     // Step 5: TotalKRAS actions
        ManagerDashboardTotalKRASAllKRAS Dashboard = new ManagerDashboardTotalKRASAllKRAS(DriverFactory.getDriver());
        Dashboard.openTotalKRAS();
        Thread.sleep(1000);
        Dashboard.Lists();
        Thread.sleep(1000);
        Dashboard.openFirstKRAItem();
        Thread.sleep(1000);
        Dashboard.ALLKRAS();
        Thread.sleep(1000);
        Dashboard.InProgress();
        Thread.sleep(1000);
        Dashboard.Completed();
        Thread.sleep(1000);
        Dashboard.Overdue();
        Thread.sleep(1000);
        Dashboard.Assigned();
        Thread.sleep(1000);
        Dashboard.ObjectionRasied();
        Thread.sleep(1000);
        

        // Step 6: Total KRS Count
        
        ManagerDashboardTotalKRASAllKRAS AllKRASCount= new  ManagerDashboardTotalKRASAllKRAS(DriverFactory.getDriver());
        int TotalALLKRAS = AllKRASCount.getAllKRAS();
        int SumOfCategoriesinTotalALLKRAS = AllKRASCount.getInProgress()
                                + AllKRASCount.getCompleted()
                                + AllKRASCount.getAssignedCount() 
                                + AllKRASCount.getObjectionRaised();
                             // + AllKRASCount.Overdue();   
 
        System.out.println("Total KRAS: " + TotalALLKRAS);
        System.out.println("SumOfCategoriesinTotalALLKRAS: " + SumOfCategoriesinTotalALLKRAS);
 
        Assert.assertEquals(SumOfCategoriesinTotalALLKRAS, TotalALLKRAS, "Sum of all categories should match Total KRAS");
    
        
        Dashboard.Closebutton();
        Thread.sleep(1000);
    
    
    }
    
}
