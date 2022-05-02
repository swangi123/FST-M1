package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new FirefoxDriver();
        driver.get(" https://www.training-support.net");
    }

    @Test
    public void homePageTest(){
        //get page title
        String pagetitle = driver.getTitle();

        //Assertion for home page title
        Assert.assertEquals(pagetitle, "Training Support");
        driver.findElement(By.id("about-link")).click();
        String aboutusPageTitle = driver.getTitle();
        Assert.assertEquals(aboutusPageTitle, "About Training Support");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
