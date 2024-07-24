package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ListaCiudadesyPaises extends BasePage{
    
    public String inputBusqueda = "//INPUT[@id='LocationSearch_input']";
    public String listaResultados = "//div[@id='LocationSearch_listbox']";
    

    public ListaCiudadesyPaises(){
        super(driver);
    }

    public void navegarPagina(){
        navegarAGoogle("https://weather.com/es-PE/tiempo/hoy/l/PEXX0011:1:PE?Goto=Redirected");
        // Localiza el elemento <div> que deseas ocultar
        WebElement divElement = driver.findElement(By.id("consent_blackbar"));

        // Utiliza JavaScript para modificar el estilo del elemento y ocultarlo
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display = 'none';", divElement);
    }

    public void realizarBusqueda(String city) throws InterruptedException{
        
        Thread.sleep(5000);
        escribir(inputBusqueda, city);
        Thread.sleep(5000);
    }

    public List<String> getAllSearchResults(){ //quiero obtener una lista de strings cogidas de un lista de WebElement
        List<WebElement> list = bringMeAllElements(listaResultados); //capturamos la List <WebElement> en una variable list de tipo List <WebElemen
        List<String> stringsFromList = new ArrayList<String>(); //creame un arraylist llamado stringsFromList
        for(WebElement e:list){ //por cada elemento que encuentres en la List <WebElement> bringMeAllElements 
            stringsFromList.add(e.getText());
        }

        System.out.println("Contenido del ArrayList:");
        for(String element : stringsFromList){ //por cada string que encuentres en el List<String> stringsFromList 
        System.out.println(element);           //esto se va a repetir hasta que la condicion del for termine, es decir hasta a ver iterado cada string de la lista
    }

        return stringsFromList;
    }
}
