package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopUpOnlinePage {
    WebDriver driver;
    private By agreeCookieButton = By.xpath("//*[@id='cookie-agree']");
    private By inputPhoneString = By.id("connection-phone");
    private By inputSumString = By.id("connection-sum");
    private By inputEmailString = By.id("connection-email");
    private By resumeButton = By.xpath("//*[@id='pay-connection']/button");

    public TopUpOnlinePage(WebDriver driver) {
        this.driver = driver;
    }

    private void inputPhone(String phoneNumber) {
        driver.findElement(inputPhoneString).sendKeys(phoneNumber);
    }

    private void inputSum(String sum) {
        driver.findElement(inputSumString).sendKeys(sum);
    }

    private void inputEmail(String email) {
        driver.findElement(inputEmailString).sendKeys(email);
    }

    public void clickResumeButton(String phoneNumber, String sum, String email) {
        driver.findElement(agreeCookieButton).click();
        inputPhone(phoneNumber);
        inputSum(String.valueOf(sum));
        inputEmail(email);
        driver.findElement(resumeButton).click();
    }
}
