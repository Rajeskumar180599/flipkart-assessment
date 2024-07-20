package pom_classes;

import org.openqa.selenium.By;

public class Checkoutpage_locators {
    public static By namefield = By.xpath("//input[@name='name']");
    public static By phonenumfield = By.xpath("//input[@name=\"phone\"]");
    public static By pincodefield = By.xpath("//input[@name=\"pincode\"]");
    public static By localityfield = By.xpath("//input[@name=\"addressLine2\"]");
    public static By addressfield = By.xpath("//textarea[@name=\"addressLine1\"]");
    public static By cityfield = By.xpath("//input[@name=\"city\"]");

    public static By statedropdown = By.xpath("//select[@name=\"state\"]");
    public static By homeradiobtn = By.xpath("//input[@id=\"HOME\"]");
    public static By savebtn = By.xpath("//button[text()='Save and Deliver Here']");

}
