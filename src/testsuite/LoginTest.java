package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
    openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
//     click on the ‘Sign In’ link
       WebElement signLink = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
       signLink.click();


//     Verify the text ‘Welcome Back!’
        String expectedMessage = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[@class = 'page__heading']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid Text",expectedMessage,actualMessage);

    }

    @Test
    public void verifyTheErrorMessage(){
//        click on the ‘Sign In’ link
        WebElement signLink = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        signLink.click();
//        Enter invalid username
        WebElement usernameField = driver.findElement(By.id("user[email]"));
        usernameField.sendKeys("abc23@gmail.com");
//        Enter invalid password
        WebElement passwordField =driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("abc123");
//       Click on Login button
        WebElement signButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signButton.click();
//       Verify the error message ‘Invalid email or password.’
        String expectedMessage = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid text", expectedMessage,actualMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
