package pom_classes;

import org.openqa.selenium.By;

public class Loginpage_locators {
    public static By loginbtn = By.xpath("//span[text()='Login']");
    public static By popupsignupbtn = By.xpath("//span[text()='Sign Up']");
    public static By mobnumbertextbox = By.xpath("(//input[@type='text'])[2]");
    public static By otpsubmitbtn = By.xpath("//button[text()='Request OTP']");
    public static By otpverifybtn = By.xpath("//button[text()='Verify']");

    public static By accountholdername = By.xpath("//a[@title='Rajesh']");

    public static By continuebtn = By.xpath("//span[text()='CONTINUE']/ancestor::button");

    public static By otpfield = By.xpath("//span[text()='Enter OTP']/preceding::input[@maxlength='6']");

    public static By signupbtn = By.xpath("//span[text()='Signup']/ancestor::button");


}
