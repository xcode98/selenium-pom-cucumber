package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en_old.Ac;
import io.cucumber.java.hu.De.Des;

public class Cobranza extends BasePage{
    
    //Locators from Login
    String inputUser = "//input[@placeholder='Usuario']";
    String inputPass = "//input[@placeholder='Contraseña']";
    String button = "//span[normalize-space()='Iniciar sesión']";

    //Locator from Menus:
    String enlaceContabilidad = "//a[@data-bs-target='#kt_aside_nav_tab_accounting']";
    String menuCobranza = "//span[@class='menu-link']//span[@class='menu-title'][normalize-space()='Cobranzas']";
    String moduloCobranza = "//a[@class='menu-link']//span[@class='menu-title'][normalize-space()='Cobranzas']";

    //Locators from list Cobranza:
    String buttonCreate = "//a[normalize-space()='Agregar']";

    //Locator from form Create Cobranza Datos Generales:
    String inputMoneda = "//div[@class='el-input el-input--large el-input--suffix']";
    String soles = "//SPAN[text()='Soles']";
    String descripcion = "//div[@class='el-textarea']//textarea";

    //Locators from tab Doc. usando factura:
    String Agregar = "//div[@id='pane-docs']//button[@class='btn btn-add-recipe']";

    //Locator from modal Agregar doc.
    String inputaddClient = "//INPUT[@id='client']";
    String resultadoClient = "//SPAN[text()='Avenger S.A.C']";
    String buttonSearch = "//button[contains(@class, 'btn btn-sm btn-primary p-3')]"; //BUTTON[@data-v-fb5ad9ae=''])[1]
    String checkBoxDocumentos = "(//INPUT[@class='form-check-input'])[2]";
    String addDocument = "//button[contains(@class, 'btn btn-lg btn-primary')]";

    //Table Doc.
    String inputAmountToApply = "//div[@col-id='montoAplicar']//div[@class='d-flex justify-content-between']";
    

    //tab Cobranza
    String tabCobranza = "//div[@id='tab-collection']";
    String tipoConcepto = "//div[@col-id='tipoConcepto']//div[@class='d-flex justify-content-between']";
    String tpCobranzaDirecta = "//SPAN[text()='Cobranza Directa']";

    String medioPago = "//div[@col-id='medioPago']//div[@class='d-flex justify-content-between']";
    String opMedioPago = "//SPAN[text()='Otros medios de pago']";

    String nameBank = "//div[@col-id='cuentaBancaria']//div[@class='d-flex justify-content-between']";
    String opnameBank = "//SPAN[text()='BP - SOL - 4213-5364-3516-3512']";

    String importePagado = "//div[@col-id='importePagado']//div[@class='d-flex justify-content-between']";
    
    //Seccion general
    String buttonGuardar = "//BUTTON[@type='button'][text()=' Guardar ']";
    String confirmacionGuardar = "//BUTTON[@type='button'][text()='Si, guardar']";

    String divLocator = "//div[@class='ag-body-horizontal-scroll-viewport']";
    String Aceptar = "//BUTTON[@type='button'][text()=' Aceptar ']";

    public Cobranza(){
        super(driver);
    }
    public void navegatePage(){
        navegarAGoogle("https://erpfundicioncentral.test.delfosti.site/#/sign-in"); 
    }


    public void login(){
        escribir(inputUser, "admin");
        
        escribir(inputPass, "12345678");
        clickElement(button);
    }

    public void goingToCobranza(){
        clickElement(enlaceContabilidad);
        clickElement(menuCobranza);
        clickElement(moduloCobranza);
    }
    
    public void createRegister(){
        clickElement(buttonCreate);
        try {
            Thread.sleep(2000); // agrega 2 segundos de espera
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
      
    public void formCobranzaDatosGenerales(){
        
        //Completando Datos generales
        clickElement(inputMoneda);
        clickElement(soles);
        escribir(descripcion,"Cobranza de prueba");
        scrollDown(500);
    }
    
    public void modalDocumento(){
        //Completando tab Doc. usando factura
        clickElement(Agregar);
        esperar(1000);
        clickElement(inputaddClient);
        escribir(inputaddClient, "Ave");
        esperar(2000);
        clickElement(resultadoClient);
        clickElement(buttonSearch);
        clickElement(checkBoxDocumentos);
        clickElement(addDocument);
    }

    public void tableDocumento() {
        
        clickElement(inputAmountToApply);
        esperar(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.CONTROL + "a").perform(); // Selecciona todo el texto
        esperar(500); // Espera medio segundo para asegurarse de que la selección se registre
        actions.sendKeys(Keys.DELETE).perform(); // Borra el contenido seleccionado
        esperar(500); // Espera medio segundo para asegurarse de que el borrado se registre
        actions.sendKeys("2").perform();
    }

    public void tabCobranza(){
        
        clickElement(tabCobranza);

        doubleClickElement(tipoConcepto);
        esperar(500);
        clickElement(tpCobranzaDirecta);

        doubleClickElement(nameBank);
        esperar(500);
        clickElement(opnameBank);

        doubleClickElement(medioPago);
        esperar(500);
        clickElement(opMedioPago);

        clickElement(importePagado);
        esperar(500);
        
        Actions actions = new Actions(driver);
        actions.sendKeys("1").perform();
        
    }
    
    
    public void saveRegister(){
        scrollDown(500);
        clickElement(buttonGuardar);
        //clickElement(confirmacionGuardar);
        //clickElement(Aceptar);
        closeBrowser();
    }
    

}
