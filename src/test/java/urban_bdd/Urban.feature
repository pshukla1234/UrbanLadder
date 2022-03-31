@Urbanladder
Feature: To add items into cart in UrbanLadder website

@UrbanLadderScenario
Scenario: For opening website,adding and validating the cart 
Given the urbanladder website is working
When user selects bookshelves items,applies relevant filters and adds items to cart
Then it validates the cart and checks if items added matches the cart

@openurbanladder
Scenario Outline: open urbanladder
Given user should be on the ulhomepage <browser>
When select storage and bookshelves from homepage
Then It takes you to Bookshelves products page
Examples: 
|browser|
|chrome|

@BookshelvesStorage
Scenario Outline: Sort bookshelves on the basis of filters
Given user should be on bookshelves tab
When user should be able to apply desired filters
Then Desired bookshelves should be visible

@AddtoCart
Scenario Outline: Add to cart 3 items
Given user should select item from desired selection
When click on the products and add to cart in next tab
Then user should be see the updated cart with 3 items

@ValidateCart
Scenario Outline: Validate the cart
Given cart value should be updated
When refresh the home page
Then validate the cart item
