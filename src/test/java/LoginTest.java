import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Test with headless Chrome.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.0.0
 */
public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
    PasswordPage passwordPage;
    HomePage homePage;
    Account account = new Account("dasa42435@gmail.com", "1qazXSW2");


    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/ServiceLogin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=AddSession");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void test() {
        loginPage = new LoginPage(driver);
        loginPage.inputLogin(account.getUsername());
        passwordPage = new PasswordPage(driver);
        passwordPage.inputPassword(account.getPassword());
        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getTitle(),"Inbox - " + account.getUsername() + " - Gmail");
    }
}