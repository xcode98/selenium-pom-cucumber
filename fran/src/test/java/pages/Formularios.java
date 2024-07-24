package pages;

public class Formularios extends BasePage {
    
    private String buscandoComboBox = "(//div[contains(.,'Select State')])[12]";
    
    private String buscandoElementCombo="//div[contains(text(),'NCR')]";


    public Formularios(){
        super(driver);
    }

    public void navegarAGoogle(){
        navegarAGoogle("https://demoqa.com/automation-practice-form");
    }

    public void escribiendotest(){
        clickElement(buscandoComboBox);
        clickElement(buscandoElementCombo);
        
    }

    /*
    public void seleccionandoTextoVisibleDelComboBox(){
        clickElement(buscandoComboBox);
        clickElement(buscandoElementCombo);
        
    } */

}
