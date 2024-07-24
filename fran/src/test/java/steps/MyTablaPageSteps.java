package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.MyTablaPage;

public class MyTablaPageSteps {
    
    MyTablaPage tb = new MyTablaPage();

    @Given("^Yo navego en una tabla estatica$")
    public void metodo1(){
        tb.navegarAGoogle();
    }

    @Then("^Yo puedo regresar el valor si deseo$")
    public void metodo2(){
        tb.hoverOverElementt();
        
    }

}
