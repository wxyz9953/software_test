package cn.edu.tju.wxy;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Sender {

    private final static String driverPath = System.getProperty("user.dir") +
            File.separator + "resource" + File.separator + "chromedriver";

    private final static String baseUrl = "http://103.120.226.190/selenium-demo/git-repo";

    private final static String userXPath = "/html/body/div/div/div/div/div/div/div[2]/div/form/div[1]/input";
    private final static String passwordXPath = "/html/body/div/div/div/div/div/div/div[2]/div/form/div[2]/input";
    private final static String buttonXPath = "/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input";
    private WebDriver driver;

    public Sender() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("headless");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(option);
    }


    public String getResponseMessage(String user, String password) {
        driver.get(baseUrl);
        driver.findElement(By.xpath(userXPath)).sendKeys(user);
        driver.findElement(By.xpath(passwordXPath)).sendKeys(password);
        driver.findElement(By.xpath(buttonXPath)).click();
        List<WebElement> list = driver.findElements(By.className("mb-2"));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            WebElement we = (WebElement) it.next();
            String text = we.getText();
            if (!text.equals("")) {
                return text;
            }
        }
        return "";
    }
}