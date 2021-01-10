package selenium;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializa() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.manage().window().maximize();
        dsl = new DSL(driver);
    }

    @After
    public void finaliza() {
        driver.quit();

    }

   

    @Test
    public void deveInteragirComInputText() {
        dsl.escreve("elementosForm:nome", "Carolina");
        dsl.escreve("elementosForm:sobrenome", "Mesquita");
       
        Assert.assertEquals("Carolina", dsl.obterValorCampo("elementosForm:nome"));
        Assert.assertEquals("Mesquita", dsl.obterValorCampo("elementosForm:sobrenome"));

    }

    @Test
    public void deveInteragirComTextArea() {
       dsl.escreve("elementosForm:sugestoes", "teste");
        Assert.assertEquals("teste", dsl.obterValorCampo("elementosForm:sugestoes"));
  

    }

    @Test
    public void deveInteragirComRadioButton() {
        dsl.clicar("elementosForm:sexo:0");
        Assert.assertTrue(dsl.isSelecionado("elementosForm:sexo:0"));

    }

    @Test
    public void deveInteragirComCheckBox() {
        dsl.clicar("elementosForm:comidaFavorita:0");      
        Assert.assertTrue(dsl.isSelecionado("elementosForm:comidaFavorita:0"));

    }

    @Test
    public void deveInteragirCombo() {
       
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        // combo.selectByIndex(4);
        // combo.selectByValue("superior");
        combo.selectByVisibleText("Superior");
        Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());

    }

    @Test
    public void deveVerificarValoresCombo() {
       
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        Assert.assertEquals(8, options.size());

        boolean encontrou = false;

        for (WebElement option : options) {
            if (option.getText().equals("Mestrado")) {
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);

    }

    @Test
    public void deveVerificarValoresComboMultiplo() {
       
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");

        List<WebElement> selecioneTodasAsOpcoes = combo.getAllSelectedOptions();
        Assert.assertEquals(3, selecioneTodasAsOpcoes.size());

        combo.deselectByVisibleText("Corrida");
        List<WebElement> selecioneTodasAsOpcoes1 = combo.getAllSelectedOptions();
        Assert.assertEquals(2, selecioneTodasAsOpcoes1.size());

    }

    @Test
    public void deveInteragirComBotoes() {
        
        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();

        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

    }

    @Test
    public void deveInteragirComLink() {
       
        WebElement link = driver.findElement(By.id("resultado"));
        link.click();

    }

    @Test
    public void deveInteragirComTestoNaPagina() {
       
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
        Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                driver.findElement(By.className("facilAchar")).getText());

    }

}
