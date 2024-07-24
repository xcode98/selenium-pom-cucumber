package steps;

import io.cucumber.java.en.*;
import pages.Formularios;

public class FormularioSteps {
    
    Formularios fs = new Formularios();

    @When("^Navengando$")
    public void navegandoAlFormulario(){
       fs.navegarAGoogle();
    }

    @Then("^Seleccionandoo$")
    public void seSelecciono(){
        fs.escribiendotest();
    }

   

}
