package steps;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ListaCiudadesyPaises;

public class ListaCiudadesyPaisesSteps {
    ListaCiudadesyPaises ls = new ListaCiudadesyPaises();

    @Given("^I navigate to the list page$")
    public void navegarListPage(){
        ls.navegarPagina();
    }

    @When("^I search (.+) in the list$")
    public void escriboInputBusqueda(String city) throws InterruptedException{
        
        ls.realizarBusqueda(city);
        
    }

    /* 
    @Then("^I can find the text in the list$")
    public void ResultadosDeMiBusquedaEnLista(){
        List<String> lista = ls.getAllSearchResults();
        boolean textIsThere = lista.contains("Lima");
        if(textIsThere){
            System.out.println("Tu busqueda se encuentra en la lista");
        }else{
            throw new Error("Tu busqueda no se encuentra en la lista");
        }
    }*/

    /* 
    @Then("^I can find the text in the list$")
    public void ResultadosDeMiBusquedaEnLista()throws InterruptedException{
    
    List<String> lista = ls.getAllSearchResults2();
    boolean textIsThere = lista.contains("Lima,");
    if(textIsThere){
        System.out.println("Tu búsqueda se encuentra en la lista");
    } else{
        throw new AssertionError("Tu búsqueda no se encuentra en la lista");
    }
}*/

@Then("^I can find (.+) in the list$")
public void ResultadosDeMiBusquedaEnLista(String state) throws InterruptedException {
    List<String> lista = ls.getAllSearchResults();
    boolean textIsThere = false;
    
    for (String element : lista) { //recorreme cada string de la lista [0]
        if (element.contains(state)) {
            textIsThere = true;
            break;
        }
    }

    if (textIsThere) {
        System.out.println("Tu búsqueda se encuentra en la lista");
    } else {
        throw new AssertionError("Tu búsqueda no se encuentra en la lista");
    }
}

}
