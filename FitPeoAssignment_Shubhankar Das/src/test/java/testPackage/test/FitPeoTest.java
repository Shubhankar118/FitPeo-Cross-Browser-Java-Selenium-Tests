package testPackage.test;



import org.testng.Assert;
import org.testng.annotations.Test;
import testPackage.baseClass.BasePage;
import testPackage.pages.HomePage;
import testPackage.pages.RevenueCalculatorPage;


public class FitPeoTest extends BasePage{

    @Test
    public void testRevenueCalculator() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        RevenueCalculatorPage calculatorPage = new RevenueCalculatorPage(driver);

        // 1: Navigate to Revenue Calculator Page
        homePage.navigateToRevenueCalculator();
        Thread.sleep(3000);



        // 2: Scroll down function
        calculatorPage.scrollToSlider();

        // 3: Adjust Slider
        calculatorPage.adjustSlider();


        // 4: Updates Text Field
        calculatorPage.updateTextField(560);


        calculatorPage.updateTextField(820);

        // 5: Select CPT Codes
        calculatorPage.selectCPTCheckboxes();

        // 6: Validating the total Reimbursement amount
        String totalReimbursement = calculatorPage.getTotalReimbursement();
        Assert.assertEquals("Total Recurring Reimbursement for all Patients Per Month\n" +
                "$110700",totalReimbursement);
    }
}
