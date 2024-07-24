package pages;

import java.util.Set;

public class Reniec extends BasePage {

    String primerLink = "//body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[20]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]";
    String segundoLink = "//a[contains(text(),'CONSULADOS EN EL MUNDO')]";
    String tercerLink = "//a[contains(text(),'Lista de Consulados en el mundo')]";

    String comboBox = "//input[@id='txtSearch']";

    String butonSearch = "//img[@class='imgSearchLupa']";



    public Reniec(){
        super(driver);
    }
    public void navegatePage(){
        navegarAGoogle("https://www.reniec.gob.pe/portal/masServiciosLinea.htm"); 
    }

    public void clickEnPeruanosExtrajero(){
        clickElement(primerLink);
    }

    public void clickenPeruanosMundo(){
        clickElement(segundoLink);   
    }

     private void waitForNewTab() {
        int attempts = 0;
        while (driver.getWindowHandles().size() == 1 && attempts < 5) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            attempts++;
        }
    }   

    public void linkParaAbrirOtrapestana(){
        clickElement(tercerLink);
        String originalWindow = driver.getWindowHandle();
        waitForNewTab();
        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        escribir(comboBox, "cuenca");
        clickElement(butonSearch);
        driver.switchTo().window(originalWindow);

    }
}
