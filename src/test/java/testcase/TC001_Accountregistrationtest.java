package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Account_registartion_page;
import pageObjects.Homepage;
import testbase.Baseclass;

import java.time.Duration;

public class TC001_Accountregistrationtest extends Baseclass {
    @Test (groups = {"regression","master"})
    public void Verify_accountregistration(){
        logger.info("Starting TC001_Accountregistrationtest ");
        try {
            Homepage hp = new Homepage(driver);
            logger.info("Click on my account ");
            hp.Clickonmyaccountbutton();
            hp.Clickonregisteroptionlink();

            logger.info("inputting all the detail in registartion page ");
            Account_registartion_page rp = new Account_registartion_page(driver);
            rp.inputfirstname(randomstring());
            rp.inputlastname(randomstring());
            rp.inputemail(randomstring() + "@gmail.com");
            rp.inputnumber(randomphnumber());
            String password = randompassword();
            rp.inputpassword(password);
            rp.inputconfirmpassword(password);
            rp.clickonagree();
            rp.click_on_continue();
            logger.info("validating confirmation message");
            String confirmationmessage = rp.getconfirmation_msg();
            if (confirmationmessage.equals("Your Account Has Been Created!")){
                Assert.assertTrue(true);
            }
            else {
                logger.error("test failed");
                logger.debug("debug logs");
                Assert.assertTrue(false);
            }
        }
        catch (Exception e){

            Assert.fail();
        }
        logger.info("test finished");
    }
}
