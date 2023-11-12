import org.junit.Assert;
import org.junit.Test;
import pageObject.PaymentPage;
import pageObject.TopUpOnlinePage;

public class MtsTest extends BaseTest {

    private String phoneNumber = "297777777";
    private String sum = "100.00";
    private String email = "testmail.9191@mail.ru";
    TopUpOnlinePage topUpOnline = new TopUpOnlinePage(driver);
    PaymentPage paymentPage = new PaymentPage(driver);

    @Test
    public void phoneNumberTest() {
        topUpOnline.clickResumeButton(phoneNumber, sum, email);
        Assert.assertEquals("Оплата: Услуги связи Номер:375" + phoneNumber, paymentPage.checkPhoneNumber());
    }

    @Test
    public void moneyButtonTest() {
        topUpOnline.clickResumeButton(phoneNumber, sum, email);
        Assert.assertEquals("Оплатить " + sum + " BYN", paymentPage.checkMoneyButton());
    }

    @Test
    public void moneyHeaderTest() {
        topUpOnline.clickResumeButton(phoneNumber, sum, email);
        Assert.assertEquals(sum + " BYN", paymentPage.checkMoneyHeader());
    }
}
