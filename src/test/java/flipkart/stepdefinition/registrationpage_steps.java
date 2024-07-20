package flipkart.stepdefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test_datas.Test_data;
import utility_file.Base_class;
import pom_classes.Loginpage_locators;

public class registrationpage_steps extends Base_class {
    @Given("user Navigate to the registration page")
    public void user_navigate_to_the_registration_page() {
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Loginpage_locators.loginbtn));
        moveToElement(driver.findElement(Loginpage_locators.loginbtn));
        driver.findElement(Loginpage_locators.popupsignupbtn).click();
        log("Navigating the registration page");

    }
    @When("Fill in the registration form with valid details")
    public void fill_in_the_registration_form_with_valid_details() throws InterruptedException {
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Loginpage_locators.mobnumbertextbox));
        driver.findElement(Loginpage_locators.mobnumbertextbox).sendKeys(Test_data.mobile_number);
        log("Mobile number entered");
        driver.findElement(Loginpage_locators.continuebtn).click();

        Thread.sleep(20000);
        log("Manually entering the OTP");
    }
    @When("Submit the registration form")
    public void submit_the_form() {
        explicitWait().until(ExpectedConditions.elementToBeClickable(Loginpage_locators.signupbtn)).click();
        log("Navigate to the dashboard page");
    }
    @Then("Verify that the user is registered successfully and redirected to the dashboard or homepage")
    public void verify_that_the_user_is_registered_successfully_and_redirected_to_the_dashboard_or_homepage() {
        boolean value = driver.findElement(Loginpage_locators.loginbtn).isDisplayed();
        Assert.assertFalse(value);
    }

}
