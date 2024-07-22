package flipkart.stepdefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom_classes.Productpage_locators;
import test_data_files.Test_data;
import utility_file.Base_class;

import java.time.Duration;

public class homepage_steps extends Base_class {
    @When("Navigate to the homepage")
    public void navigate_to_the_homepage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(Productpage_locators.flipkartlogo).click();
        log("Navigating to the homepage");

    }

    @When("Use the search functionality to find a specific product")
    public void use_the_search_functionality_to_find_a_specific_product() {
        explicitWait().until(ExpectedConditions.visibilityOf(driver.findElement(Productpage_locators.searchtextbox))).click();
        driver.findElement(Productpage_locators.searchtextbox).sendKeys(Test_data.searching_text);
        driver.findElement(Productpage_locators.searchicon).click();
        log("Searching the product");
    }

    @Then("Verify that the search results contain the desired product")
    public void verify_that_the_search_results_contain_the_desired_product() {

        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Productpage_locators.searchtextverify));
        boolean verify = driver.findElement(Productpage_locators.searchtextverify).getText().contains("Laptops");
        Assert.assertTrue(verify);

    }
}
