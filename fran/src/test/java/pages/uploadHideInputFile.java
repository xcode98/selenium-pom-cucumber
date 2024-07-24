package pages;

import java.io.File;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class uploadHideInputFile extends BasePage{

    public uploadHideInputFile(){
        super(driver);
    }
    
    //String locator = "//SPAN[text()='Seleccionar archivo PDF']";
    //String input = "//input[@id='html5_1h3o9fvq71khcsku14nr1vg11fva4']";

    String classNameInput = "html5_1h3o9fvq71khcsku14nr1vg11fva4";
    

    
    public void idk(){
        File file = new File("/Users/francis/Downloads/franciss12.pdf");
        String path = file.getAbsolutePath();
        driver.get("https://www.ilovepdf.com/es/pdf_a_word");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        

        //WebElement inputElement = (WebElement) jse.executeScript("return document.querySelector('input[type=\"file\"][accept=\".pdf\"]');");
        Object obj = jse.executeScript("return document.querySelector('input[type=\"file\"][accept=\".pdf\"]');");
        WebElement inputElement = (WebElement) obj;
        inputElement.sendKeys(path);
        
        //espera de 5 segundos
        try {
            Thread.sleep(10000);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

        WebElement inputElement2 = (WebElement) jse.executeScript("return document.querySelector('button#processTask.btn.btn--process.btn--red.pdfoffice.pulse');");
        inputElement2.click();

    }



}
