package testbase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class Baseclass {
    public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String os,String br) throws IOException {

        FileReader file=new FileReader("src/main/config.properties");
        p=new Properties();
        p.load(file);
        logger=LogManager.getLogger(this.getClass());

        if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities cap = new DesiredCapabilities();
            if (os.equalsIgnoreCase("windows")) {
                cap.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("mac")) {
                cap.setPlatform(Platform.MAC);
            } else {
                System.out.println("No matching OS");
                return;
            }
            switch (br.toLowerCase()) {
                case "chrome":
                    cap.setBrowserName("chrome");
                    break;
                case "edge":
                    cap.setBrowserName("edge");
                    break;
                case "firefox":
                    cap.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("no matching browser");
                    return;

            }
            driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
        }

        if (p.getProperty("execution_env").equalsIgnoreCase("local")){

            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("invalid browser");
                    return;
            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();

    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }

    public String randomstring()
    {
        String randomalphabatic= RandomStringUtils.randomAlphabetic(9);
        return randomalphabatic;
    }
    public String randomphnumber(){
        String randomnbr=RandomStringUtils.randomNumeric(6);
        return randomnbr;
    }
    public String randompassword()
    {
        String randomalphabatic=RandomStringUtils.randomAlphabetic(3);
        String randomnumber=RandomStringUtils.randomNumeric(4);
        return (randomalphabatic+"@"+randomnumber);
    }
    public String captureScreen(String tname) throws IOException{
        String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takescreenshot=(TakesScreenshot) driver;
        File sourceFile=takescreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+ "_"+timestamp;
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }

}
