 package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.GooglePage;

public class GoogleSteps{

    GooglePage google = new GooglePage();

    @Given("^navego$")
    public void navegarrAGooglee2(){
        google.navegarAGoogle();
    }

    @When("^busco algo$")
    public void buscoEnGoogle(){
        google.enterAlBuscarCriterios();
        google.clickEnBotonBuscar();
    }

    @Then("^obtengo resultados$")
    public void resultadosDeGoogle(){
        //google.firstResult();
        Assert.assertEquals("Facebook - Inicia sesi\u00F3n o reg\u00EDstrate", google.firstResult());
    }

 }