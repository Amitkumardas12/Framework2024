package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

    public Homepage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myaccount_btn_locator;
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement register_buttonlink_locator;
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
    WebElement login_buttonlink_locator;

    public void Clickonmyaccountbutton(){
        myaccount_btn_locator.click();
    }
    public void Clickonregisteroptionlink(){
        register_buttonlink_locator.click();
    }
    public void Clickonloginoptionlink(){login_buttonlink_locator.click();}
}
