package steps;

import org.junit.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.TablaLearn;

public class TablaLearnSteps {
    
    TablaLearn tb = new TablaLearn();

    @Given("^Yo navego en una tabla estaticaa$")
    public void metodo1(){
        tb.navegarATablaPage();
    }

    @Then("^Yo puedo regresar el valor si deseoo$")
    public void metodo2(){
        String value = tb.getValueFromGrid(10, 4);
        System.out.println(value);
        Assert.assertEquals("r: 9, c: 3",value);
    }

}
