package formFiller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class formFiller {

    private WebDriver driver;

    @Before

    public void setUp() {

        //prepare borwser to test

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");


    }

    @Test

    public void formFillerAmazon() {


        // filling form and submit

        WebElement name = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        name.clear();
        name.sendKeys("Karol");
        name.submit();

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.clear();
        lastName.sendKeys("Kowalski");
        name.submit();

        WebElement gender = driver.findElement(By.xpath("/html/body/div/div/form/div[3]/div/div/label[1]/input"));
        gender.click();

        WebElement dateOfBirth = driver.findElement(By.id("dob"));
        dateOfBirth.clear();
        dateOfBirth.sendKeys("05/22/2010");
        dateOfBirth.submit();

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Prosta 51");
        address.submit();

        WebElement eMail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        eMail.clear();
        eMail.sendKeys("karol.kowalski@mailinator.com");
        eMail.submit();

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("Pass123");
        password.submit();

        WebElement company = driver.findElement(By.xpath("/html/body/div/div/form/div[8]/div/input"));
        company.clear();
        company.sendKeys("Coders Lab");
        company.submit();

        WebElement role = driver.findElement(By.name("role"));
        role.sendKeys("QA");
        role.submit();

        //multiple selection values
        Select jobExpectation = new Select(driver.findElement(By.id("expectation")));
        jobExpectation.selectByIndex(1);
        jobExpectation.selectByVisibleText("Challenging");

        //ways of development selection
        WebElement waysOfDevelopment = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[11]/div/div[4]/label/input"));
        waysOfDevelopment.click();

        WebElement comment = driver.findElement(By.cssSelector("#comment"));
        comment.clear();
        comment.sendKeys("My first automatic test");
        comment.submit();

    }

    @After
    public void tearDown() throws Exception {

        //assertion and borwser close

        WebElement succesText = driver.findElement(By.id("submit-msg"));
        String expectedText = succesText.getText();
        Assert.assertEquals("Successfully submitted!" , expectedText);
        System.out.println("Assert Equals test passed");

        driver.quit();
        }



    }




