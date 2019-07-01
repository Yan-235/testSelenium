import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private By starredButtonLocator = By.xpath("//span/a[@href = \"https://mail.google.com/mail/#starred\"]");
    private By composeButtonLocator = By.xpath("//div[@gh='cm']");
    private Button dropdownMenuButton;
    private Button logoutButton;
    private Button composeButton;
//    private Button sendButton;
//    private By sendButtonLocator = By.xpath("//div[@class='dC']/div[@role='button']");
    private InputField toField;
    private By toLocator = By.xpath("//div[@class=\"wO nr l1\"]//textarea[@name='to']");
    private InputField subjectField;
    private By subjectLocator = By.xpath("//input[@name='subjectbox']");
    private InputField messageField;
    private By messageLocator = By.xpath("//div[@role='textbox']");
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendMail(String to, String subject, String message) {
        composeButton = new Button(driver, composeButtonLocator);
        composeButton.click();
        toField = new InputField(driver, toLocator);
        toField.sendKyes(to);
        subjectField = new InputField(driver, subjectLocator);
        subjectField.sendKyes(subject);
        messageField = new InputField(driver, messageLocator);
        messageField.sendKyes(message);
//        sendButton = new Button(driver, sendButtonLocator);
//        sendButton.click();
        String selectAll = Keys.chord(Keys.LEFT_CONTROL, Keys.ENTER);
        driver.findElement(By.tagName("html")).sendKeys(selectAll);
    }


    public void logout() {
        dropdownMenuButton = new Button(driver, By.cssSelector("a[aria-label*='Google Account:']"));
        dropdownMenuButton.click();
        logoutButton = new Button(driver, By.cssSelector("a[href*='Logout']"));
        logoutButton.click();
    }

    public String getTitle() {
        WebElement explicitWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(starredButtonLocator));
        return driver.getTitle();
    }

}
