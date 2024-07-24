package pages;

public class MyTablaPage extends BasePage{
    
    //private String locatorr = "//body/div[@id='root']/div[1]";
    private String locatorr = "/html/body";
    //private String locator2 = "/html/body/table/tbody/tr[" + 1 + "]/td[" + 1 + "]";

    public MyTablaPage(){
        super(driver);
    }

    public void navegarAGoogle(){
        navegarAGoogle("file:///Users/francis/Desktop/lest/King/src/test/java/pages/tabla.html");
    }

    public void hoverOverElementt(){
         //clickElement(locator2);
         setValueFromTablee(locatorr,3,2,"");
        
    }

}
