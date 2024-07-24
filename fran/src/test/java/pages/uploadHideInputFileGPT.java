package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class uploadHideInputFileGPT extends BasePage{

public uploadHideInputFileGPT(){
    super(driver);
}


public void idk() {
    String filePath = "/Users/francis/Downloads/franciss12.pdf";
    driver.get("https://www.ilovepdf.com/es/pdf_a_word");

    WebDriverWait wait = new WebDriverWait(driver, 10);
    By inputLocator = By.cssSelector("input[type='file'][accept='.pdf']");
    WebElement inputElement = wait.until(ExpectedConditions.presenceOfElementLocated(inputLocator));
    inputElement.sendKeys(filePath);

    // Espera de 5 segundos
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    By buttonLocator = By.cssSelector("button#processTask.btn.btn--process.btn--red.pdfoffice.pulse");
    WebElement inputElement2 = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
    inputElement2.click();
} 
}
