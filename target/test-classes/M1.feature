#Author: your.email@your.domain.com

@tag
Feature: Medicine flow to check and place the order
    

  @tag1
  Scenario: Search the any of the Product and add into the Cart and Place the Order
    Given Check Already Logged in Browser was Opened 
    When Clear the Cart and  Search the Product
    And click on Add to the cart and add the product
    And Click on cart page proceed the Product to Order Page
    Then From Order page choose delivery adress and click on Pay
    And check Payment page was landed
    And Verify the payment status of the order


