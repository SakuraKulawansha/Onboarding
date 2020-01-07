package org.example;

import com.google.errorprone.annotations.Var;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.assertTrue;

public class testone
{
    @Test
    public void Test1 ()
    {
        try
        {
            System.setProperty("webdriver.gecko.driver", "C:\\JavaProjects\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();

            driver.manage().window().maximize();
            driver.get("http://blazedemo.com/");

            //flight search
            Select fromflight = new Select(driver.findElement(By.name("fromPort")));
            fromflight.selectByVisibleText("Boston");
            Select toFlight = new Select(driver.findElement(By.name("toPort")));
            toFlight.selectByVisibleText("London");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement findbtn = driver.findElement(By.xpath("//html/body/div[3]/form/div/input"));
            findbtn.click();

            //choosing option 2
            WebDriverWait wait1 = new WebDriverWait(driver, 25);
            WebElement flight2 = driver.findElement(By.xpath("//html/body/div[2]/table/tbody/tr[2]/td[1]/input"));
            flight2.click();

            //form filling
            WebElement name = driver.findElement(By.id("inputName"));
            name.sendKeys("John");
            WebElement Address = driver.findElement(By.id("address"));
            Address.sendKeys("Temple road,Colombo");
            WebElement city = driver.findElement(By.id("city"));
            city.sendKeys("Colombo");
            WebElement state = driver.findElement(By.id("state"));
            state.sendKeys("Colombo");
            WebElement zip = driver.findElement(By.id("zipCode"));
            zip.sendKeys("12563");
            Select payment = new Select(driver.findElement(By.name("cardType")));
            payment.selectByVisibleText("Visa");
            WebDriverWait wait2 = new WebDriverWait(driver, 25);
            WebElement creditcd = driver.findElement(By.id("creditCardNumber"));
            creditcd.sendKeys("1254123698563695");
            WebElement cardname = driver.findElement(By.id("nameOnCard"));
            cardname.sendKeys("K K K jhon");
            driver.findElement(By.id("rememberMe")).click();

            //lastpage
            WebDriverWait wait3 = new WebDriverWait(driver, 10);

            WebElement purchbtn = driver.findElement(By.xpath("//html/body/div[2]/form/div[11]/div/input"));
            purchbtn.click();

            Assert.assertEquals("http://blazedemo.com/confirmation.php", driver.getCurrentUrl());
            driver.close();
            driver.quit();


        }

        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Test 01 Fail");
        }
    }


}

