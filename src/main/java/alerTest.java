import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class alerTest {
    static WebDriver driver;
    private static String url = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm";

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new ChromeDriver ();
        //Navigate to URL
        driver.navigate ().to ( url );
        //Maximize the browser window
        driver.manage ().window ().maximize ();
    }

    @Test
    public void ConfirmExampleTest() {

        driver.switchTo ().frame ( "iframeResult" );
        WebElement confirmButton = driver.findElement ( By.cssSelector ( "html>body>button" ) );
        WebElement actualConfirmMessage = driver.findElement ( By.cssSelector ( "#demo" ) );

        //TC001
        confirmButton.click ();
        driver.switchTo ().alert ().accept ();
        assertThat ( "You pressed OK!", is ( actualConfirmMessage.getText () ) );

        //TC002
        confirmButton.click ();
        driver.switchTo ().alert ().dismiss ();
        assertThat ( "You pressed Cancel!", is ( actualConfirmMessage.getText () ) );

        //TC003
        String kk = driver.findElement(By.tagName("h2")).getText ();
        System.out.println(kk);
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit ();
    }
}
