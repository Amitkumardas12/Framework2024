package testcase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testbase.Baseclass;
import utilities.Dataproviders;
//data is valid--login success--test passed--logout
//data is valid--login failed--test fail
//data is invalid--login failed--test passed
//data is invalid--loging passed-testfailed-logout

public class TC003_LogintestDDT extends Baseclass {

    @Test(dataProvider="Logindata",dataProviderClass = Dataproviders.class)//geting dataprovider from diff class
    public void LogintestDDT(String email,String password, String expresult) {
        logger.info(">>>starting loginDDT testcase");
        try {
            Homepage hp = new Homepage(driver);
            hp.Clickonmyaccountbutton();
            hp.Clickonloginoptionlink();

            Loginpage lp = new Loginpage(driver);
            lp.inputemail(email);
            lp.inputpassword(password);
            lp.Clickloginbutton();

            Myaccountpage map = new Myaccountpage(driver);
            boolean myaccountstatus = map.ismyaccountpageexist();
            if (expresult.equalsIgnoreCase("valid")) {
                if (myaccountstatus == true) {
                    map.Clickonlogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
            if (expresult.equalsIgnoreCase("invalid")) {
                if (myaccountstatus == true) {

                    map.Clickonlogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        }
        catch (Exception e){
            Assert.fail();
        }
    }

}
