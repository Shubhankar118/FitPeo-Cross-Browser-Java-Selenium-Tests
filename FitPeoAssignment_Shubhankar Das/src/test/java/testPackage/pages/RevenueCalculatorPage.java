package testPackage.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import testPackage.utils.LocatorReader;
public class RevenueCalculatorPage {
    private WebDriver driver;
    private LocatorReader locatorReader;

    public RevenueCalculatorPage(WebDriver driver) {
        this.driver = driver;
        this.locatorReader = new LocatorReader("src/test/java/testPackage/locaters/locators.xml");

    }

    public void scrollToSlider() {

        String sliderXpath = locatorReader.getLocator("slider", "xpath");
        WebElement slider = driver.findElement(By.xpath(sliderXpath));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }
    public void adjustSlider() {


        String sliderXpath = locatorReader.getLocator("slider", "xpath");
        WebElement slider = driver.findElement(By.xpath(sliderXpath));

        int sliderWidth = slider.getSize().getWidth();

        int offset = (820 * sliderWidth) / 2000;

        // To drag the slider
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(offset, 0).release().perform();


    }

    public void updateTextField(int value) {
        String textFieldXpath = locatorReader.getLocator("text_field", "xpath");
        WebElement text_field = driver.findElement(By.xpath(textFieldXpath));
        text_field.click();
        text_field.sendKeys(Keys.CONTROL + "a"); // it Selects all text
        text_field.sendKeys(Keys.DELETE); // it Clears the field
        text_field.sendKeys(String.valueOf(value));

    }

    public void selectCPTCheckboxes() {
        driver.findElement(By.xpath(locatorReader.getLocator("cptCheckbox99091", "xpath"))).click();
        driver.findElement(By.xpath(locatorReader.getLocator("cptCheckbox99453", "xpath"))).click();
        driver.findElement(By.xpath(locatorReader.getLocator("cptCheckbox99454", "xpath"))).click();
        driver.findElement(By.xpath(locatorReader.getLocator("cptCheckbox99474", "xpath"))).click();
    }

    public String getTotalReimbursement() {
        String reimbursementHeaderXpath = locatorReader.getLocator("total_reimbursement", "xpath");
        return driver.findElement(By.xpath(reimbursementHeaderXpath)).getText();
    }
}
