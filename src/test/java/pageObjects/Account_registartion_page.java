package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_registartion_page extends Basepage{

    public Account_registartion_page(WebDriver driver) {
        super(driver);
    }


    @FindBy (xpath = "//input[@id='input-firstname']")
    WebElement fisrtname_input_loc;
    @FindBy (xpath = "//input[@id='input-lastname']")
    WebElement lastname_input_loc;
    @FindBy (xpath = "//input[@id='input-email']")
    WebElement email_input_loc;
    @FindBy (xpath = "//input[@id='input-telephone']")
    WebElement telepnone_input_loc;
    @FindBy (xpath = "//input[@id='input-password']")
    WebElement password_input_loc;
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement confirmpwd_input_loc;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement agreecheckbox_loc;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continuebnt_loc;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement confirmation_msg;

    public void inputfirstname(String firstname){
        fisrtname_input_loc.sendKeys(firstname);
    }
    public void inputlastname(String lastname){
        lastname_input_loc.sendKeys(lastname);
    }
    public void inputemail(String email){
        email_input_loc.sendKeys(email);
    }
    public void inputnumber(String number){
        telepnone_input_loc.sendKeys(number);
    }
    public void inputpassword(String password){
        password_input_loc.sendKeys(password);
    }
    public void inputconfirmpassword(String password){
        confirmpwd_input_loc.sendKeys(password);
    }
    public void clickonagree(){
        agreecheckbox_loc.click();
    }
    public void click_on_continue(){
        continuebnt_loc.click();
    }

    public String getconfirmation_msg(){
        try {
            return (confirmation_msg.getText());
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
