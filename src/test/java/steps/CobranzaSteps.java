package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Cobranza;

public class CobranzaSteps {
    
    Cobranza cc  = new Cobranza();

    

    @Given("^El usuario se dirige al modulo Cobranzas$")
    public void navegateToPageStep(){
       cc.navegatePage();
       cc.login();
       cc.goingToCobranza();
    }

    @When("^Registra una cobranza con los tabs Doc. usando factura y el tab cobranza$")
    public void addRegister(){
        cc.createRegister();
        cc.formCobranzaDatosGenerales();
        cc.modalDocumento();
        cc.tableDocumento();
        cc.tabCobranza();
        cc.saveRegister();
    }

    @Then("^Este nuevo registro de muestrara en la lista de Cobranzas$")
    public void abriendoOtrapestana(){
        
    }



}
