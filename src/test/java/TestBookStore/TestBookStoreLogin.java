package TestBookStore;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBookStoreLogin {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void checkLogin() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("muravlova90");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("K12345k&");
        driver.findElement(By.xpath("//div/button[@id='login']")).click();
        Thread.sleep(5000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/profile");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        }
}