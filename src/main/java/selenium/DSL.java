package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import sun.jvm.hotspot.ci.ciEnv;

public class DSL {

    private WebDriver driver;
    

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void escreve(String id_campo, String texto){
        driver.findElement(By.id(id_campo)).sendKeys(texto);

    }
    public String obterValorCampo(String id_campo){
       return driver.findElement(By.id(id_campo)).getAttribute("value");
    }

    public void clicar(String id_campo){
        driver.findElement(By.id(id_campo)).click();

    }
    public boolean isSelecionado(String id_campo){
        return driver.findElement(By.id(id_campo)).isSelected();
    }
    
   
    
}
