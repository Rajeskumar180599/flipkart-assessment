package pom_classes;

import org.openqa.selenium.By;

public class Cartpage_locators {
    public static By viewcart = By.xpath("//a[contains(@href,'/viewcart?')]");
    public static By placeorderbtn = By.xpath("//span[text()='Place Order']/parent::button");


}
