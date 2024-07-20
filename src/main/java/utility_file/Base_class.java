package utility_file;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_class {
    public static WebDriver driver;
    public static void moveToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public static WebDriverWait explicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait;

    }
    public static void javascriptsendkeys(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='8072305936'",element);
    }

    public static void selectByVisibleText(WebElement element,String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void javascriptscrollintoview(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",element);
    }

    public static void log(String text){
        System.out.println(text);
    }

}
