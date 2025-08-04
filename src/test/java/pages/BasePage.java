package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BasePage {
    
    protected static WebDriver driver;
    private static WebDriverWait wait;

    static{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,10);
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public static void navegarAGoogle(String url){
        driver.get(url);
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    private WebElement Find2(String locator){
        WebElement element = driver.findElement(By.xpath(locator));
        return element;
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void escribir(String locator,String textToWrite){        
        Find(locator).sendKeys(textToWrite);
    }
    
    public static void closeBrowser(){
        driver.quit();
    }

    public void esperar(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + pixels + ")");
    }


    public void scrollRight(String divLocator, int pixels) {
        WebElement element = Find2(divLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollLeft += " + pixels, element);
    }

    public void doubleClickElement(String locator){
        WebElement element = Find(locator);
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void moveToElement(String locator){
        WebElement element = Find2(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void borrarCampo(String locator) {
        Find(locator).sendKeys(Keys.BACK_SPACE);
    }

    public void xd(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@col-id='montoAplicar']//div[@class='d-flex justify-content-between']")));

        // Haz clic en el elemento (si es necesario)
        amountElement.click();
        esperar(1000); // Espera un segundo para asegurarse de que el clic se registre

        // Usa acciones del teclado para seleccionar todo el texto y luego borrarlo
        Actions actions = new Actions(driver);
        //actions.moveToElement(amountElement).click().sendKeys(Keys.CONTROL + "a").sendKeys(Keys.DELETE).perform();
        actions.sendKeys(Keys.CONTROL + "a").perform(); // Selecciona todo el texto
        esperar(500); // Espera medio segundo para asegurarse de que la selección se registre
        actions.sendKeys(Keys.DELETE).perform(); // Borra el contenido seleccionado
        esperar(500); // Espera medio segundo para asegurarse de que el borrado se registre

        // Escribe el número "1"
        actions.sendKeys("1").perform();
    }

}
