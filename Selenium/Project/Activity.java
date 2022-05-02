package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class Activity {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test(priority = 0)
    public void websitetitle(){
        //Verify the website title
        String pagetitle = driver.getTitle();
        Assert.assertEquals(pagetitle, "OrangeHRM");
    }

    @Test(priority = 1)
    public void headerimgurl(){
        WebElement headerimg  = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/img"));
        System.out.println("Header Image Url is: " +headerimg.getAttribute("src"));
    }

    @Test(priority = 2)
    @Parameters({"username", "password"})
    public void Login(String username, String password){
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        String welcome_homepage = driver.findElement(By.id("menu_dashboard_index")).getText();
        Assert.assertEquals(welcome_homepage, "Dashboard");
    }

    @Test(priority = 3)
    public void add_employee() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewPimModule")));
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("Swangi");
        driver.findElement(By.id("lastName")).sendKeys("Singh");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("empsearch_employee_name_empName")));
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Swangi");
        driver.findElement(By.id("searchBtn")).click();
        Thread.sleep(2000);
        String data = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]/a")).getText();
        Assert.assertEquals(data, "Swangi");
    }

    @Test(priority = 4)
    public void edit_user_Info() {
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Swangi");
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Singh");
        driver.findElement(By.id("personal_optGender_2")).click();
        Select dropdown = new Select(driver.findElement(By.id("personal_cmbNation")));
        dropdown.selectByVisibleText("Indian");
        driver.findElement(By.id("personal_DOB")).clear();
        driver.findElement(By.id("personal_DOB")).sendKeys("1994-11-22");
        driver.findElement(By.id("btnSave")).click();
        System.out.println("Data Saved Successfully");

    }

    @Test(priority = 5)
    public void directory_menu(){
        //Verify that the "Directory" menu item is visible and clickable.
        boolean visible =  driver.findElement(By.id("menu_directory_viewDirectory")).isDisplayed();
        boolean clickable =driver.findElement(By.id("menu_directory_viewDirectory")).isEnabled();

        if (visible == true && clickable == true) {
            //If clickable, click on the menu item.
            driver.findElement(By.id("menu_directory_viewDirectory")).click();
            driver.findElement(By.id("menu_directory_viewDirectory")).click();
        }
        String searchtext = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1")).getText();
        Assert.assertEquals(searchtext, "Search Directory");
    }

    @Test(priority = 6)
    public void add_qualification(){
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.linkText("Qualifications")).click();
        //driver.findElement(By.xpath("(//a[text() ='Qualifications'])[2]")).click();
        driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Test Engineer");
        driver.findElement(By.id("btnWorkExpSave")).click();
    }

    @Test(priority = 7)
    public void apply_leave(){
        driver.findElement(By.id("menu_dashboard_index")).click();
        driver.findElement(By.id("menu_dashboard_index")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/img")).click();
        Select dropdown = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        dropdown.selectByVisibleText("DayOff");
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2022-04-01");
        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2022-04-01");
        driver.findElement(By.id("applyBtn")).click();
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        String leavedetails = driver.findElement(By.linkText("Pending Approval(1.00)")).getText();
        System.out.println(leavedetails);
        Assert.assertEquals(leavedetails, "Pending Approval(1.00)");
    }

    @Test(priority = 8)
    public void emergency_contacts() throws InterruptedException {
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        driver.findElement(By.linkText("Emergency Contacts")).click();
        driver.findElement(By.linkText("Emergency Contacts")).click();

       // Grab the table
        WebElement table = driver.findElement(By.id("emgcontact_list"));

        // Now get all the TR elements from the table
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        // And iterate over them, getting the cells
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.println("content >>   " + cell.getText());
            }
        }
    }
    @AfterClass
    public void teardown(){

        driver.close();
    }

}
