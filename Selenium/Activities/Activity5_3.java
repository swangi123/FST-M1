package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        WebElement textInput = driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("The checkbox is selected: " + textInput.isEnabled());
        driver.findElement(By.id("toggleInput")).click();

        //Print status
        System.out.println("The checkbox is selected: " + textInput.isEnabled());
        driver.close();
    }
}
