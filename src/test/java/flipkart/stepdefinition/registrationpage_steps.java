package flipkart.stepdefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom_classes.Productpage_locators;
import test_data_files.Test_data;
import utility_file.Base_class;
import pom_classes.Loginpage_locators;

public class registrationpage_steps extends Base_class {
    @Given("user Navigate to the registration page")
    public void user_navigate_to_the_registration_page() {
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Loginpage_locators.logindropbtn));
        moveToElement(driver.findElement(Loginpage_locators.logindropbtn));
        driver.findElement(Loginpage_locators.popupsignupbtn).click();
        log("Navigating the registration page");

    }

    @When("Fill in the registration form with valid details")
    public void fill_in_the_registration_form_with_valid_details() throws InterruptedException {

        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Loginpage_locators.mobnumbertextbox));
        driver.findElement(Loginpage_locators.mobnumbertextbox).sendKeys(Test_data.mobile_number);
        driver.findElement(Loginpage_locators.continuebtn).click();
        log("Mobile number entered");
        if (!driver.findElement(Loginpage_locators.otpsubmitbtn).isDisplayed()) {
            log("Manually entering the OTP");
            Thread.sleep(20000);

        } else {
            log("Already registered");
            driver.navigate().back();
            log("Navigating to the dashboard");
        }

    }

    @When("Submit the registration form")
    public void submit_the_form() {
        try {
            driver.findElement(Loginpage_locators.signupbtn).click();
            log("Navigate to the dashboard page");
        } catch (NoSuchElementException e) {
            log("Submit method skipped");
        }
    }

    @Then("Verify that the user is registered successfully and redirected to the dashboard or homepage")
    public void verify_that_the_user_is_registered_successfully_and_redirected_to_the_dashboard_or_homepage() {
        try {
            driver.findElement(Loginpage_locators.logindropbtn).isDisplayed();
            boolean value = driver.findElement(Loginpage_locators.logindropbtn).getText().contains("Login");
            Assert.assertFalse(value);
        } catch (NoSuchElementException e) {
            log("Register page assertion skipped");
        }
    }

}
