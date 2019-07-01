import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputField {
    private WebElement inputField;
    private WebDriver driver;

    public InputField(WebDriver driver, By locator){
        this.driver = driver;
        WebElement explicitWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(locator));
        inputField = driver.findElement(locator);
    }

    public void sendKyes(String str){
        inputField.sendKeys(str);
    }

}