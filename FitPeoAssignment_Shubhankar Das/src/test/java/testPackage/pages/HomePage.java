package testPackage.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testPackage.utils.LocatorReader;

public class HomePage {
    private WebDriver driver;
    private LocatorReader locatorReader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.locatorReader = new LocatorReader("src/test/java/testPackage/locaters/locators.xml");

    }

    public void navigateToRevenueCalculator() {
        String revenueCalculatorXpath = locatorReader.getLocator("homepage_revenueCalculator", "xpath");
        WebElement revenueCalculatorLink = driver.findElement(By.xpath(revenueCalculatorXpath));
        revenueCalculatorLink.click();
    }





}
