package flipkart.stepdefinition;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom_classes.Loginpage_locators;
import pom_classes.Menupage_locators;
import utility_file.Base_class;


public class testfile extends Base_class {

//   public  static Login_page loginpage = new Login_page();

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();

        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

//        moveToElement(driver.findElement(Login_page.loginbtn));
//    explicitWait().until(ExpectedConditions.visibilityOf(driver.findElement(Login_page.loginbtn))).click();

//        User Login:
// ○ Navigate to the login page.
//        driver.findElement(Login_page.loginbtn).click();
        explicitWait().until(ExpectedConditions.visibilityOf(driver.findElement(Loginpage_locators.loginbtn))).click();

// ○ Fill in the login form with valid credentials.
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Loginpage_locators.mobnumbertextbox));
        javascriptsendkeys(driver.findElement(Loginpage_locators.mobnumbertextbox) );
        driver.findElement(Loginpage_locators.otpsubmitbtn).click();

// ○ Submit the form.
        Thread.sleep(10000);
        explicitWait().until(ExpectedConditions.visibilityOf(driver.findElement(Loginpage_locators.otpverifybtn))).click();
// ○ Verify that the user is logged in successfully and redirected to the dashboard
        driver.findElement(Menupage_locators.menubar).isDisplayed();


    }
}
