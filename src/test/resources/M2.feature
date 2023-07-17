#Author: amudhan.nagarajan@netmeds.com

@tag
Feature: Medicine Flow 2
  Medicine Flow 2  with Upload prescription Search for medicines and order medicine using Call from netmeds

  @tag1
  Scenario Outline: Upload Prescription and Search medicine
    Given Check the Browser was already logged in
    And clear the cart
    When click on Upload and Upload Prescription
    And Click on search Medicine,search and Add medicine
    Then Click on proceed and place the order
    And Track the order and cancel the order

  @tag2
  Scenario Outline: Upload prescription and get call on Netmedsd
    Given Check the Browser was already logged in 
    And  clear the cart
    When click on Upload and Upload Prescription
    And Click on Get call from Netmeds and continue
    Then Click on confirm and Place the Order
    And Track the order and cancel the order
    
    @tag3
    Scenario Outline: Saved Prescription and Search medicine
     Given Check the Browser was already logged in 
    When click on Upload and Saved Prescription
    And Click on search Medicine,search and Add medicine
    Then Click on proceed and place the order
    And Track the order and cancel the order

  @tag4
  Scenario Outline: Saved prescription and Get call from netmeds
   Given Check the Browser was already logged in  
    When click on Upload and Saved Prescription
     And Click on Get call from Netmeds and continue
    Then Click on confirm and Place the Order
    And Track the order and cancel the order
