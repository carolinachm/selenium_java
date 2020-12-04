package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {
    @Test
    public void deveAbrirOCampoTreinamento(){
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    //driver.quit();
    }
    @Test
    public void devePreencherOsCamposNomeESobrenome(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Carolina");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Mesquita");

        Assert.assertEquals("Carolina",driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
        Assert.assertEquals("Mesquita",driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));


    }
    
}
