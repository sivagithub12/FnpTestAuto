package Fnptest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

//import org.testng.annotations.Test;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.BeforeClass;

import java.io.IOException;
//import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;


public class Fnptest
{	
	public static WebDriver driver;	
	
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws InterruptedException
  {
	  //Implicit Wait
	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	 
	  
	  //Explicit wait  //Expected Condition wait
	  //WebDriverWait wait = new WebDriverWait(driver, 10);   
	  
	  //Page Load Timeout Exception (Type of Explicit Wait)
	  //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  
	  driver.get("http:\\www.fnp.com");
	  //driver.get("https://www.fnp.com/");
	  System.out.println("Website Launched...........................");	  
	  //Set Script Timeout Exception
	  //driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	  System.out.println("Cell value returned...........................");
	  Thread.sleep(5000);
	  
	  //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='react-root']/section[1]/main[1]/article[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]/input[1]")));
	  driver.findElement(By.xpath("//i[contains(text(),'account_circle')]")).click();
	  System.out.println("Guest dropdown clicked............................");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
	  System.out.println("Login Button clicked...........................");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//input[@id='standard-basic']")).click();
	  System.out.println("Clicked inside Username textbox...........................");
	  Thread.sleep(2000);	  
	  driver.findElement(By.xpath("//input[@id='standard-basic']")).sendKeys(username);
	  System.out.println("Username entered...........................");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='main']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]/span[1]")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//input[@id='standard-adornment-password']")).sendKeys(password);
	  System.out.println("Password entered...........................");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='main']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]/span[1]")).click();
	  System.out.println("Continue button clicked...........................");
	  Thread.sleep(5000);
	  driver.close();
	  Thread.sleep(5000);
	  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("http:\\www.google.com");
	  System.out.println("Google opened...........................");
	  Thread.sleep(5000);
  }

	/*
	 * @DataProvider public Object[][] dp() { return new Object[][] { new Object[] {
	 * 1, "a" }, new Object[] { 2, "b" }, }; }
	 */
  
  @DataProvider
  public Object[][] dp() throws IOException
  {
	  System.out.println("Inside Dataprovider Method...........................");
    GetData gd = new GetData("src\\test\\java\\Fnptest\\Retrieve.xlsx");
    int totalrows = gd.getRowNum(0);
    System.out.println("Spreadsheet Accessed..................................");
    System.out.println("Rows: "+totalrows);
    Object[][]data = new Object[totalrows][2];
    
	
	 for(int i = 1; i < totalrows; i++) 
	 {
		 data[i][0] = gd.getDataSheet(0, i, 0);
		 data[i][1] = gd.getDataSheet(0, i, 1); 
	 }
	 
    
    //data[][] = gd.getDataSheet(totalrows, totalrows, totalrows)
    
    return data;  
  };
  
  
  
  @BeforeClass
  public void beforeClass() throws InterruptedException 
  {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  //driver.get("https://www.amazon.com");
	  
	  
  }

  @AfterClass
  public void afterClass() 
  {
	  
  }

}



/*
 * <!-- https://mvnrepository.com/artifact/org.apache.poi/poi --> <dependency>
 * <groupId>org.apache.poi</groupId> <artifactId>poi</artifactId>
 * <version>4.1.1</version> </dependency>                        
 */
