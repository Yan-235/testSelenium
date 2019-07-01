import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private By usernameLocator = By.xpath("//input[@type = 'email']");
    private By nextButtonLocator = By.xpath("//div[@id=\"identifierNext\"]//span[@class=\"RveJvd snByac\"]");
    private Button nextButton;
    private InputField usernameField;
    private final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        nextButton = new Button(driver, nextButtonLocator);
        usernameField = new InputField(driver, usernameLocator);
    }

    private void typeUsername(String username) {
//        driver.findElement(usernameLocator).sendKeys(username);
        usernameField.sendKyes(username);

    }

    private void submitLogin() {
        nextButton.click();
//        driver.findElement(nextButtonLocator).click();
    }

    public void inputLogin(String username){
        typeUsername(username);
        submitLogin();
    }
}