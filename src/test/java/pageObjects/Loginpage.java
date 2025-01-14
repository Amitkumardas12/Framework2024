package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage {
    public Loginpage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement E_Mail_btn_locator;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password_locator;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement Loginbtn_locator;

    public void inputemail(String username){
        E_Mail_btn_locator.sendKeys(username);
    }
    public void inputpassword(String password){
        password_locator.sendKeys(password);
    }
    public void Clickloginbutton(){
        Loginbtn_locator.click();
    }
}
