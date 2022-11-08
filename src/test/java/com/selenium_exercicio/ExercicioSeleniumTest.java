package com.selenium_exercicio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExercicioSeleniumTest {
	
	protected WebDriver driver;
	
	@BeforeClass
	public static void configuraDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\renan\\Downloads\\chromedriver_win32\\chromedriver.exe");
	}
	
    @Before
    public void createDriver() {  
		driver = new ChromeDriver();
        driver.get("https://pt.wikipedia.org/wiki/Wikip%C3%A9dia:P%C3%A1gina_principal");
    }	

	@Test
	public void test() {
		WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div/header/div[2]/div/a"));
		search.click();
		
		WebElement searchBeyonce = driver.findElement(By.name("search"));
		searchBeyonce.sendKeys("Beyoncé", Keys.RETURN);
		WebElement searchResult = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/main/div[2]/div[3]/div[3]/div[2]/ul/li[1]/table/tbody/tr/td[2]/div[1]/a/span"));
		searchResult.click();
		
		String age = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/main/div[2]/div[3]/div[1]/table[1]/tbody/tr[5]/td[2]/span")).getText();
		age = age.replace(" de 1981 (41 anos)", "");
		assertTrue(age.equals("4 de setembro"));
	}
	
    @After
    public void quitDriver() {
       driver.quit();
    }
}
