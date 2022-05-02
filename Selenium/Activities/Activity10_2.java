package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);

        driver.get("https://www.training-support.net/selenium/input-events");
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        WebElement pressedKey = driver.findElement(By.id("keyPressed"));

        //Create action sequence for initials
        Action actionSequence1 = actions.sendKeys("S").build();
        actionSequence1.perform();
        System.out.println("Pressed key is: " + pressedKey.getText());

        Action actionSequence2 = actions
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .build();
        actionSequence2.perform();
        System.out.println("Pressed key is: " + pressedKey.getText());

        //Close browser
        driver.close();

    }
}
