package pom_classes;

import org.openqa.selenium.By;

public class Productpage_locators {
    public static By flipkartlogo = By.xpath("//img[@title='Flipkart']");
    public static By searchtextbox = By.xpath("//input[contains(@title,'Search for Products')]");
    public static By searchicon = By.xpath("//button[@type='submit']");
    public static By searchtextverify = By.xpath("(//span[text()='CATEGORIES']/following::div/a[contains(@href,'otracker=categorytree')])[2]");
    public static By firstselecprod = By.xpath("(//div[@class=\"DOjaWF gdgoEp\"]/div[@class=\"cPHDOP col-12-12\"])[1]");
    public static By gotocartbtn = By.xpath("//ul[@class='row']/li/button");

    public static By deliverypicodetextbox = By.xpath("//input[@id=\"pincodeInputId\"]");

    public static By checkpincodebtn = By.xpath("//span[text()='Check']");







}
