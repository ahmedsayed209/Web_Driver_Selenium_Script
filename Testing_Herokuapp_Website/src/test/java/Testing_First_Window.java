import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing_First_Window {
   private WebDriver Driver ; /*Main Object To Work With All Functions*/

    /*Before Class To Obtain The Code Inside Only One Time At Initial of Script*/
    @BeforeClass
public void Open_Browser_Setup()
    {
        WebDriverManager.chromedriver().setup();// Setup The Chrome Driver
        Driver=new ChromeDriver(); // Create Object From Setup Chrome Driver
        Driver.manage().window().maximize();// Here We Maximize TheChrome Page
        Driver.get("https://www.google.com/"); // Get Request To Open Google Page First
        Driver.navigate().to("https://the-internet.herokuapp.com/"); // Then Navigate On The Test Website
        // Here Use Partial Link Text Locator To Find First Link Name "Form" To Open Internal link in page
        Driver.findElement(By.partialLinkText("Form")).click();

    }
    /*After Class To Obtain The Code Inside Only One Time At Last of Script*/
    @AfterTest
    public void Close_Browser()
    {
        Driver.quit(); // Here To Quit The Whole Program Not Just Close Chrome
    }

    /* First Test With Highest Priority That To Enter UserName Inside TextField */
    @Test (priority = 0)
    public void User_Name_Insertion () throws InterruptedException {
      Driver.findElement(By.id("username")).sendKeys("tomsmith");
      Thread.sleep(1000);
    }
    /* Second Test That To Enter Password Inside TextField */
    @Test (priority = 1)
    public void Password_Insertion () throws InterruptedException {
        Driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        Thread.sleep(1000);
    }

    /*Third Test That To Press on Login Button To Enter The Page */
    @Test (priority = 2)
    public void Login_Function() throws InterruptedException {
        Driver.findElement(By.className("radius")).click();
        Thread.sleep(1000);
    }

    /*Fourth Test That To Press on LogOut Button To Logout from The Page */
    @Test (priority = 3)

       public void Logout_Function() throws InterruptedException {
        Driver.findElement(By.xpath("//a[@class = 'button secondary radius']")).click();
        Thread.sleep(1000);
    }

}
