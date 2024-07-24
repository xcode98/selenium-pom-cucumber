package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Reniec;

public class ReniecSteps {
    
    Reniec reniec  = new Reniec();

    

    @Given("^el usuario esta en la pagina de Peruanos en el Extrangero$")
    public void navegateToPageStep(){
       reniec.navegatePage();
       reniec.clickEnPeruanosExtrajero();
    }

    @When("^el usuario despliega la opcion Consulados en el mundo$")
    public void seleccionandoOpcion(){
        reniec.clickenPeruanosMundo();
    }

    @Then("^el usuario realiza una buesqueda y regresa a la anterior pestana$")
    public void abriendoOtrapestana(){
        reniec.linkParaAbrirOtrapestana();
    }



}
