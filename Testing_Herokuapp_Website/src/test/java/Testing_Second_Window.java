import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Testing_Second_Window {
    WebDriver Driver ; /*Main Object To Work With All Functions*/

    /*Before Class To Obtain The Code Inside Only One Time At Initial of Script*/
    @BeforeClass
public void Open_Browser_Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();// Setup The Chrome Driver
        Driver=new ChromeDriver(); // Create Object From Setup Chrome Driver
        Driver.manage().window().maximize();// Here We Maximize TheChrome Page
        Driver.get("https://www.google.com/"); // Get Request To Open Google Page First
        Driver.navigate().to("https://the-internet.herokuapp.com/"); // Then Navigate On The Test Website
        Thread.sleep(1000);
        // Here Use Partial Link Text Locator To Find First Link Name "Form" To Open Internal link in page
        Driver.findElement(By.partialLinkText("Sortable")).click();
        Thread.sleep(4000);

    }
    /*After Class To Obtain The Code Inside Only One Time At Last of Script*/
    @AfterTest
    public void Close_Browser()
    {
        Driver.quit(); // Here To Quit The Whole Program Not Just Close Chrome
    }

@Test
    public void Getting_Table_Data()
{
    WebElement table =Driver.findElement(By.id("table1"));
    List<WebElement> table_rows=table.findElements(By.tagName("tr"));
    System.out.println("The Total Number of Rows = "+table_rows.size()); // Used To Get The numbers of rows
    System.out.println(table_rows.get(0).getText()); // Get First Row which is index =0 and get text
    System.out.println(table_rows.get(1).getText()); // Get Second Row which is index =1 and get text
    System.out.println(table_rows.get(2).getText()); // Get Third Row which is index =2 and get text
    System.out.println(table_rows.get(3).getText()); // Get Fourth Row which is index =3 and get text
    System.out.println(table_rows.get(4).getText()); // Get Fifth Row which is index =4 and get text
}
}
