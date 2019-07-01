import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
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
public class LogoutTest {

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
        driver.get("https://mail.google.com/mail/#inbox");
        if (driver.getTitle().equals("Gmail")) {
            loginPage = new LoginPage(driver);
            loginPage.inputLogin(account.getUsername());
            passwordPage = new PasswordPage(driver);
            passwordPage.inputPassword(account.getPassword());
        }
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
        homePage = new HomePage(driver);
        homePage.logout();
        Assert.assertTrue(driver.findElements( By.id("profileIdentifier") ).size() != 0);
    }

}