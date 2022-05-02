package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Swangi");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Singh");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@test.com");
        driver.findElement(By.xpath("//input[@id='number']")).sendKeys("9456432119");
        driver.findElement(By.xpath("//textarea")).sendKeys("Message");
        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();


    }
}
