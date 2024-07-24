@Test
Feature: Test Amazon search functionality
Scenario Outline: As a customer when i search for alexa, i want to see if the third option on the second page is avalible for purcharse and can be added to the cart. 
Given the user navigate to www.amazon.com
And search for <product>
When navigate to the page number Siguiente
And select the position 0 from products
Then the user is able to add to the cart 
Examples:
    | product | position | Header 3 |
    | playstation  | Value 2  | Value 3  |

