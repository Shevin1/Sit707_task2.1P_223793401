package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C://chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */

		// Find first input field which is firstname
		WebElement firstnameElement = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + firstnameElement);
		// Send first name
		firstnameElement.sendKeys("Shevin");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		WebElement lastnameElement = driver.findElement(By.id("lastname"));
        lastnameElement.sendKeys("Fernando");

        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys("example@example.com");

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("Password@123");
		
        WebElement confirmPasswordElement = driver.findElement(By.id("confirmPassword"));
        confirmPasswordElement.sendKeys("Password@123");
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
        WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
        createAccountButton.click();

       
       
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // Save the screenshot to a file
            FileUtils.copyFile(screenshot, new File("screenshot.png"));
            System.out.println("Screenshot saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	 public static void alternative_registration_page(String url) {
		 // Step 1: Locate chrome driver folder in the local drive.
	        System.setProperty("webdriver.chrome.driver", "C://chromedriver-win64/chromedriver.exe");

	        // Step 2: Use above chrome driver to open up a chromium browser.
	        System.out.println("Fire up chrome browser.");
	        WebDriver driver = new ChromeDriver();

	        System.out.println("Driver info: " + driver);

	        sleep(2);

	        // Load a webpage in chromium browser.
	        driver.get(url);

	        // Find input fields and populate with values
	        WebElement firstNameElement = driver.findElement(By.id("full-name"));
	        firstNameElement.sendKeys("Shevin Fernando");

	        WebElement emailElement = driver.findElement(By.id("email--1"));
	        emailElement.sendKeys("example@example.com");

	        WebElement passwordElement = driver.findElement(By.id("password"));
	        passwordElement.sendKeys("Password@123");

	        // Identify button 'Sign Up' and click to submit using Selenium API.
	        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
	        signUpButton.click();

	        // Take screenshot using Selenium API.
	        //takeScreenshot(driver, "udemy_registration_page_screenshot.png");

	        // Sleep a while
	        sleep(2);

	        // Close chrome driver
	        driver.close();
	    }
	
	
}
