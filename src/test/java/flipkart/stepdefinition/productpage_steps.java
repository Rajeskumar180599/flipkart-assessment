package flipkart.stepdefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom_classes.Cartpage_locators;
import pom_classes.Checkoutpage_locators;
import pom_classes.Productpage_locators;
import test_data_files.Test_data;
import utility_file.Base_class;

import java.util.Set;

public class productpage_steps extends Base_class {

    @When("Navigate to the homepage")
    public void navigate_to_the_homepage() {
        driver.findElement(Productpage_locators.flipkartlogo).click();
        log("Navigating to the homepage");

    }

    @When("Use the search functionality to find a specific product")
    public void usethesearch_functionality_to_find_a_specific_product() {
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

    @When("Select a product from the search results")
    public void select_a_product_from_the_search_results() {
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Productpage_locators.firstselecprod)).click();
        log("Selecting the product");

    }

    @When("Add the product to the cart")
    public void addtheproduct_to_the_cart() throws InterruptedException {
        Set<String> windows = driver.getWindowHandles();
        for (String url : windows) {
            if (!url.equals(Test_data.currenturl)) {
                driver.switchTo().window(url);
            }
        }
        log("Navigate to the product detail page");
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Productpage_locators.deliverypicodetextbox)).sendKeys(Test_data.pincode);
        driver.findElement(Productpage_locators.checkpincodebtn).click();
        log("Entering the pincode");
        Thread.sleep(3000);
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Productpage_locators.gotocartbtn)).click();
        log("Adding the product in to the cart");
    }

    @When("Navigate to the cart and proceed to checkout")
    public static void navigate_to_the_cart_and_proceed_to_checkout() {
        try {
            driver.findElement(Cartpage_locators.viewcart).click();
            log("Navigating to the cart page");
            Thread.sleep(3000);
            driver.navigate().refresh();
            explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Cartpage_locators.placeorderbtn)).click();
            log("Placing the order");

        } catch (Exception e) {
            System.out.println("Product is now out of stock.");
        }
    }

    @When("Fill in the checkout details")
    public void fill_in_the_checkout_details() {
        log("Navigating to the checkout page");
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Checkoutpage_locators.namefield));
        log("Filling the user address details");
        driver.findElement(Checkoutpage_locators.namefield).sendKeys(Test_data.username);
        driver.findElement(Checkoutpage_locators.phonenumfield).sendKeys(Test_data.mobile_number);
        driver.findElement(Checkoutpage_locators.pincodefield).sendKeys(Test_data.pincode);
        driver.findElement(Checkoutpage_locators.localityfield).sendKeys(Test_data.country);
        driver.findElement(Checkoutpage_locators.addressfield).sendKeys(Test_data.address);
        javascriptscrollintoview(driver.findElement(Checkoutpage_locators.savebtn));
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Checkoutpage_locators.cityfield)).clear();
        driver.findElement(Checkoutpage_locators.cityfield).sendKeys(Test_data.city);
        selectByVisibleText(driver.findElement(Checkoutpage_locators.statedropdown), Test_data.state);
        explicitWait().until(ExpectedConditions.elementToBeClickable(Checkoutpage_locators.homeradiobtn)).click();
        driver.findElement(Checkoutpage_locators.savebtn).click();
        javascriptscrollintoview(driver.findElement(Checkoutpage_locators.emailfield));

        try {
            explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Checkoutpage_locators.emailfield));
            driver.findElement(Checkoutpage_locators.emailfield).sendKeys(Test_data.emailid);
        } catch(Exception e) {
            log("Email id already registered");
        }
        explicitWait().until(ExpectedConditions.elementToBeClickable(driver.findElement(Checkoutpage_locators.continuebtn))).click();
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(Checkoutpage_locators.acceptcontinuebtn)).click();
        log("navigating to the logout section");
    }
}
