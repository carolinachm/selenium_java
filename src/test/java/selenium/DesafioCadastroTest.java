package selenium;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioCadastroTest {

    private WebDriver driver;

    @Before
    public void inicializa() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.manage().window().maximize();
    }

    @After
    public void finaliza() {
        driver.quit();

    }

    @Test
    public void deveClicarNoBotaoCadastrar() {

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Carolina");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Mesquita");
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Superior");

        new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Corrida");

        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Assert.assertEquals("Cadastrado!",
                driver.findElement(By.xpath("//span[contains(text(),'Cadastrado!')]")).getText());

    }

}
