package flipkart.stepdefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom_classes.Loginpage_locators;
import pom_classes.Productpage_locators;
import utility_file.Base_class;
import test_data_files.Test_data;

import java.time.Duration;

public class loginpage_steps extends Base_class {
    @Given("Navigate to the login page")
    public void navigate_to_the_login_page() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(Productpage_locators.flipkartlogo).click();
        explicitWait().until(ExpectedConditions.visibilityOf(driver.findElement(Loginpage_locators.logindropbtn))).click();
        log("Navigating the login page ");

    }

    @When("Fill in the login form with valid credentials")
    public void fill_in_the_login_form_with_valid_credentials() {
        try {
            explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Loginpage_locators.mobnumbertextbox));
            driver.findElement(Loginpage_locators.mobnumbertextbox).sendKeys(Test_data.mobile_number);
            log("Entering the mobile number");
            driver.findElement(Loginpage_locators.otpsubmitbtn).click();
        } catch (Exception e) {
            log("Please check the mobile number");
        }
    }

    @When("Submit the login form")
    public void submit_the_form() throws InterruptedException {
        Thread.sleep(20000);
        log("Manually entering the OTP and navigate the dashboard");
    }

    @Then("Verify that the user is logged in successfully and redirected to the dashboard or homepage")
    public void verify_that_the_user_is_logged_in_successfully_and_redirected_to_the_dashboard_or_homepage() {
        boolean value = driver.findElement(Loginpage_locators.logindropbtn).getText().contains("Login");
        Assert.assertFalse(value);

    }

}
