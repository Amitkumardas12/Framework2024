package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends Basepage{

    public Myaccountpage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myaccountheading_locator;
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement logoutbtn_locator;

    public boolean ismyaccountpageexist(){
        try {
            return myaccountheading_locator.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public void Clickonlogout(){
        logoutbtn_locator.click();
    }
}
