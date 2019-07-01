import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button {
    private WebElement btn;
    private WebDriver driver;

    public Button(WebDriver driver, By locator){
        this.driver = driver;
        WebElement explicitWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(locator));
        btn = driver.findElement(locator);
    }

    public void click(){
//        WebElement explicitWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(btn));
        btn.click();
    }

}
