package pages;

public class TablaLearn extends BasePage {

    private String celdaLocator = "//*[@id='root']/div/";

    public TablaLearn(){
        super(driver);
    }

    public void navegarATablaPage(){
        navegarAGoogle("https://1v2njkypo4.csb.app");
    }

    public String getValueFromGrid(int fila, int columna){
        return getValueFromTable(celdaLocator, fila,columna);
    }

}
