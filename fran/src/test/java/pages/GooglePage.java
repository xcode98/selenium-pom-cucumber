package pages;

public class GooglePage extends BasePage {
    
    private String buscarBotonBuscar = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/center[1]/input[1]";

    public String buscarCampoTexto = "//textarea[contains(@id,'APjFqb')]";

    public String elementoAComparar = "//h3[contains(text(),'Facebook - Inicia sesi\u00F3n o reg\u00EDstrate')]";

    public GooglePage(){
        super(driver);
    }

    public void navegarAGoogle(){
        navegarAGoogle("https://www.google.com");
    }

    public void clickEnBotonBuscar(){
        clickElement(buscarBotonBuscar);
    }

    public void enterAlBuscarCriterios(){
        escribir(buscarCampoTexto,"facebook");
    }

    public String firstResult(){
        return textFromElement(elementoAComparar);
    }
     
    

}
