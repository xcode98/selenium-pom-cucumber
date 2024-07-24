@Test
Feature: Navegar por la página de la Reniec
Scenario: Ingresar y navegar en la página de la Reniec
    Given el usuario esta en la pagina de Peruanos en el Extrangero
    When el usuario despliega la opcion Consulados en el mundo
    Then el usuario realiza una buesqueda y regresa a la anterior pestana