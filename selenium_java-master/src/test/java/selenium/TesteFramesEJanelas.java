package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFramesEJanelas {

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
    public void deveIntergirComBotaoDentroDoFrame() {

        driver.switchTo().frame("frame1");
        driver.findElement(By.id("frameButton")).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Frame OK!", msg);
        alert.accept();
        driver.switchTo().defaultContent();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);

    }

    @Test
    public void deveIntergirComJanela() {

        driver.findElement(By.id("buttonPopUpEasy")).click();
        driver.switchTo().window("Popup");
        driver.findElement(By.tagName("textarea")).sendKeys("Teste");
        driver.close();
        driver.switchTo().window("");
        driver.findElement(By.tagName("textarea")).sendKeys("Teste");

    }

    @Test

    public void deveIntergirComJanelaSemTitulo() {

        driver.findElement(By.id("buttonPopUpHard")).click();
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        // driver.switchTo().window(driver.getWindowHandle().toCharArray()[1]);
        driver.findElement(By.tagName("textarea")).sendKeys("Teste");
    }

}
