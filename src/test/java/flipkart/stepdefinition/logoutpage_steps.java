package flipkart.stepdefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom_classes.Loginpage_locators;
import pom_classes.Logoutpage_loactors;
import pom_classes.Productpage_locators;
import utility_file.Base_class;

public class logoutpage_steps extends Base_class {
    @When("Logout from the application")
    public void logout_from_the_application() {
        driver.findElement(Productpage_locators.flipkartlogo).click();
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Loginpage_locators.logindropbtn));
        moveToElement(driver.findElement(Loginpage_locators.logindropbtn));
        explicitWait().until(ExpectedConditions.elementToBeClickable(Logoutpage_loactors.logoutbtn)).click();

    }
    @Then("Verify that the user is logged out and redirected to the login page")
    public void verify_that_the_user_is_logged_out_and_redirected_to_the_login_page() throws InterruptedException {
        Thread.sleep(5000);
        boolean value = driver.findElement(Loginpage_locators.logindropbtn).getText().contains("Login");
        Assert.assertTrue(value);

    }

}
