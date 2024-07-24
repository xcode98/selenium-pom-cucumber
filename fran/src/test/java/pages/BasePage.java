package pages;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
    
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;

    static{
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver,10);
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public static void navegarAGoogle(String url){
        driver.get(url);
    }

    //
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void buscar(String locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void escribir(String locator,String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void seleccionandoElContenidoDeUnComboBox(String locator,String textoVisible){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(textoVisible);
    }

    public void hoverOverElement(String locator){ 
        actions.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        actions.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        actions.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int fila, int columna){
        String cellINeed = locator+"/table/tbody/tr["+fila+"]/td["+columna+"]";
        return Find(cellINeed).getText();
    }

    public void setValueFromTable(String locator, int fila, int columna, String cadena){
        String cellINeed = locator+"/table/tbody/tr["+fila+"]/td["+columna+"]";
        Find(cellINeed).sendKeys("Francis");
    }

    

    public void setValueFromTablee(String locator, int fila, int columna, String cadena){
        String cellINeed = locator + "/table/tbody/tr[" + fila + "]/td[" + columna + "]/input";
        escribir(cellINeed, "Francis");
    }

    public String textFromElement(String locator){
        return Find(locator).getText();
    }




    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void validateText(String locator, String textToValidate){
        Assert.assertEquals(textToValidate, Find(locator).getText());
    }

    public boolean elenentEnabled (String locator){
        return Find(locator).isEnabled();
    }
    public boolean elenentIsDisplayed (String locator){
        return Find(locator).isDisplayed();
    }
    public boolean elenentisSelected(String locator){
        return Find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.xpath(locator));
    }

    public static void closeBrowser(){
        driver.close();
    }

}

