import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage {
    private By passwordLocator = By.xpath("//input[@type=\"password\"]");
    private By nextButtonLocator = By.xpath("//div[@id=\"passwordNext\"]//span[@class=\"RveJvd snByac\"]");
    Button nextButton;
    InputField passwordField;

    private final WebDriver driver;

    public PasswordPage(WebDriver driver){
        this.driver = driver;
        nextButton = new Button(driver, nextButtonLocator);
        passwordField = new InputField(driver, passwordLocator);
    }

    private void typePassword(String password) {

        passwordField.sendKyes(password);
        //        driver.findElement(passwordLocator).sendKeys(password);
    }

    private void submitPassword() {
        nextButton.click();
//        driver.findElement(nextButtonLocator).click();
    }

    public void inputPassword(String password){
        typePassword(password);
        submitPassword();
    }

}
