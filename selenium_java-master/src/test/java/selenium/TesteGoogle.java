package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TesteGoogle {
    @Test
    public void deveAbrirONavegador() {
        //System.setProperty("webdriver.chrome.drive", "/usr/local/bin/chromedrive");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://www.google.com";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.quit();
    }
    @Test
    public void deveVerificarOTituloDaPagina(){
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://www.google.com";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();

    }
    
}
