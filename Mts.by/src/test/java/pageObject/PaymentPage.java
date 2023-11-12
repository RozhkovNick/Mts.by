package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentPage {
    private WebDriverWait wait;
    WebDriver driver;
    private By frameWindow = By.xpath("//div/iframe");
    private By phoneNumber = By.xpath("//app-header/header/div/div/p[2]");
    private By moneyOfHeader = By.xpath("//app-header/header/div/div/p[1]");
    private By moneyOnButton = By.xpath("//app-card-page/div/div[1]/button");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void switchFrame() {
        WebElement frame = driver.findElement(frameWindow);
        driver.switchTo().frame(frame);
    }

    public String checkPhoneNumber() {
        switchFrame();
        WebElement elementNumber = driver.findElement(phoneNumber);
        wait.until(ExpectedConditions.visibilityOf(elementNumber));
        String number = driver.findElement(phoneNumber).getText();
        return number;
    }

    public String checkMoneyHeader() {
        switchFrame();
        WebElement header = driver.findElement(moneyOfHeader);
        wait.until(ExpectedConditions.visibilityOf(header));
        String money = driver.findElement(moneyOfHeader).getText();
        return money;
    }

    public String checkMoneyButton() {
        switchFrame();
        WebElement button = driver.findElement(moneyOnButton);
        wait.until(ExpectedConditions.visibilityOf(button));
        String money = driver.findElement(moneyOnButton).getText();
        return money;
    }
}
