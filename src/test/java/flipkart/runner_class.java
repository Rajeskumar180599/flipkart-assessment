package flipkart;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import utility_file.Base_class;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\flipkart\\feature_files\\product_purchase.feature",glue = "flipkart\\stepdefinition",dryRun = false,plugin = {"pretty", "html:target\\cucumber-reports\\cucumber.html","json:target\\cucumber-reports\\cucumber.json","junit:target\\cucumber-reports\\cucumber.xml"})
public class runner_class extends Base_class {
    @BeforeClass
    public static void start(){
        driver=new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
    }

    @AfterClass
    public static void end(){
        driver.quit();
    }

}
