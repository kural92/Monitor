
@tag
Feature: Limited Time Deal Feature
  From homepage check for limited time deal and place the order.

  @tag1
  Scenario: Limited time deal Medicine Flow
    Given Check and verify already logged in browser was opened successfully
    And Check and clear the cart
    When Go to homepage and check for limited time deal
    And Click on view all and add the product into the cart
    And Check schedule doctor options and proceed the order
    Then Click on select address and Pay button
    And Verify the payment page was landed successfully and place the order

