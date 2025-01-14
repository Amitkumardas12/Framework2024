package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testbase.Baseclass;

public class TC002_Logintest extends Baseclass {
   @Test(groups = {"sanity","master"})
    public void Verify_login(){
       logger.info(">>> Login testcase is started ");
       try {

       Homepage hp = new Homepage(driver);
       hp.Clickonmyaccountbutton();
       hp.Clickonloginoptionlink();

       Loginpage lp=new Loginpage(driver);
       lp.inputemail(p.getProperty("email"));
       lp.inputpassword(p.getProperty("password"));
       lp.Clickloginbutton();

      Myaccountpage map=new Myaccountpage(driver);
      Thread.sleep(5000);

         boolean myaccoutstatus=map.ismyaccountpageexist();
         Assert.assertTrue(myaccoutstatus);

      } catch (Exception e) {
          Assert.fail();
      }
      logger.info(">>> login test finished");


   }
}
