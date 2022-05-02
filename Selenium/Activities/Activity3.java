package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
            WebDriver driver = new FirefoxDriver();
            driver.get("https://training-support.net/selenium/simple-form");
            String title = driver.getTitle();
            System.out.println("Page Title: " + title);

           //Find the input fields and enter text
            driver.findElement(By.id("firstName")).sendKeys("Swangi");
            driver.findElement(By.id("lastName")).sendKeys("Singh");
            driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
            driver.findElement(By.id("number")).sendKeys("9123276543");
            driver.findElement(By.cssSelector("input.green")).click();
            driver.close();

        }




}
